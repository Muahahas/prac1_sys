package webservices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import beans.*;
import database.*;
import exceptions.*;

@WebService()
public class ManageLocals {
	
	
	private static final DataBaseManager dbm = new DataBaseManager();  

	
	//alta local	
	@WebMethod
	public Local newLocal(Local input) 
			throws MissingNameError,DuplicatedLocalError,WrongTypeLocalError,WrongAddressError,WrongAccessibilityError{		
		
		evaluateLocal(input.getName(),input.getTypeLocal(),input.getAddress(),input.getAccessibility());				
		input.setIdLocal(getNewLocalId());					
		
		//INSERIM LOCAL
		String query = "insert into eaccessible.local(codilocal,coditipolocal,nomcarrer,nomvia,numero,nomlocal,observacions,verificat) "
						+ "values("+input.getIdLocal()+","+input.getTypeLocal()
						+ ",'"+input.getAddress().getStreetName()+"','"+input.getAddress().getType()+"',"+input.getAddress().getNumber()
						+ ",'"+input.getName()+"','"+input.getObservations()+"','"+Local.getCharByBooleanValidated(input.isValidated())+"');";			
		int r = dbm.executeUpdate(query);	
		if(r<=0){
			dbm.log(103);
			return null;
		}
		
		//INSERIM EL INFORME DE ACCESSIBILITAT
		int id_acc = getNewAccessibilityId();
		List<Integer> acc = new ArrayList<>(input.getAccessibility());
		for(int i=0; i<=acc.size()-2; i+=2){
			query = "insert into eaccessible.accessibilitat "
					+ "values("+id_acc+","+input.getIdLocal()+","
					+ acc.get(i)+","+acc.get(i+1)+");";
			r = dbm.executeUpdate(query);
			if(r<=0){
				dbm.log(103);
				return null;
			}
			id_acc++;
		}		
		
		dbm.log(3);
		return input;
	}
	
	//consulta locals
	@WebMethod
	public List<Local> getLocals(Local input, boolean[] paramIsSet) throws MissingSearchCriteriaError{		
		
		String query = buildSearchQuery(input,paramIsSet);		

		ResultSet rs = dbm.executeQuery(query);	
		List<Local> result = new ArrayList<>();
		try {
			if(!rs.next()){
				dbm.closeConnection();
				dbm.log(101);
				return null;
			}
			do{				
				Local l = new Local();	
				l.setIdLocal(rs.getInt("codilocal"));
				l.setName(rs.getString("nomlocal"));
				result.add(l);				
			}while(rs.next());			
		} catch (SQLException e) {
			dbm.closeConnection();
			dbm.log(101);
			System.err.println("getLocals: "+e.getMessage());
			return null;
		}
		dbm.closeConnection();		
		
		dbm.log(1);
		return result;
	}
	
	

	@WebMethod
	public Local getLocalById(int idLocal) throws LocalNotFoundError{
		
		String query = "select * from eaccessible.local where codilocal="+idLocal+";";
		ResultSet rs = dbm.executeQuery(query);
		Local result = new Local();
		try {
			if(!rs.next()){
				dbm.closeConnection();
				dbm.log(102);
				throw new LocalNotFoundError(idLocal);
			}
			
			result.setIdLocal(rs.getInt("codilocal"));
			result.setTypeLocal(rs.getInt("coditipolocal"));
			result.setAddress(new Address(rs.getString("nomcarrer"),rs.getString("nomvia"),rs.getInt("numero")));
			result.setName(rs.getString("nomlocal"));
			result.setObservations(rs.getString("observacions"));
			result.setValidated(Local.getBooleanByCharValidated(rs.getString("verificat").charAt(0)));
		} catch (SQLException e) {
			dbm.closeConnection();
			dbm.log(102);
			System.err.println("getLocalById: "+e.getMessage());
			return null;
		}
		dbm.closeConnection();
		
		result.setAccessibility(getAccessibilityByLocal(idLocal));
		
		dbm.log(2);
		return result;
	}
	
	
	//validació
	@WebMethod
	public boolean validateLocal(int idLocal){
		
		String query = "update eaccessible.local set verificat='S' "
						+ "where codilocal="+idLocal+";";
		int r = dbm.executeUpdate(query);
		
		if(r>0){
			dbm.log(4);
			return true;
		}
		dbm.log(104);
		return false;
	}
	
