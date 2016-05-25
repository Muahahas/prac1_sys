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

import webservices.ManageLocals;
import webservices.ManageLocalsService;

import webservices.LogEvent;

/**
 * Servlet implementation class svlLog
 */
@WebServlet({ "/svlLog", "/sLog" })
public class svlLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ManageLocalsService service;
	private ManageLocals port;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svlLog() {
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
		// TODO Auto-generated method stub
		doLog(request, response);
	}

	private void doLog(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List<LogEvent> log = new ArrayList<LogEvent>();
		int typeEvent = 0;
		int minYear = Integer.parseInt((String)request.getAttribute("yearsMin"));
		int minMonth = Integer.parseInt((String)request.getAttribute("monthsMin"));
		int minDay = Integer.parseInt((String)request.getAttribute("daysMin"));		
		int maxYear = Integer.parseInt((String)request.getAttribute("yearsMax"));
		int maxMonth = Integer.parseInt((String)request.getAttribute("monthsMax"));
		int maxDay = Integer.parseInt((String)request.getAttribute("daysMax"));
		
		String maxDate = createDate(maxYear,maxMonth,maxDay);
		String minDate = createDate(minYear,minMonth,minDay);
		
		if(request.getAttribute("isTypeEvent") == null){
			log = port.getLogByDate(minDate,maxDate);
		}else{
			typeEvent =Integer.parseInt((String) request.getAttribute("typeEvent"));
			log = port.getLogByDateAndTypeEvent(minDate,maxDate, typeEvent);
		}
		
		ServletContext context = getServletContext();		
		HttpSession sessio = request.getSession(true);
		sessio.setAttribute("session.logL", log);
		
		RequestDispatcher rd = context.getRequestDispatcher("/resultatLog");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String createDate(int year, int month, int day) {
		// TODO Auto-generated method stub
		String date = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
		
		return date;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
