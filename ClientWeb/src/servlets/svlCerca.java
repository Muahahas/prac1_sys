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
import webservices.ManageLocals;
import webservices.ManageLocalsService;
import webservices.MissingSearchCriteriaError_Exception;

/**
 * Servlet implementation class svlCerca
 */
@WebServlet({ "/svlCerca", "/sCerca" })
public class svlCerca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public svlCerca() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doFer(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doFer(request, response);
	}

	private void doFer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ManageLocalsService service = new ManageLocalsService();
		ManageLocals port1 = service.getManageLocalsPort();
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
			boolean validated = !(request.getParameter("validat") == null);
			l.setValidated(validated);
		}
		    List<Local> result = new ArrayList<Local>();
		try {
			 result = port1.getLocals(l, paramIsSet);
		} catch (MissingSearchCriteriaError_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		ServletContext context = getServletContext();		
		HttpSession sessio = request.getSession(true);
		sessio.setAttribute("session.resultL", result);
		
		RequestDispatcher rd = context.getRequestDispatcher("/jCerca");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
