<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="webservices.Local"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<Local> resultL = (List<Local>)session.getAttribute("session.resultL");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Resultats
	<br>
	<ul>
	<% for(int i = 0; i<resultL.size();i++){ %>
		<li> <a href="infoLocal.html"><%=i+1 %></a>: <%=resultL.get(i).getName() %> </li>
	<% } %>
	</ul>


</body>
</html>