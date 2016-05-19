package beans;


public class Address {
	
	//private int idStreet;     //DONA MASSA FEINA
	private String type;
	private String streetName;
	private int number;
	/*
	public Address(int id, String type, String streetName, int num){		
		this.idStreet = id;
		this.type = type;
		this.streetName = streetName;
		this.num = num;			
	}
	*/
	public Address(String streetName, String type, int number){		
		//this.idStreet = 0;
		this.type = type;
		this.streetName = streetName;
		this.number = number;			
	}	
	
	public Address(){}
	/*
	public int getIdStreet() {
		return idStreet;
	}
	
	public void setIdStreet(int idStreet) {
		this.idStreet = idStreet;
	}
	*/
	public String getType() {
		return type;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getNumber() {
		return number;
	}	

	public void setType(String type) {
		this.type = type;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setNumber(int num) {
		this.number = num;
	}
		

}
