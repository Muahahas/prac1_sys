package org.jboss.samples.webservices;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class ManageLocals {

	//alta	
	@WebMethod
	public int newLocal(String nameLocal, int typeLocal, Address addr, 
			int[] accessibility, String obs, Coord xy){
		
		Local l = null;
		try {
			l = new Local(nameLocal,typeLocal,addr,accessibility,obs,xy);
		} catch (Exception e) {
			
		}
		
		//TODO insert into local
		// update accessibilitat 
		
		return l.getId();
	}
	
	//consulta
	
	
	//validació
	
	
	//baixa
	
	
}
