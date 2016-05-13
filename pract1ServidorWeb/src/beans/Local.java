package beans;

import java.util.List;

public class Local {
	
	private int idLocal;
	private String name;
	private int typeLocal;
	private Address address;
	private List<Integer> accessibility;	//[codi_caract1, valor1, ...] 
	private String observations;
	private char validated;
	
	
	public Local(String name, int typeLocal, Address addr, List<Integer> acc, String obs, char valid) {
		this.name=name;
		this.typeLocal=typeLocal;
		this.address=addr;		//ojo!
		this.observations=obs;
		this.validated=valid;
		
	}
	
	public Local(String name, int typeLocal, Address addr, List<Integer> acc, String obs) {
		this.idLocal=0;
		this.name=name;
		this.typeLocal=typeLocal;
		this.address=addr;
		this.observations=obs;
		this.validated='N';
		
	}
	
	public int getId(){
		return idLocal;
	}
	
	public void setId(int id) {
		this.idLocal = id;
		
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
		if(validated=='S')
			return true;
		return false;
	}

	public void setValidLocal(boolean valid) {
		if(valid) 
			this.validated = 'S';
		else 
			this.validated = 'N';
	}
	
	
	public List<Integer> getAccessibility(){
		return this.accessibility;
	}
	
	public char getValidation(){
		
		return validated;
	}
	

}
