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

import webservices.Address;
import webservices.Local;
import webservices.LocalNotFoundError_Exception;
import webservices.ManageLocals;
import webservices.ManageLocalsService;
import webservices.MissingSearchCriteriaError_Exception;

/**
 * Servlet implementation class svlCerca
 */
@WebServlet({ "/svlCerca", "/sCerca" })
public class svlCerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ManageLocalsService service;
	private ManageLocals port;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public svlCerca() {
		super();
		if(service == null)
        	service = new ManageLocalsService();
        if(port == null)
        	port = service.getManageLocalsPort();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		initData(request);
		
		int idx = Integer.parseInt(request.getParameter("local"));
		if(idx == -1)
			searchLocals(request,response);
		else 
			getLocalByIndex(request,response,idx);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	

	private void getLocalByIndex(HttpServletRequest request, HttpServletResponse response, int index) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		List<Local> locals = (List<Local>)session.getAttribute("session.resultL");
		int id = locals.get(index).getIdLocal();
		Local l = null;
		try {
			l = port.getLocalById(id);
		} catch (LocalNotFoundError_Exception e) {
			response.getWriter().append(e.getMessage());
			return;
		}
		session.setAttribute("session.Local", l);
		
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/infoLocal");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void searchLocals(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Local l = new Local();
		List<Boolean> paramIsSet = new ArrayList<Boolean>();
		if (request.getParameter("tipusCerca1") == null) {
			paramIsSet.add(false);
		} else {
			paramIsSet.add(true);
			l.setName((String) request.getParameter("nomLocal"));
		}
		if (request.getParameter("tipusCerca2") == null) {
			paramIsSet.add(false);

		} else {
			paramIsSet.add(true);
			l.setTypeLocal(Integer.parseInt(request.getParameter("typeLocal")));
		}
		if (request.getParameter("tipusCerca3") == null) {
			paramIsSet.add(false);
		} else {
			paramIsSet.add(true);
			String addrString = request.getParameter("nameAddr");
			Address addr = new Address();
			addr.setType(addrString.split(",")[0].trim());
			addr.setStreetName(addrString.split(",")[1].trim());
			l.setAddress(addr);
		}
		if (request.getParameter("tipusCerca4") == null) {
			paramIsSet.add(false);
		} else {
			paramIsSet.add(true);
			boolean validated = "1".equals(request.getParameter("validat"));
			l.setValidated(validated);
		}
		
		List<Local> result = null;
		
		try {
			result = port.getLocals(l, paramIsSet);
		} catch (MissingSearchCriteriaError_Exception e) {
			response.getWriter().append(e.getMessage());
			return;
		}
		
		ServletContext context = getServletContext();		
		HttpSession sessio = request.getSession(true);
		sessio.setAttribute("session.resultL", result);
		
		RequestDispatcher rd = context.getRequestDispatcher("/resultat");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	private void initData(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		if(session.getAttribute("session.streetsL") == null)
			session.setAttribute("session.streetsL", port.getStreets());
		if(session.getAttribute("session.typesL") == null)
			session.setAttribute("session.typesL", port.getTypesOfLocals());
		if(session.getAttribute("session.levelsL") == null)
			session.setAttribute("session.levelsL", port.getLevelsOfCharacteristics());
		//if(session.getAttribute("session.typeLogL") == null)
		//	session.setAttribute("session.typeLogL", port.getLogTypeEvents());
	}

}
