package org.jboss.webservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.*;
import exceptions.*;

@WebService()
public class ManageLocals {
	
	
	private final String jndi_database = "java:jboss/PostgreSQL/eAccessible";
	private final String jndi_log      = "java:jboss/PostgreSQL/log";
	private Statement stm;
	private Connection connection;

	//alta local	
	@WebMethod
	public Local newLocal(Local input) 
			throws MissingNameError,DuplicatedLocalError,WrongTypeLocalError,WrongAddressError,WrongAccessibilityError{		
		
		evaluateLocal(input.getName(),input.getTypeLocal(),input.getAddress(),input.getAccessibility());				
		input.setIdLocal(getNewLocalId());					
		insertLocal(input);		 
		
		return input;
	}
	
	//consulta locals
	@WebMethod
	public List<Local> getLocals(Local input, boolean[] paramIsSet) throws MissingSearchCriteriaError{		
		
		String query = buildDynamicQuery(input,paramIsSet);		

		ResultSet rs = executeQuery(query);		
		List<Local> result = new ArrayList<>();
		try {
			while(rs.next()){				
				Local l = new Local();	
				l.setIdLocal(rs.getInt("codilocal"));
				l.setName(rs.getString("nomlocal"));
				result.add(l);				
			}			
		} catch (SQLException e) {}
		closeConnection();		
		return result;
	}
	
	

	@WebMethod
	public Local getLocalById(int idLocal) throws LocalNotFoundError{
		
		String query = "select * from eaccessible.local where codilocal="+idLocal+";";
		ResultSet rs = executeQuery(query);
		if(rs == null) throw new LocalNotFoundError(idLocal);
		Local result = new Local();
		try {
			rs.next();
			result.setIdLocal(rs.getInt("codilocal"));
			result.setTypeLocal(rs.getInt("coditipolocal"));
			result.setAddress(new Address(rs.getString("nomcarrer"),rs.getString("nomvia"),rs.getInt("numero")));
			result.setName(rs.getString("nomlocal"));
			result.setObservations(rs.getString("observacions"));
			result.setValidated(Local.getBooleanByCharValidated(rs.getString("verificat").charAt(0)));
		} catch (SQLException e) {}
		closeConnection();
		
		result.setAccessibility(getAccessibilityByLocal(idLocal));
		
		return result;
	}
	
	
	//validació
	@WebMethod
	public boolean validateLocal(int idLocal){
		return false;
	}
	
	//baixa
	@WebMethod
	public boolean removeLocal(int idLocal){
		return false;
	}
	
	//consulta carrers
	@WebMethod
	public List<String> getStreets(){
		String query = "select codvia,nomcar from eaccessible.carrerer;";
		ResultSet rs = executeQuery(query);
		List<String> result = new ArrayList<>();
		try {
			while(rs.next())
				result.add(rs.getString(1)+", "+rs.getShort(2));
		} catch (SQLException e) {}
		closeConnection();
		return result;
	}
	
	
	//consulta tipos locals
	@WebMethod
	public List<String> getTypesOfLocals(){
		String query = "select nomtipolocalca from eaccessible.tipolocal;";
		ResultSet rs = executeQuery(query);
		List<String> result = new ArrayList<>();
		try {
			while(rs.next())
				result.add(rs.getString(1));
		} catch (SQLException e) {}
		closeConnection();
		return result;
	}
	
	//consulta nivells de caracteristiques
	@WebMethod
	public List<String> getLevelsOfCharacteristics(){
		String query = "select nomnivellca from eaccessible.nivell;";
		ResultSet rs = executeQuery(query);
		List<String> result = new ArrayList<>();
		try{
			while(rs.next()){
				result.add(rs.getString(1));
			}
		}catch(SQLException e){}
		closeConnection();
		return result;
	}
	
