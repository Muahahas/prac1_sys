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
		
		initData(request);
		
		List<LogEvent> log = null;
		int typeEvent = 0;
		
		int minYear = Integer.parseInt((String)request.getParameter("yearsMin"));
		int minMonth = Integer.parseInt((String)request.getParameter("monthsMin"));
		int minDay = Integer.parseInt((String)request.getParameter("daysMin"));		
		
		int maxYear = Integer.parseInt((String)request.getParameter("yearsMax"));
		int maxMonth = Integer.parseInt((String)request.getParameter("monthsMax"));
		int maxDay = Integer.parseInt((String)request.getParameter("daysMax"));
		
		String startDate = createDate(minYear,minMonth,minDay);
		String endDate = createDate(maxYear,maxMonth,maxDay);
		
		
		if(request.getParameter("isTypeEvent") == null){
			log = port.getLogByDate(startDate,endDate);
		}else{
			typeEvent = Integer.parseInt((String) request.getParameter("typeEvent"));
			log = port.getLogByDateAndTypeEvent(startDate,endDate, typeEvent);
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
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	private String createDate(int year, int month, int day) {
		// TODO Auto-generated method stub
		String date = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
		
		return date;
	}
	
	private void initData(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("session.typeLogL") == null)
			session.setAttribute("session.typeLogL", port.getLogTypeEvents());
		
	}



}
