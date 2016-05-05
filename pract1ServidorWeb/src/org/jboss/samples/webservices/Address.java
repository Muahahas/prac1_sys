package org.jboss.samples.webservices;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Address {
	
	private int idStreet;     
	private String type;
	private String streetName;
	private int num;
	
	public Address(String type, String streetName, int num) throws WrongAddressError{
		
		if(type.isEmpty() || streetName.isEmpty() || num <= 0)
			throw new WrongAddressError();
		
		this.type = type;
		this.streetName = streetName;
		this.num = num;	
		this.idStreet = getIdStreet(type,streetName);
	}	

	public int getIdStreet() {
		return idStreet;
	}

	public String getType() {
		return type;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getNumBuilding() {
		return num;
	}

	private int getIdStreet(String type, String street) {
		int id=0;
		try     
		{			
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup( "java:jboss/PostgreSQL/eAccessible");							
					
			Connection connection = ds.getConnection();
			Statement stm = connection.createStatement();
			String query = "select codcar "
							+"from carrerer "
							+ "where codvia="+type+" and nomcar='"+street+"';";
			ResultSet rs=stm.executeQuery(query);
			id=rs.getInt(1);
				
			connection.close();
			stm.close();			
		}catch(Exception e){}
		
		return id;
	}
	
	

}
