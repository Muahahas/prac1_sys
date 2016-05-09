package org.jboss.samples.webservices;


import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.*;



public class Local {
	
	private final Local local;
	
	
	public Local(Local lb) throws Exception{

		evaluateParams(lb.getName(),lb.getTypeLocal(),lb.getAddress(),lb.getAccessibility());		
		lb.setId(setNewId());
		this.local = lb;		
	}


	private void evaluateParams(String name, int typeLocal, Address addr, int[] acc) throws Exception {
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


	//nomes mirem el codi carrerer
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
			valid=stm.execute("select codcar from carrerer where codcar="+addr.getIdStreet()+";");
				
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
