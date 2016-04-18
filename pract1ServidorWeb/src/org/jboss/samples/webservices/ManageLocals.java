package org.jboss.samples.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class ManageLocals {

	//alta
	@WebMethod()
	public int NewLocal(String name, int typeLocal, Address adr) {
	    return 0;
	}
	
	public int NewLocal(String name, int typeLocal, Address adr, String obs) {
	    return 0;
	}
	
	//validació
	@WebMethod()
	public Local validateLocal(String name, boolean validate) {
	    Local l = getLocalByName(name);
	    l.setValid(validate);
	    return null;
	}
	
	@WebMethod()
	public Local validateLocalById(int id, boolean validate) {
		Local l = getLocalById(id);
	    l.setValid(validate);
	    return null;
	}
	
	//consulta
	@WebMethod()
	public Local getLocalByName(String name) {
	    System.out.println("Get of local: " + name);
	    return null;
	}
	

	@WebMethod()
	public Local getLocalById(int id) {
	    System.out.println("Get of local: " + id);
	    return null;
	}	  
	
	
	@WebMethod()
	public List<Local> getLocalsByType(String name) {
	    System.out.println("Get locals: " + name);
	    return null;
	}
	
	//baixa
	@WebMethod()
	public boolean removeLocalById(int id) {
	    System.out.println("Remove local: " + id);
	    return true;
	}
	
	@WebMethod()
	public boolean removeLocalByName(String name) {
	    System.out.println("Remove local: " + name);
	    return true;
	}
	
	
}
