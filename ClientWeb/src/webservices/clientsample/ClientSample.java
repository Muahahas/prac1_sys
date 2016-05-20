package webservices.clientsample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import webservices.*;

public class ClientSample {

	public static void main(String[] args) throws Exception {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        ManageLocalsService service1 = new ManageLocalsService();
	        System.out.println("Create Web Service...");
	        ManageLocals port1 = service1.getManageLocalsPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.getTypesOfLocals());
	        System.out.println("Server said: " + port1.getLevelsOfCharacteristics());
	        System.out.println("Server said: " + port1.getCharacteristicsByTypeLocal(1));
	        System.out.println("Server said: " + port1.getStreets());
	        System.out.println("Server said: " + port1.validateLocal(1));
	        System.out.println("Server said: " + port1.getLocalById(1));
	        
	        //consultem de locals
	        //els checkbox
	        List<Boolean> params = new ArrayList<Boolean>();  
	        params.add(false);  //nom
	        params.add(true);   //tipo
	        params.add(false);  //carrer
	        params.add(false);  //verificat
	        //busquem els locals de tipus 1
	        Local l = new Local();
	        l.setTypeLocal(1);	        
	        System.out.println("Server said: " + port1.getLocals(l,params));
	        
	        l.setName("MANOLO");
	        Address adr=new Address();
	        adr.setStreetName("LA RIOJA");
	        adr.setType("CA");
	        adr.setNumber(8);
	        l.setAddress(adr);
	        l.setObservations("muahahah");
	        List<Integer> acc = new ArrayList<Integer>();
	        acc.add(1); acc.add(1);
	        l.setAccessibility(acc);	 
	        Local l2 = port1.newLocal(l);
	        System.out.println("Server said: " + l2);
	        TimeUnit.SECONDS.sleep(5);
	        System.out.println("Server said: " + port1.removeLocal(l2.getIdLocal()));
	        
	
	
	        //System.out.println("Server said: " + port1.getLogByDateAndTypeEvent(null,Integer.parseInt(args[2])));	        
	        //System.out.println("Server said: " + port1.getLogByDate(null));	
	        //System.out.println("Server said: " + port1.getLogTypeEvents());
	        
	
	        /*
	        System.out.println("Create Web Service...");
	        ManageLocals port2 = service1.getManageLocalsPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.getStreets());
	        System.out.println("Server said: " + port2.validateLocal(Integer.parseInt(args[5])));
	        System.out.println("Server said: " + port2.getLevelsOfCharacteristics());
	        System.out.println("Server said: " + port2.removeLocal(Integer.parseInt(args[6])));
	        System.out.println("Server said: " + port2.getLocals(null,null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.getLogByDateAndTypeEvent(null,Integer.parseInt(args[7])));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.getTypesOfLocals());
	        System.out.println("Server said: " + port2.getLogByDate(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.getLogTypeEvents());
	        System.out.println("Server said: " + port2.getCharacteristicsByTypeLocal(Integer.parseInt(args[8])));
	        System.out.println("Server said: " + port2.getLocalById(Integer.parseInt(args[9])));
	        System.out.println("Server said: " + port2.newLocal(null));
	        //Please input the parameters instead of 'null' for the upper method!
			*/
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
