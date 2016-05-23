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

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import webservices.Characteristic;
import webservices.ManageLocals;
import webservices.ManageLocalsService;

/**
 * Servlet implementation class svlAlta
 */
@WebServlet({ "/svlAlta", "/alta" })
public class svlAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doFer(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doFer(request, response);
	}
	
	private void doFer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String typeForm = request.getParameter("typeForm");		
		if(typeForm.equals("alta1")){			
			localForm(request,response);
		}else if(typeForm=="alta2"){
			accessibilityForm(request,response);
		}
		
	}
	
	private void accessibilityForm(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void localForm(HttpServletRequest request, HttpServletResponse response){
		HttpSession sessio;
		
		String nomLocal = request.getParameter("nomLocal");
		int typeLocal = Integer.parseInt(request.getParameter("typeLocal"));
		String nameAddr = request.getParameter("nameAddr");
		
		int numAddr =  Integer.parseInt(request.getParameter("num"));
		String obs = request.getParameter("obs");
		
		
		System.out.println("El nom �s: " + nomLocal);
		System.out.println("El tipus �s: " + typeLocal);
		System.out.println("Nom Addr " + nameAddr);
		System.out.println("Num Addr: " + numAddr);
		System.out.println("Les observacions: " + obs);
	
		sessio = request.getSession(true);
		
		sessio.setAttribute("sessio1.nomLocal", nomLocal);
		sessio.setAttribute("sessio1.typeLocal", typeLocal);
		sessio.setAttribute("sessio1.nameAddr", nameAddr);
		sessio.setAttribute("sessio1.numAddr", numAddr);
		sessio.setAttribute("sessio1.obs", obs);
		
		ManageLocalsService service = new ManageLocalsService();
        ManageLocals port1 = service.getManageLocalsPort();
        
         List<Characteristic> characteristics =  port1.getCharacteristicsByTypeLocal(typeLocal);
         sessio.setAttribute("session.characteristicsL", characteristics);
		
		
		ServletContext context = getServletContext();
		
		
		
		RequestDispatcher rd = context.getRequestDispatcher("/jalta2");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
