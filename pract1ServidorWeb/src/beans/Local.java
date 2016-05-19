package beans;

import java.util.ArrayList;
import java.util.List;

public class Local {
	
	private int idLocal;
	private String name;
	private int typeLocal;
	private Address address;
	private List<Integer> accessibility;	//[codi_caract1, valor1, ...]
	private String observations;
	private boolean validated;
	
	
	public Local(int idLocal, int typeLocal, Address address, String name, String observations, boolean validated, List<Integer> accessibility) {
		this.idLocal = idLocal;
		this.name = name;
		this.typeLocal = typeLocal;
		this.address = address; 			// funciona!
		if(accessibility!=null) this.accessibility = new ArrayList<>(accessibility);
		this.observations = observations;
		this.validated = validated;
	}
	
	public Local() {
		this(0,0,null,null,null,false,null);
	}
	
	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
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
	
	
	public List<Integer> getAccessibility(){
		return this.accessibility;
	}
	
	public void setAccessibility(List<Integer> accessibility) {
		this.accessibility = new ArrayList<Integer>(accessibility);
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
	
	public static boolean getBooleanByCharValidated(char v) {
		if(v == 'S') return true;
		return false;
	}
	
	public static char getCharByBooleanValidated(boolean v) {
		if(v) return 'S';
		return 'N';
	}
	
	
	
	

}
