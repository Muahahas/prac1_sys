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
 * Servlet implementation class svlEliminar
 */
@WebServlet({ "/svlEliminar", "/sEliminar" })
public class svlEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ManageLocalsService service;
	private ManageLocals port;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlEliminar() {
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
		doPost(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Local l = (Local)session.getAttribute("session.Local");
		boolean isDeleted = port.removeLocal(l.getIdLocal());
		
		if(isDeleted){
			session.setAttribute("session.Local", null);
			response.getWriter().append("<a href=\"index.html\">Enrere</a><br>Local eliminat correctament.");
		}
		else
			response.getWriter().append("<a href=\"index.html\">Enrere</a><br>S'ha produit un error en la eliminaci� del local.");
		
		/*
		if(isDeleted){
			l = null;
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
		*/
	}

}
