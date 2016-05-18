package svl;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Servlet implementation class SvlIndex
 */
@WebServlet({ "/SvlIndex", "/sIndex" })
public class SvlIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvlIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doFer(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doFer(request,response);
	}
	
	private void doFer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**System.out.println("Hola");
		String typeForm = request.getParameter("type");	
		System.out.println(typeForm);
		if(typeForm.equals("alta")){			
			System.out.println("alta");
		}else if(typeForm=="cerca"){
			System.out.println("cerca");
		}*/
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jFinal");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
