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

import beans.LogEvent;

public class DataBaseManager {
	
	private final String jndi_database = "java:jboss/PostgreSQL/eAccessible";
	private final String jndi_log      = "java:jboss/PostgreSQL/incidencia";
	
	private final List<String> info = new ArrayList<>();
	private final List<String> err = new ArrayList<>();
	
	private Statement stm;
	private Connection connection;
	
	
	public DataBaseManager() {
		info.add("Consulta de locals");     							//getLocals
		info.add("Consulta d''un local"); 					 			//getLocalById
		info.add("Inserció de local"); 									//newLocal
		info.add("Verificació de local");					 			//validateLocal
		info.add("Eliminació de local");  								//removeLocal		
		info.add("Consulta de tipus locals");              				//getTypesOfLocals
		info.add("Consulta de nivells de caracteristiques");  			//getLevelsOfCharacteristics
		info.add("Consulta de caracteristiques d''un tipus de local"); //getCharacteristicsByTypeLocal
		info.add("Consulta de carrerer");
		// AQUI AFEGIR NOUS MISSATGES DE INFO

		err.add("Error cercant locals");
		err.add("Error consultant un local");
		err.add("Error inserint un local");
		err.add("Error verificant un local.");
		err.add("Error eliminant un local.");
		err.add("Error consultant els tipus de locals");
		err.add("Error consultant els nivells de caracteristiques");
		err.add("Error consultant les caracterisqtiques d''un tipus de local");
		err.add("Error consultant el carrerer");
		// AQUI AFEGIR NOUS MISSATGES DE ERROR
		
		initTypeOfEventsTable(info,err);
	}
	
	
	public void log(int id) {
		int id_incidencia = getLastIntElement("\"idIncidencia\"","log.incidencia",jndi_log) + 1;
		/*
		Date d = new Date();
		DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		String date = dateFormat1.format(d);		
		DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
		String timestamp = dateFormat2.format(d); 
		*/
		String query = "insert into log.incidencia "
				+ "values("+id_incidencia+",now(),now(),"+id+");";
		executeUpdate(query,jndi_log);
		if(id<100) System.out.println(id+" - "+info.get(id-1));
		else	   System.err.println(id+" - "+err.get(id-100-1));
		
	}


	
	public int getLastIntElement(String col, String table) {
		int element = 0;		
		String query = "select " + col
						+ " from " + table
						+ " ORDER BY "+col+" DESC LIMIT 1;"; 
		ResultSet rs = executeQuery(query);
		try {
			if(!rs.next()) return 0;
			element = rs.getInt(1);
		} catch (SQLException e) {
			System.err.println("getLastIntElement: "+e.getMessage());
		}
		closeConnection();
		return element;	
	}
	
	public int getLastIntElement(String col, String table, String jndi) {
		int element = 0;		
		String query = "select " + col
						+ " from " + table
						+ " ORDER BY "+col+" DESC LIMIT 1;"; 
		ResultSet rs = executeQuery(query,jndi);
		try {
			if(!rs.next()) return 0;
			element = rs.getInt(1);
		} catch (SQLException e) {
			System.err.println("getLastIntElement: "+e.getMessage());
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
			System.err.println("EXECUTE QUERY: " + e.getMessage());
		}
		return rs;
	}
	
	public ResultSet executeQuery(String query, String jndi) {		
		ResultSet rs = null;		
		try     
		{			
			initConnection(jndi);
			rs = stm.executeQuery(query);				
		}catch(SQLException e){
			System.err.println("EXECUTE QUERY: " + e.getMessage());
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
			System.err.println("EXECUTE UPDATE: " + e.getMessage());
		}finally{
			closeConnection();
		}
		return result;
	}
	
	public int executeUpdate(String query,String jndi) {
		int result = -1;
		try     
		{			
			initConnection(jndi); 
			result = stm.executeUpdate(query);		
		}catch(SQLException e){
			System.err.println("EXECUTE UPDATE: " + e.getMessage());
		}finally{
			closeConnection();
		}
		return result;
	}
	
	
	//S'ha de cridar després d'haver fet executeQuery i havent extret les dades del ResultSet
	public void closeConnection(){
		try {
			connection.close();
			stm.close();
		} catch (SQLException e) {
			System.err.println("CLOSE CONNECTION: " + e.getMessage());
		}
	}
	
	
	/************* PRIVATE METHODS *****************************************/
	
	private void initConnection(String jndi) {
		
		try {
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup(jndi);				
			connection = ds.getConnection();
			stm = connection.createStatement();
		} catch (NamingException | SQLException e) {
			System.err.println("INIT CONNECTION: " + e.getMessage());
		}
	}
	
	
	private void initTypeOfEventsTable(List<String> info, List<String> err) {
		System.out.println("Inicialitzant la taula tipusIncidencia...");
		
		initConnection(jndi_log);
		
		int id=1;
		for(int i=0; i<info.size(); i++){
			String query = "do $$ begin "
					+ "UPDATE log.\"tipusIncidencia\" "
					+ "SET descripcio='" + info.get(i) + "' WHERE \"codiTipusIncidencia\"=" + id + "; " 
					+ "IF NOT FOUND THEN "
					+ "INSERT INTO log.\"tipusIncidencia\" values (" + id + ",'" + info.get(i) + "'); "
					+ "END IF; end $$";			
			try     
			{			 
				stm.executeUpdate(query);		
			}catch(SQLException e){
				System.err.println("initTypeOfEventsTable: " + e.getMessage());
			}
			id++;
			
		}
		
		id=101;
		for(int i=0; i<err.size(); i++){
			String query = "do $$ begin "
					+ "UPDATE log.\"tipusIncidencia\" "
					+ "SET descripcio='" + err.get(i) + "' WHERE \"codiTipusIncidencia\"=" + id + "; " 
					+ "IF NOT FOUND THEN "
					+ "INSERT INTO log.\"tipusIncidencia\" values (" + id + ",'" + err.get(i) + "'); "
					+ "END IF; end $$";			
			try     
			{			 
				stm.executeUpdate(query);		
			}catch(SQLException e){
				System.err.println("initTypeOfEventsTable: " + e.getMessage());
			}
			id++;
			
		}
		
		closeConnection();
				
		
	}


	public List<LogEvent> getLog(String start, String end, int type) {
		String query = "select i.*,ti.descripcio from log.incidencia i, log.\"tipusIncidencia\" ti "
						+ "where i.data between '"+start+"' and '"+end+"' "
						+ "and i.\"codiTipusIncidencia\"=ti.\"codiTipusIncidencia\" ";
		if(type>0) query += "and i.\"codiTipusIncidencia\"="+type+";";
		
		List<LogEvent> result = new ArrayList<>();
		ResultSet rs = executeQuery(query,jndi_log);
		try {
			if(!rs.next()){
				closeConnection();
				return null;
			}
			do{
				result.add(new LogEvent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
			}while(rs.next());
		} catch (SQLException e) {
			closeConnection();
			System.err.println("getLog: "+e.getMessage());
			return null;
		}
		closeConnection();
		return result;
	}


	public List<String> getTypeEvents() {
		String query = "select descripcio from log.\"tipusIncidencia\";";
		List<String> result = new ArrayList<>();
		
		ResultSet rs = executeQuery(query,jndi_log);
		try {
			if(!rs.next()){
				closeConnection();
				return null;
			}
			do{
				result.add(rs.getString(1));
			}while(rs.next());
		} catch (SQLException e) {
			closeConnection();
			System.err.println("getTypeEvents: "+e.getMessage());
			return null;
		}
		closeConnection();
		return result;
	}


}
