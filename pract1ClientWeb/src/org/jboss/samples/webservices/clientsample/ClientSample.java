package org.jboss.samples.webservices.clientsample;

import org.jboss.samples.webservices.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        HelloWorldService service1 = new HelloWorldService();
	        System.out.println("Create Web Service...");
	        HelloWorld port1 = service1.getHelloWorldPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.sayHello("udl"));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Create Web Service...");
	        HelloWorld port2 = service1.getHelloWorldPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.sayHello("eps"));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