	//consulta caracteristiques
	@WebMethod
	public List<Characteristic> getCharacteristicsByTypeLocal(int typeLocal){
		List<Characteristic> result = new ArrayList<>();
		String query = "select c.codicaracteristica,c.nomcaracteristicaca,c.tipo,c.codinivell "
						+ "from eaccessible.caracteristica c, eaccessible.caracteristicatipolocal ctl "
						+ "where c.codicaracteristica=ctl.codicaracteristica "
						+ "and ctl.coditipolocal="+typeLocal+";";
		ResultSet rs = executeQuery(query);
		try {
			while(rs.next()){			
				result.add(new Characteristic(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		}catch (SQLException e) {}
		closeConnection();
		return result;
	}
	
	@WebMethod
	private List<Integer> getAccessibilityByLocal(int idLocal) {
		String query = "select * from eaccessible.accessibilitat "
						+ "where codilocal="+idLocal+";";
		ResultSet rs = executeQuery(query);
		List<Integer> result = new ArrayList<>();
		try {
			while(rs.next()){
				result.add(rs.getInt("codicaracteristica"));
				result.add(rs.getInt("valor"));				
			}
		} catch (SQLException e) {}
		closeConnection();
		return result;
	}

	/******************** P R I V A T E   M E T H O D S*****************************************************************/
	

	private void evaluateLocal(String name, int typeLocal, Address addr, List<Integer> acc) 
			throws MissingNameError,DuplicatedLocalError,WrongTypeLocalError,WrongAddressError,WrongAccessibilityError {		
		
		if(name.isEmpty())
			throw new MissingNameError();
		
		if(isDuplicatedLocal(name,addr))
			throw new DuplicatedLocalError();
				
		if(!hasValidTypeLocal(typeLocal))
			throw new WrongTypeLocalError();			
		
		if(!hasValidAddress(addr))
			throw new WrongAddressError();
		
		if(!hasValidAccessibility(acc,typeLocal))
			throw new WrongAccessibilityError();

	}
	
	
	private void insertLocal(Local l) {
		
		//INSERIM LOCAL
		String query = "insert into eaccessible.local "
						+ "values("+l.getIdLocal()+","+l.getTypeLocal()+",null,"
						+ "'"+l.getAddress().getStreetName()+"','"+l.getAddress().getType()+"',"
						+ l.getAddress().getNumber()+",'"+l.getName()+"','"+l.getObservations()+"','"
						+ Local.getCharByBooleanValidated(l.isValidated())+"',null,null,null,null,null,null,null);";			
		int r = executeUpdate(query);		
		
		//INSERIM EL INFORME DE ACCESSIBILITAT
		int id_acc = getNewAccessibilityId();
		for(int i=0; i<=l.getAccessibility().size()-2; i+=2){
			id_acc++;
			query = "insert into eaccessible.accessibilitat "
					+ "values("+id_acc+","+l.getIdLocal()+","
					+l.getAccessibility().get(i)+","+l.getAccessibility().get(i+1)+");";
			r = executeUpdate(query);						
		}		
		
	}
	
	
	private String buildDynamicQuery(Local input, boolean[] paramIsSet) throws MissingSearchCriteriaError {
		
		String initQuery = "select * from eaccessible.local where ";
		String query = initQuery;				
		
		if(paramIsSet[1]) query += "nomlocal='" + input.getName() + "' ";
		if(paramIsSet[2]){
			if(paramIsSet[1]) query += "and ";
			query += "tipolocal=" + input.getTypeLocal() + " ";
		}
		if(paramIsSet[3]){
			if(paramIsSet[1] || paramIsSet[2]) query += "and ";
			query += "nomvia='" + input.getAddress().getType() + "' and nomcarrer='" + input.getAddress().getStreetName() + "' ";
		}
		if(paramIsSet[4]){
			if(paramIsSet[1] || paramIsSet[2] || paramIsSet[3]) query += "and ";
			query += "verificat='" + Local.getCharByBooleanValidated(input.isValidated()) + "' ";
		}
		
		if(query == initQuery) throw new MissingSearchCriteriaError();
		
		return query;
	}
	
	
	/**************************** E V A L U T A E   L O C A L ***********************************************************************/


	private boolean isDuplicatedLocal(String name, Address addr) {
		String query = "select name "
						+ "from local "
						+ "where nomlocal='"+name+"' and "
						+ "nomcarrer='"+addr.getStreetName()+"' and numero="+addr.getNumber()+";";
		ResultSet rs = executeQuery(query);
		if(rs != null) return false;
		return true;
	}

	private boolean hasValidAccessibility(List<Integer> acc, int typeLocal) {
		// TODO comprobar que les caracteristiques pertanyen al tipo local
		//si ens sobra temps ja ho farem...
		return true;
	}


	private boolean hasValidAddress(Address addr) {
		
		if(addr.getStreetName().isEmpty() || addr.getType().isEmpty() || addr.getNumber() <= 0)
			return false;
		
		String query = "select codcar "
						+ "from carrerer "
						+ "where codvia='"+addr.getType()+"' "
						+ "and nomcar='"+addr.getStreetName()+"';";
		ResultSet rs = executeQuery(query);
		if(rs == null) return false;
		
		return true;
	}
	

	private boolean hasValidTypeLocal(int typeLocal) {
		
		String query = "select typeLocal "
						+ "from tipolocal "
						+ "where coditipolocal="+typeLocal+";";
		ResultSet rs = executeQuery(query);
		if(rs != null) return true;
		
		return false;
	}
	
	/**************************************** G E N E R A T E   I D s **************************************************************/
	
	private int getNewLocalId() {		
		return getLastIntElement("codilocal","local") + 1;
	}
	
	private int getNewAccessibilityId() {
		return getLastIntElement("codiaccessibilitat","accessibilitat") + 1;
	}
	
	private int getLastIntElement(String col, String table) {
		int element = 0;		
		String query = "select " + col
						+ " from "+ table
						+ " ORDER BY codiLocal DESC LIMIT 1;"; 
		ResultSet rs = executeQuery(query);			
		try {
			element = rs.getInt(1);
		} catch (SQLException e) {}
		
		return element;	
	}
	
	
	/************************************* D B   O P E R A T I O N S *****************************************************************/
	
	
	private ResultSet executeQuery(String query) {		
		ResultSet rs = null;		
		try     
		{			
			initConnection();
			rs = stm.executeQuery(query);				
		}catch(SQLException e){
			System.out.println("EXECUTE QUERY: " + e.getMessage());
		}
		return rs;
	}
	
	private int executeUpdate(String query) {
		int result = -1;
		try     
		{			
			initConnection(); 
			result = stm.executeUpdate(query);			
		
		}catch(SQLException e){
			System.out.println("EXECUTE UPDATE: " + e.getMessage());
		}finally{
			closeConnection();
		}
		return result;
	}
	
	private void initConnection() {
		
		try {
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup(jndi_database);				
			connection = ds.getConnection();
			stm = connection.createStatement();
		} catch (NamingException | SQLException e) {
			System.out.println("INIT CONNECTION: " + e.getMessage());
		}
	}
	
	//S'ha de cridar després d'haver fet executeQuery/Update i havent extret les dades del ResultSet
	private void closeConnection(){
		try {
			connection.close();
			stm.close();
		} catch (SQLException e) {
			System.out.println("CLOSE CONNECTION: " + e.getMessage());
		}
	}
}