	//baixa
	@WebMethod
	public boolean removeLocal(int idLocal){
		String query = "delete from eaccessible.accessibilitat where codilocal="+idLocal+"; "
				+"delete from eaccessible.local where codilocal="+idLocal+";";		
		int r = dbm.executeUpdate(query);		
		if(r<=0){
			dbm.log(105);
			return false;
		}
		
		dbm.log(5);
		return true;
	}
	
	//consulta carrers
	@WebMethod
	public List<String> getStreets(){
		String query = "select codvia,nomcar from eaccessible.carrerer;";
		ResultSet rs = dbm.executeQuery(query);		
		List<String> result = new ArrayList<>();
		try {
			if(!rs.next()){
				dbm.closeConnection();
				dbm.log(109);
				return null;
			}
			do
				result.add(rs.getString(1)+", "+rs.getString(2));
			while(rs.next());
		} catch (SQLException e) {
			dbm.closeConnection();
			dbm.log(109);
			System.err.println("getStreets: "+e.getMessage());
			return null;
		}
		dbm.closeConnection();
		dbm.log(9);
		return result;
	}
	
	
	//consulta tipos locals
	@WebMethod
	public List<String> getTypesOfLocals(){
		String query = "select nomtipolocalca from eaccessible.tipolocal;";
		ResultSet rs = dbm.executeQuery(query);		
		List<String> result = new ArrayList<>();
		try {
			if(!rs.next()){
				dbm.closeConnection();
				dbm.log(107);
				return null;
			}
			do
				result.add(rs.getString(1));
			while(rs.next());
		} catch (SQLException e) {
			dbm.closeConnection();
			dbm.log(107);
			System.err.println("getTypesOfLocals: "+e.getMessage());
			return null;
		}
		dbm.closeConnection();
		return result;
	}
	
