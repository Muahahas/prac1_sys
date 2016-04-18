package org.jboss.samples.webservices;

public class Local {
	
	private int id;
	private String name;
	private int typeLocal;
	private Address address;
	private String observations;
	private boolean valid;
	
	
	public Local(String name, int typeLocal, Address adr){
		this.name = name;
		this.typeLocal = typeLocal;
		this.address = adr;
	}
	
	public Local(String name, int typeLocal, Address adr, String obs){
		this.name = name;
		this.typeLocal = typeLocal;
		this.address = adr;
		this.observations = obs;
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
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	

}
