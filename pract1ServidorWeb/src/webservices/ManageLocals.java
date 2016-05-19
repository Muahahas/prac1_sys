package webservices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import beans.*;
import database.*;
import exceptions.*;

@WebService()
public class ManageLocals {
	
	private DataBaseManager dbm = new DataBaseManager();

	//alta local	
	@WebMethod
	public Local newLocal(Local input) 
			throws MissingNameError,DuplicatedLocalError,WrongTypeLocalError,WrongAddressError,WrongAccessibilityError{		
		
		evaluateLocal(input.getName(),input.getTypeLocal(),input.getAddress(),input.getAccessibility());				
		input.setIdLocal(dbm.getNewLocalId());					
		dbm.insertLocal(input);		 
		
		return input;
	}
	
	//consulta locals
	@WebMethod
	public List<Local> getLocals(Local input, boolean[] paramIsSet) throws MissingSearchCriteriaError{		
		
		String query = buildDynamicQuery(input,paramIsSet);		

		ResultSet rs = dbm.executeQuery(query);		
		List<Local> result = new ArrayList<>();
		try {
			while(rs.next()){				
				Local l = new Local();	
				l.setIdLocal(rs.getInt("codilocal"));
				l.setName(rs.getString("nomlocal"));
				result.add(l);				
			}			
		} catch (SQLException e) {}
		dbm.closeConnection();		
		return result;
	}
	
	

	@WebMethod
	public Local getLocalById(int idLocal) throws LocalNotFoundError{
		
		String query = "select * from eaccessible.local where codilocal="+idLocal+";";
		ResultSet rs = dbm.executeQuery(query);
		if(rs == null) throw new LocalNotFoundError(idLocal);
		Local result = new Local();
		try {
			rs.next();
			result.setIdLocal(rs.getInt("codilocal"));
			result.setTypeLocal(rs.getInt("coditipolocal"));
			result.setAddress(new Address(rs.getString("nomcarrer"),rs.getString("nomvia"),rs.getInt("numero")));
			result.setName(rs.getString("nomlocal"));
			result.setObservations(rs.getString("observacions"));
			result.setValidated(Local.getBooleanByCharValidated(rs.getString("verificat").charAt(0)));
		} catch (SQLException e) {}
		dbm.closeConnection();
		
		result.setAccessibility(getAccessibilityByLocal(idLocal));
		
		return result;
	}
	
	
	//validació
	@WebMethod
	public boolean validateLocal(int idLocal){
		return false;
	}
	
	//baixa
	@WebMethod
	public boolean removeLocal(int idLocal){
		return false;
	}
	
	//consulta carrers
	@WebMethod
	public List<String> getStreets(){
		String query = "select codvia,nomcar from eaccessible.carrerer;";
		ResultSet rs = dbm.executeQuery(query);
		List<String> result = new ArrayList<>();
		try {
			while(rs.next())
				result.add(rs.getString(1)+", "+rs.getString(2));
		} catch (SQLException e) {}
		dbm.closeConnection();
		return result;
	}
	
	
	//consulta tipos locals
	@WebMethod
	public List<String> getTypesOfLocals(){
		String query = "select nomtipolocalca from eaccessible.tipolocal;";
		ResultSet rs = dbm.executeQuery(query);
		List<String> result = new ArrayList<>();
		try {
			while(rs.next())
				result.add(rs.getString(1));
		} catch (SQLException e) {}
		dbm.closeConnection();
		return result;
	}
	
	//consulta nivells de caracteristiques
	@WebMethod
	public List<String> getLevelsOfCharacteristics(){
		String query = "select nomnivellca from eaccessible.nivell;";
		ResultSet rs = dbm.executeQuery(query);
		List<String> result = new ArrayList<>();
		try{
			while(rs.next()){
				result.add(rs.getString(1));
			}
		}catch(SQLException e){}
		dbm.closeConnection();
		return result;
	}
	
	//consulta caracteristiques
	@WebMethod
	public List<Characteristic> getCharacteristicsByTypeLocal(int typeLocal){
		List<Characteristic> result = new ArrayList<>();
		String query = "select c.codicaracteristica,c.nomcaracteristicaca,c.tipo,c.codinivell "
						+ "from eaccessible.caracteristica c, eaccessible.caracteristicatipolocal ctl "
						+ "where c.codicaracteristica=ctl.codicaracteristica "
						+ "and ctl.coditipolocal="+typeLocal+";";
		ResultSet rs = dbm.executeQuery(query);
		try {
			while(rs.next()){			
				result.add(new Characteristic(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		}catch (SQLException e) {}
		dbm.closeConnection();
		return result;
	}
	
	@WebMethod
	private List<Integer> getAccessibilityByLocal(int idLocal) {
		String query = "select * from eaccessible.accessibilitat "
						+ "where codilocal="+idLocal+";";
		ResultSet rs = dbm.executeQuery(query);
		List<Integer> result = new ArrayList<>();
		try {
			while(rs.next()){
				result.add(rs.getInt("codicaracteristica"));
				result.add(rs.getInt("valor"));				
			}
		} catch (SQLException e) {}
		dbm.closeConnection();
		return result;
	}

	/******************** P R I V A T E   M E T H O D S*****************************************************************/
	

	private void evaluateLocal(String name, int typeLocal, Address addr, List<Integer> acc) 
			throws MissingNameError,DuplicatedLocalError,WrongTypeLocalError,WrongAddressError,WrongAccessibilityError {		
		
		if(name.isEmpty())
			throw new MissingNameError();
		
		if(dbm.isDuplicatedLocal(name,addr))
			throw new DuplicatedLocalError();
				
		if(!dbm.hasValidTypeLocal(typeLocal))
			throw new WrongTypeLocalError();			
		
		if(!dbm.hasValidAddress(addr))
			throw new WrongAddressError();
		
		if(!dbm.hasValidAccessibility(acc,typeLocal))
			throw new WrongAccessibilityError();

	}
	
	
	private String buildDynamicQuery(Local input, boolean[] paramIsSet) throws MissingSearchCriteriaError {
		
		String initQuery = "select * from eaccessible.local where ";
		String query = initQuery;				
		
		if(paramIsSet[1]) query += "nomlocal='" + input.getName() + "' ";
		if(paramIsSet[2]){
			if(paramIsSet[1]) query += "and ";
			query += "tipolocal=" + input.getTypeLocal() + " ";
		}
		if(paramIsSet[3]){
			if(paramIsSet[1] || paramIsSet[2]) query += "and ";
			query += "nomvia='" + input.getAddress().getType() + "' and nomcarrer='" + input.getAddress().getStreetName() + "' ";
		}
		if(paramIsSet[4]){
			if(paramIsSet[1] || paramIsSet[2] || paramIsSet[3]) query += "and ";
			query += "verificat='" + Local.getCharByBooleanValidated(input.isValidated()) + "' ";
		}
		
		if(query == initQuery) throw new MissingSearchCriteriaError();
		
		return query;
	}
}