package org.jboss.samples.webservices;

import java.sql.*;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Local {
	
	private int idLocal;
	private String name;
	private int typeLocal;
	private Address address;
	private int[] accessibility;	//[codi_caract1,valor1, ...] 
	private String observations;
	private Coord coordenates;
	private boolean validated;
	
	
	public Local(String name, int typeLocal, Address addr, int[] acc, String obs, Coord xy) throws Exception{

		evaluateParams(name,typeLocal,addr,acc);		
		
		this.idLocal   = setNewId();
		this.name      = name;
		this.typeLocal = typeLocal;
		this.address   = addr;  //ojo...
		for(int i=0; i<acc.length; i++) 
			this.accessibility[i]=acc[i];		
		
		if(!obs.isEmpty())
			this.observations=obs;
		if(xy != null)
			this.coordenates=xy;  //ojo...
		
		this.validated=false;		
	}


	private void evaluateParams(String name, int typeLocal, Address addr, int[] acc) throws Exception {
		if(name.isEmpty())
			throw new MissingNameError();
				
		if(!isValidTypeLocal(typeLocal))
			throw new WrongTypeLocalError();			
		
		if(!isValidAddress(addr.getIdStreet()))
			throw new WrongAddressError();
		
		if(!isValidAccessibility(acc,typeLocal))
			throw new WrongAccessibilityError();
	}


	//comprobar que les caracteristiques pertanyen al tipo local
	private boolean isValidAccessibility(int[] acc, int typeLocal) {
		// TODO Auto-generated method stub 
		//si ens falta temps ja ho farem...
		return true;
	}


	//nomes mirem el codi carrerer
	private boolean isValidAddress(int idStreet) {
		boolean valid = false;
		try     
		{			
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup( "java:jboss/PostgreSQL/eAccessible");							
					
			Connection connection = ds.getConnection();
			Statement stm = connection.createStatement(); 
			valid=stm.execute("select codcar from carrerer where codcar="+idStreet+";");
				
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
	
	public int getId(){
		return idLocal;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeLocal() {
		return typeLocal;
	}

	public void setTypeLocal(int typeLocal) {
		this.typeLocal = typeLocal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public boolean isValidLocal() {
		return validated;
	}

	public void setValidLocal(boolean valid) {
		this.validated = valid;
	}
	
	public Coord getCoordenates(){
		return this.coordenates;
	}
	
	public void setCoordenates(Coord xy){
		this.coordenates=xy;
	}
	
	public int[] getAccessibility(){
		return this.accessibility;
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
