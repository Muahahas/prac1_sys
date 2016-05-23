package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservices.ManageLocals;
import webservices.ManageLocalsService;

/**
 * Servlet implementation class svlIndex
 */
@WebServlet({ "/svlIndex", "/sIndex" })
public class svlIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static ManageLocalsService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlIndex() {
        super();
        // TODO Auto-generated constructor stub
        service = new ManageLocalsService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action =  request.getParameter("action");
		System.out.println("Doget del servlet Index");

		if("sAlta".equals(action)){
			System.out.println("Dins del if");
			alta(request,response);
			
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void alta(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Dins de la funcio alta");
		HttpSession session = request.getSession();
		ManageLocalsService service = new ManageLocalsService();
        ManageLocals port1 = service.getManageLocalsPort();
        
         List<String> streets =  port1.getStreets();
         
         List<String> typeLocals = port1.getTypesOfLocals();
         
         System.out.println(streets);
         System.out.println(typeLocals);
         
         session.setAttribute("session.streetsL", streets);
         session.setAttribute("session.typesL", typeLocals);
         
         ServletContext context = getServletContext();
         RequestDispatcher rd = context.getRequestDispatcher("/jAlta1");

 		try {
 			rd.forward(request, response);
 		} catch (ServletException | IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         
        
        
        
	}

}
