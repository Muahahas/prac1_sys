package org.jboss.samples.webservices;

public class Local {
	
	private int id;
	private String name;
	private int typeLocal;
	private Address address;
	private int[] accessibility;	//[codi_caract1,valor1, ...] 
	private String observations;
	private Coord coordenates;
	private boolean validated;
	
	
	public Local(String name, int typeLocal, Address adr, int[] acc){
		this.name = name;
		this.typeLocal = typeLocal;
		this.accessibility = acc;  //crec que no es pot tal qual...
		this.address = adr;
		this.observations="";
		this.validated=false;
		this.id=setNewId();
	}


	public Local(String name, int typeLocal, Address adr, int[] caract, String obs){
		//TODO patró builder
	}
	
	public Local(String name, int typeLocal, Address adr, int[] caract, String obs, Coord xy){
		//TODO patro builder
	}
	
	public int getId(){
		return id;
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

	public boolean isValid() {
		return validated;
	}

	public void setValid(boolean valid) {
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
	
	
	private int setNewId() {
		//TODO get last id from taula Local + 1
		return 0;
	}
	

}
