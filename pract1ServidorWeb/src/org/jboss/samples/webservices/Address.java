package org.jboss.samples.webservices;

public class Address {
	
	private int id;
	private String type;
	private String streetName;
	private int num;
	
	public Address(String type, String streetName, int num){
		this.type = type;
		this.streetName = streetName;
		this.num = num;
		
	}

}
