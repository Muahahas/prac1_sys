package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Address;
import beans.Local;

public class DataBaseManager {
	
	private final String jndi_database = "java:jboss/PostgreSQL/eAccessible";
	private final String jndi_log      = "java:jboss/PostgreSQL/log";
	private Statement stm;
	private Connection connection;
	
	
	public DataBaseManager() {
		//initTypeOfEventsTable();
	}


	public void insertLocal(Local l) {
		
		//INSERIM LOCAL
		String query = "insert into eaccessible.local(codilocal,coditipolocal,nomcarrer,nomvia,numero,nomlocal,observacions,verificat) "
						+ "values("+l.getIdLocal()+","+l.getTypeLocal()
						+ ",'"+l.getAddress().getStreetName()+"','"+l.getAddress().getType()+"',"+l.getAddress().getNumber()
						+ ",'"+l.getName()+"','"+l.getObservations()+"','"+Local.getCharByBooleanValidated(l.isValidated())+"');";			
		int r = executeUpdate(query);		
		
		//INSERIM EL INFORME DE ACCESSIBILITAT
		int id_acc = getNewAccessibilityId();
		List<Integer> acc = new ArrayList<>(l.getAccessibility());
		System.out.println("size: "+acc.size());
		for(int i=0; i<=acc.size()-2; i+=2){
			System.out.println("acc: "+ acc.get(i));
			query = "insert into eaccessible.accessibilitat "
					+ "values("+id_acc+","+l.getIdLocal()+","
					+ acc.get(i)+","+acc.get(i+1)+");";
			r = executeUpdate(query);				
			System.out.println(r);
			id_acc++;
		}		
		
	}
	
	
	/***************** GENERACIÓ DE IDs *****************************************/
	
	public int getNewLocalId() {		
		return getLastIntElement("codilocal","local") + 1;
	}
	
	public int getNewAccessibilityId() {
		return getLastIntElement("codiaccessibilitat","accessibilitat") + 1;
	}
	
	
	/****************** EVALUACIONS DE LOCAL ***********************************/
	
	public boolean isDuplicatedLocal(String name, Address addr) {
		String query = "select nomlocal "
						+ "from eaccessible.local "
						+ "where nomlocal='"+name+"' and "
						+ "nomcarrer='"+addr.getStreetName()+"' and numero="+addr.getNumber()+";";
		ResultSet rs = executeQuery(query);
		if(rs == null) return true;
		return false;
	}

	public boolean hasValidAccessibility(List<Integer> acc, int typeLocal) {
		// TODO comprobar que les caracteristiques pertanyen al tipo local
		//si ens sobra temps ja ho farem...
		return true;
	}


	public boolean hasValidAddress(Address addr) {
		
		if(addr.getStreetName().isEmpty() || addr.getType().isEmpty() || addr.getNumber() <= 0)
			return false;
		
		String query = "select * "
						+ "from eaccessible.carrerer "
						+ "where codvia='"+addr.getType()+"' "
						+ "and nomcar='"+addr.getStreetName()+"';";
		ResultSet rs = executeQuery(query);
		if(rs != null) return true;
		
		return false;
	}
	

	public boolean hasValidTypeLocal(int typeLocal) {
		
		String query = "select * "
						+ "from eaccessible.tipolocal "
						+ "where coditipolocal="+typeLocal+";";
		ResultSet rs = executeQuery(query);
		if(rs != null) return true;
		
		return false;
	}
	
	
	/****************** ALTRES ***********************************/
	
	public int getLastIntElement(String col, String table) {
		int element = 0;		
		String query = "select " + col
						+ " from eaccessible."+ table
						+ " ORDER BY "+col+" DESC LIMIT 1;"; 
		ResultSet rs = executeQuery(query);			
		try {
			rs.next();
			element = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		return element;	
	}
	
	public ResultSet executeQuery(String query) {		
		ResultSet rs = null;		
		try     
		{			
			initConnection(jndi_database);
			rs = stm.executeQuery(query);				
		}catch(SQLException e){
			System.out.println("EXECUTE QUERY: " + e.getMessage());
		}
		return rs;
	}
	
	public int executeUpdate(String query) {
		int result = -1;
		try     
		{			
			initConnection(jndi_database); 
			result = stm.executeUpdate(query);		
		}catch(SQLException e){
			System.out.println("EXECUTE UPDATE: " + e.getMessage());
		}finally{
			closeConnection();
		}
		return result;
	}
	
	private void initConnection(String jndi) {
		
		try {
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup(jndi);				
			connection = ds.getConnection();
			stm = connection.createStatement();
		} catch (NamingException | SQLException e) {
			System.out.println("INIT CONNECTION: " + e.getMessage());
		}
	}
	
	//S'ha de cridar després d'haver fet executeQuery/Update i havent extret les dades del ResultSet
	public void closeConnection(){
		try {
			connection.close();
			stm.close();
		} catch (SQLException e) {
			System.out.println("CLOSE CONNECTION: " + e.getMessage());
		}
	}
	
	
	private void initTypeOfEventsTable() {
		List<String> msg = new ArrayList<>();
		msg.add("S'han cercat locals en la base de dades.");     				//getLocals
		msg.add("S'ha consultat un local."); 					 				//getLocalById
		msg.add("S'ha afegit un nou local a la base de dades."); 				//newLocal
		msg.add("S'ha verificat un local.");					 				//validateLocal
		msg.add("S'ha eliminat un local de la base de dades.");  				//removeLocal		
		msg.add("S'han consultat els tipus de locals.");              			//getTypesOfLocals
		msg.add("S'han consultat els nivells de caracteristiques.");  			//getLevelsOfCharacteristics
		msg.add("S'han consultat les caracteristiques d'un tipus de local.");  	//getCharacteristicsByTypeLocal
		
		msg.add("S'ha produit un error en la cerca de locals.");
		msg.add("S'ha produit un error en la consulta d'un local.");
		msg.add("S'ha produit un error en la verificacio d'un local.");
		msg.add("S'ha produit un error en la eliminacio d'un local.");
		
		
		
		for(int i=0; i<msg.size(); i++){
			String query = "UPDATE log.tipusIncidencia "
					+ "SET descripcio='" + msg.get(i) + "' WHERE codiTipusIncidencia=" + i+1 + ";" 
					+ "IF NOT FOUND THEN "
					+ "INSERT INTO log.tipusIncidencia values (" + i+1 + ",'" + msg.get(i) + "');"
					+ "END IF;";
			initConnection(jndi_log);
			try     
			{			 
				stm.executeUpdate(query);		
			}catch(SQLException e){
				System.out.println("EXECUTE UPDATE: " + e.getMessage());
			}
			closeConnection();
		}
				
		
	}

}