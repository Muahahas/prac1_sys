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

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import webservices.Local;
import webservices.ManageLocals;
import webservices.ManageLocalsService;

/**
 * Servlet implementation class svlIndex
 */
@WebServlet({ "/svlIndex", "/sIndex" })
public class svlIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static ManageLocalsService service;
	private ManageLocals port;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlIndex() {
        super();
        if(service == null)
        	service = new ManageLocalsService();
        if(port == null)
        	port = service.getManageLocalsPort();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		initData(request);
		
		String action =  request.getParameter("action");
		if("Alta".equals(action))
			goTo("/alta1",request,response);
		else if("Cerca".equals(action))
			goTo("/cerca",request,response);
		else if("Log".equals(action))
			goTo("/log",request,response);
		

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/*****************************************************************************************/
	
	
	private void initData(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		if(session.getAttribute("session.streetsL") == null)
			session.setAttribute("session.streetsL", port.getStreets());
		if(session.getAttribute("session.typesL") == null)
			session.setAttribute("session.typesL", port.getTypesOfLocals());
		if(session.getAttribute("session.levelsL") == null)
			session.setAttribute("session.levelsL", port.getLevelsOfCharacteristics());
		
	}

	private void goTo(String url,HttpServletRequest request, HttpServletResponse response) {		

		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(url);

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
