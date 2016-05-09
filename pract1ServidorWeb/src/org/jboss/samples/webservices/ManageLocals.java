package org.jboss.samples.webservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.Address;
import beans.Local;

@WebService()
public class ManageLocals {

	//alta	
	@WebMethod
	public Local newLocal(Local l) throws Exception{
		
		
		evaluateLocal(l.getName(),l.getTypeLocal(),l.getAddress(),l.getAccessibility());		
		l.setId(setNewId());	
		
		
		//TODO insert into local
		// update accessibilitat 
		
		return l;
	}
	
	//consulta locals
	
	
	//validació
	
	
	//baixa
	
	//consulta carrers
	
	//consulta tipos locals
	
	//consulta caract. segons tipo local
	
	
	/******************** P R I V A T E *****************************************************************/
	
	private void evaluateLocal(String name, int typeLocal, Address addr, int[] acc) throws Exception {
		if(name.isEmpty())
			throw new MissingNameError();
				
		if(!isValidTypeLocal(typeLocal))
			throw new WrongTypeLocalError();			
		
		if(!isValidAddress(addr))
			throw new WrongAddressError();
		
		if(!isValidAccessibility(acc,typeLocal))
			throw new WrongAccessibilityError();

	}


	private boolean isValidAccessibility(int[] acc, int typeLocal) {
		// TODO comprobar que les caracteristiques pertanyen al tipo local
		//si ens sobra temps ja ho farem...
		return true;
	}


	//comprova q sigui valida i ademes assigna el seu id
	private boolean isValidAddress(Address addr) {
		boolean valid = false;
		if(addr.getStreetName().isEmpty() || addr.getType().isEmpty() || addr.getNumBuilding() <= 0)
			return false;
		try     
		{			
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup( "java:jboss/PostgreSQL/eAccessible");						
					
			Connection connection = ds.getConnection();
			Statement stm = connection.createStatement(); 
			ResultSet rs = stm.executeQuery("select codcar "
								+ "from carrerer "
								+ "where codvia='"+addr.getType()+"'"
								+ "and nomcar='"+addr.getStreetName()+"';");
			//addr.setIdStreet(rs.getInt(1)); 
			valid = true;
			connection.close();
			stm.close();			
		}catch(Exception e){}
		
		return valid;
	}


	private boolean isValidTypeLocal(int typeLocal) {
		boolean valid = false;
		try     
		{			
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup( "java:jboss/PostgreSQL/eAccessible");							
					
			Connection connection = ds.getConnection();
			Statement stm = connection.createStatement(); 
			valid=stm.execute("select typeLocal from tipolocal where coditipolocal="+typeLocal+";");
				
			connection.close();
			stm.close();			
		}catch(Exception e){}
		
		return valid;
	}
	
	
	//id = ultim id de local + 1
	private int setNewId() {
		int id = 0;
		try     
		{			
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup( "java:jboss/PostgreSQL/eAccessible");							
					
			Connection connection = ds.getConnection();
			Statement stm = connection.createStatement();
			String query = "select codiLocal "
							+"from local "
							+"ORDER BY codiLocal DESC LIMIT 1;";
			ResultSet rs=stm.executeQuery(query);
			id = rs.getInt(1) + 1;	
			connection.close();
			stm.close();			
		}catch(Exception e){}
		
		return id;
	}
}
