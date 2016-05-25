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
	<a href="sIndex?action=Cerca">Enrere</a>
	<br><br>

	Resultat
	<br><% if (resultL == null||resultL.isEmpty()){ %>
	<p>No hi ha resultats</p>
	<%}else{ %>
	<ul>
	<% for(int i = 0; i<resultL.size();i++){ %>
		<li><%=i+1 %>: <a href="sCerca?local=<%=i%>"><%=resultL.get(i).getName() %></a> </li>
	<% } %>
	</ul>
<% } %>

</body>
</html>