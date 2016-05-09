package beans;


public class Address {
	
	private int idStreet;     
	private String type;
	private String streetName;
	private int num;
	
	public Address(String type, String streetName, int num){		
		this.idStreet = 0;
		this.type = type;
		this.streetName = streetName;
		this.num = num;			
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
	
	public void setIdStreet(int idStreet) {
		this.idStreet = idStreet;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setNum(int num) {
		this.num = num;
	}


	
	

}