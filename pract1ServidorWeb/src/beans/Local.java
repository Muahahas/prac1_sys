package beans;

public class Local {
	
	private int idLocal;
	private String name;
	private int typeLocal;
	private Address address;
	private int[] accessibility;	//[codi_caract1,valor1, ...] 
	private String observations;
	//private Coord coordenates;
	private boolean validated;
	
	
	public Local(String name, int typeLocal, Address addr, int[] acc, String obs) {
		this.idLocal=0;
		this.name=name;
		this.typeLocal=typeLocal;
		this.address=addr;
		this.observations=obs;
		this.validated=false;
		
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
		return validated;
	}

	public void setValidLocal(boolean valid) {
		this.validated = valid;
	}
	
	
	public int[] getAccessibility(){
		return this.accessibility;
	}
	


	

}
