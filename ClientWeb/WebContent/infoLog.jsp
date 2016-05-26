<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="webservices.LogEvent"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<LogEvent> logL =(List<LogEvent>)session.getAttribute("session.logL");%>
<% List<String> typesL = (List<String>)session.getAttribute("session.typeLogL");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informe Log</title>
</head>
<body>

<h1>Resultat Log</h1>
<a href="sIndex?action=Log">Enrere</a>
	<br><br>

	Resultat
	<br><% if (logL == null||logL.isEmpty()){ %>
	<p>No hi ha resultats</p>
	<%}else{ %>
	<ul>
	<% for(int i = 0; i<logL.size();i++){ %>
		<% LogEvent e = logL.get(i); %>
		<li><%=i+1 %>: date: <%=e.getDate() %>, time: <%=e.getTime().split(" ")[1] %> <br>
		 type: <%=e.getType() %>	Message: <%=e.getMeesage() %>
		</li>
	<% } %>
	</ul>
<% } %>

</body>
</html>


<!-- 	private int id; -->
<!-- 	private String date; -->
<!-- 	private String time; -->
<!-- 	private int type; -->
<!-- 	private String message; -->
	