	//consulta nivells de caracteristiques
	@WebMethod
	public List<String> getLevelsOfCharacteristics(){
		String query = "select nomnivellca from eaccessible.nivell;";
		ResultSet rs = dbm.executeQuery(query);		
		List<String> result = new ArrayList<>();
		try{
			if(!rs.next()){
				dbm.closeConnection();
				dbm.log(107);
				return null;
			}
			do{
				result.add(rs.getString(1));
			}while(rs.next());
		}catch(SQLException e){
			dbm.closeConnection();
			dbm.log(107);
			System.err.println("getLevelsOfCharacteristics: " + e.getMessage());
			return null;
		}
		dbm.closeConnection();
		
		dbm.log(7);
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
		ResultSet rs = dbm.executeQuery(query);		
		try {
			if(!rs.next()){
				dbm.closeConnection();
				dbm.log(108);
				return null;
			}
			do{			
				result.add(new Characteristic(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}while(rs.next());
		}catch (SQLException e) {
			dbm.closeConnection();
			dbm.log(108);
			System.err.println("getCharacteristicsByTypeLocal: "+e.getMessage());
			return null;
		}
		dbm.closeConnection();
		
		dbm.log(8);
		return result;
	}
	
	@WebMethod
	private List<Integer> getAccessibilityByLocal(int idLocal) {
		String query = "select * from eaccessible.accessibilitat "
						+ "where codilocal="+idLocal+";";
		ResultSet rs = dbm.executeQuery(query);
		List<Integer> result = new ArrayList<>();
		try {
			if(!rs.next()){
				dbm.closeConnection();
				return null;
			}
			do{
				result.add(rs.getInt("codicaracteristica"));
				result.add(rs.getInt("valor"));				
			}while(rs.next());
		} catch (SQLException e) {
			dbm.closeConnection();
			System.err.println("getAccessibilityByLocal: "+e.getMessage());
			return null;
		}
		dbm.closeConnection();
		return result;
	}
	
	
	//consulta logs
	@WebMethod
	public List<LogEvent> getLogByDate(String date) {
		return null;
	}
	
	@WebMethod
	public List<LogEvent> getLogByDateAndTypeEvent(String date, int typeEvent){
		return null;
	}
	
	@WebMethod 
	public List<String> getLogTypeEvents() {
		return null;
	}
	

	/******************** P R I V A T E   M E T H O D S*****************************************************************/
	

	private void evaluateLocal(String name, int typeLocal, Address addr, List<Integer> acc) 
			throws MissingNameError,DuplicatedLocalError,WrongTypeLocalError,WrongAddressError,WrongAccessibilityError {		
		
		if(name.isEmpty()){
			dbm.log(103);
			throw new MissingNameError();
		}
		
		if(isDuplicatedLocal(name,addr)){
			dbm.log(103);
			throw new DuplicatedLocalError();
		}
				
		if(!hasValidTypeLocal(typeLocal)){
			dbm.log(103);
			throw new WrongTypeLocalError();
		}
		
		if(!hasValidAddress(addr)){
			dbm.log(103);
			throw new WrongAddressError();
		}
		
		if(!hasValidAccessibility(acc,typeLocal)){
			dbm.log(103);
			throw new WrongAccessibilityError();
		}

	}

	
	
	/***************** GENERACIÓ DE IDs *****************************************/
	
	private int getNewLocalId() {		
		return dbm.getLastIntElement("codilocal","eaccessible.local") + 1;
	}
	
	private int getNewAccessibilityId() {
		return dbm.getLastIntElement("codiaccessibilitat","eaccessible.accessibilitat") + 1;
	}
	
	
	/****************** EVALUACIONS DE LOCAL ***********************************/
	
	private boolean isDuplicatedLocal(String name, Address addr) {
		String query = "select nomlocal "
						+ "from eaccessible.local "
						+ "where nomlocal='"+name+"' and "
						+ "nomcarrer='"+addr.getStreetName()+"' and numero="+addr.getNumber()+";";
		ResultSet rs = dbm.executeQuery(query);
		try {
			if(rs.next()) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private boolean hasValidAccessibility(List<Integer> acc, int typeLocal) {
		// TODO comprobar que les caracteristiques pertanyen al tipo local
		//si ens sobra temps ja ho farem...
		return true;
	}


	private boolean hasValidAddress(Address addr) {
		
		if(addr.getStreetName().isEmpty() || addr.getType().isEmpty() || addr.getNumber() <= 0)
			return false;
		
		String query = "select * "
						+ "from eaccessible.carrerer "
						+ "where codvia='"+addr.getType()+"' "
						+ "and nomcar='"+addr.getStreetName()+"';";
		ResultSet rs = dbm.executeQuery(query);
		try {
			if(rs.next()) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

	private boolean hasValidTypeLocal(int typeLocal) {
		
		String query = "select * "
						+ "from eaccessible.tipolocal "
						+ "where coditipolocal="+typeLocal+";";
		ResultSet rs = dbm.executeQuery(query);
		try {
			if(rs.next()) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	private String buildSearchQuery(Local input, boolean[] paramIsSet) throws MissingSearchCriteriaError {
		
		String initQuery = "select * from eaccessible.local where ";
		String query = initQuery;				
		
		if(paramIsSet[0]) query += "nomlocal='" + input.getName() + "' ";
		if(paramIsSet[1]){
			if(paramIsSet[0]) query += "and ";
			query += "coditipolocal=" + input.getTypeLocal() + " ";
		}
		if(paramIsSet[2]){
			if(paramIsSet[0] || paramIsSet[1]) query += "and ";
			query += "nomvia='" + input.getAddress().getType() + "' and nomcarrer='" + input.getAddress().getStreetName() + "' ";
		}
		if(paramIsSet[3]){
			if(paramIsSet[0] || paramIsSet[1] || paramIsSet[2]) query += "and ";
			query += "verificat='" + Local.getCharByBooleanValidated(input.isValidated()) + "' ";
		}
		
		if(query == initQuery) throw new MissingSearchCriteriaError();
		
		return query;
	}
}