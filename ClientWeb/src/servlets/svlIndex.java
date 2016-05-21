package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.ManageLocals;
import webservices.ManageLocalsService;

/**
 * Servlet implementation class svlIndex
 */
@WebServlet({ "/svlIndex", "/sIndex" })
public class svlIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action =  request.getParameter("action");

		if(action == "alta"){
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
		ManageLocalsService service = new ManageLocalsService();
        ManageLocals port1 = service.getManageLocalsPort();
        
         List<String> streets =  port1.getStreets();
         
         List<String> typeLocals = port1.getTypesOfLocals();
         
         System.out.println(streets);
         System.out.println(typeLocals);
        
        
        
	}

}
