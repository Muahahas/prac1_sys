package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.*;

/**
 * Servlet implementation class svlAlta
 */
@WebServlet({ "/svlAlta", "/sAlta" })
public class svlAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ManageLocalsService service;
    private ManageLocals port;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlAlta() {
        super();
        service = new ManageLocalsService();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		port = service.getManageLocalsPort();
		
		String typeForm = request.getParameter("typeForm");		
		if(typeForm.equals("alta1")){			
			localForm(request,response);
		}else if(typeForm.equals("alta2")){
			accessibilityForm(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
	/*************************************************************************************************************/

	
	private void accessibilityForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sessio = request.getSession(true);
		
		List<Integer> acc = new ArrayList<Integer>();
		List<Characteristic> charactL = new ArrayList<>((List<Characteristic>)sessio.getAttribute("session.characteristicsL"));
		for(int i=0; i<charactL.size(); i++){
			int valor=0;
			int id = charactL.get(i).getIdCaract();
			
			if(charactL.get(i).getType()==1){
				if(request.getParameter("idC"+id) == null) valor=0;
				else valor=1;
			}else if(charactL.get(i).getType()==2){
				valor=Integer.parseInt(request.getParameter("idC"+id));
			}
			acc.add(id);
			acc.add(valor);
		}
		
		Local l = new Local();
		l.setName((String)sessio.getAttribute("sessio1.nomLocal"));
		Address adr = new Address();
		String adrAux = (String) sessio.getAttribute("sessio1.nameAddr"); 
		adr.setType(adrAux.split(",")[0].trim());
		adr.setStreetName(adrAux.split(",")[1].trim());	
		adr.setNumber((Integer)sessio.getAttribute("sessio1.numAddr"));
		l.setAddress(adr);
		l.setTypeLocal(((Integer)sessio.getAttribute("sessio1.typeLocal")));
		l.setObservations((String)sessio.getAttribute("sessio1.obs"));
		l.setAccessibility(acc);
		System.out.println(l.getAccessibility());
		try {
			port.newLocal(l);
			response.getWriter().append("local creat! ;)");
			//obrir pagina del local creat
		} catch (MissingNameError_Exception | WrongTypeLocalError_Exception | DuplicatedLocalError_Exception
				| WrongAddressError_Exception | WrongAccessibilityError_Exception | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void localForm(HttpServletRequest request, HttpServletResponse response){

	
		HttpSession sessio = request.getSession(true);
		
		sessio.setAttribute("sessio1.nomLocal", request.getParameter("nomLocal"));
		sessio.setAttribute("sessio1.typeLocal", Integer.parseInt(request.getParameter("typeLocal")));
		sessio.setAttribute("sessio1.nameAddr", request.getParameter("nameAddr"));
		sessio.setAttribute("sessio1.numAddr", Integer.parseInt(request.getParameter("num"))); //type + street
		sessio.setAttribute("sessio1.obs", request.getParameter("obs"));

        sessio.setAttribute("session.characteristicsL", port.getCharacteristicsByTypeLocal(Integer.parseInt(request.getParameter("typeLocal"))));
		
		
		ServletContext context = getServletContext();		
		RequestDispatcher rd = context.getRequestDispatcher("/alta2");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
