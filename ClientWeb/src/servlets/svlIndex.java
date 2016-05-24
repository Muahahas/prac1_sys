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


		if("sAlta".equals(action)){
			initAlta(request,response);
			
		}
		else if("sCerca".equals(action)){
			initCerca(request,response);
			
		}else if("sLog".equals(action)){
			//initLog(request,response);
			
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void initCerca(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Dins de la funcio alta");
		HttpSession session = request.getSession();
        ManageLocals port1 = service.getManageLocalsPort();
        List<Local> result =  new ArrayList<Local>();   
         List<String> streets =  port1.getStreets();         
         List<String> typeLocals = port1.getTypesOfLocals();
         session.setAttribute("session.streetsL", streets);
         session.setAttribute("session.typesL", typeLocals);
         
         ServletContext context = getServletContext();         
         RequestDispatcher rd = context.getRequestDispatcher("/jCerca");

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
	
	private void initAlta(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Dins de la funcio alta");
		HttpSession session = request.getSession();
        ManageLocals port1 = service.getManageLocalsPort();
        
         List<String> streets =  port1.getStreets();         
         List<String> typeLocals = port1.getTypesOfLocals();
         List<String> levels = port1.getLevelsOfCharacteristics();
         
         session.setAttribute("session.streetsL", streets);
         session.setAttribute("session.typesL", typeLocals);
         session.setAttribute("session.levelsL", levels);
         
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
