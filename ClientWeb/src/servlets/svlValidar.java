package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.Local;
import webservices.ManageLocals;
import webservices.ManageLocalsService;

/**
 * Servlet implementation class svlValidar
 */
@WebServlet({ "/svlValidar", "/sValidar" })
public class svlValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ManageLocalsService service;
	private ManageLocals port;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlValidar() {
        super();
        if(service == null)
        	service = new ManageLocalsService();
        if(port == null)
        	port = service.getManageLocalsPort();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		validate(request, response);
	}

	private void validate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Local l = (Local)session.getAttribute("session.Local");
		boolean isValidated = port.validateLocal(l.getIdLocal());
		//l.setValidated(isValidated);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
