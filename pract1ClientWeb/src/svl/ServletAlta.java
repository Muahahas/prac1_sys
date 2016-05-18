package svl;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Servlet implementation class ServletAlta
 */
@WebServlet("/ServletAlta")
public class ServletAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doFer(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doFer(request, response);
	}
	private void doFer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String typeForm = request.getParameter("typeForm");
		System.out.println("HI");
		if(typeForm=="alta1"){
			
			alta1(request,response);
		}else if(typeForm=="alta2"){
			throw new NotImplementedException();
		}
		
	}
	
	private void alta1(HttpServletRequest request, HttpServletResponse response){
		HttpSession sessio;
		
		String nomLocal = request.getParameter("nomLocal");
		int typeLocal = Integer.parseInt(request.getParameter("typeLocal"));
		int typeAddr = Integer.parseInt(request.getParameter("typeAddr"));
		System.out.println("El nom és: " + nomLocal);
		System.out.println("L'edat és: " + typeLocal);

	}

}
