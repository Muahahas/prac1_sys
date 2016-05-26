<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="webservices.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Local l = (Local) session.getAttribute("session.Local"); %>
<% List<String> typesL = (List<String>)session.getAttribute("session.typesL");%>
<% List<Characteristic> charactL = (List<Characteristic>)session.getAttribute("session.characteristicsL");%>
<% List<String> levelsL = (List<String>)session.getAttribute("session.levelsL");%>
<% Address adr = l.getAddress(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Info Local</title>
</head>
<body>

	<a href="index.html">Enrere</a>
	<h1><%=l.getName() %></h1>
	<p>Tipus local: <%=typesL.get(l.getTypeLocal()-1) %></p>
	<p>Adreça: <%=adr.getType() %>, <%=adr.getStreetName() %>, Nº: <%=adr.getNumber() %></p>
	<p>Observacions:</p>
	<%if(l.getObservations() == null) {%>
		<p>No hi ha observacions</p>
	<%}else{ %>
		<p><%=l.getObservations() %></p>
	<%} %>
	
	Informe Accessibilitat:<br>
	<% for(int i = 0; i<levelsL.size();i++){ %>
<%=levelsL.get(i)%>:<br>
<ul>
<% for(int e = 0; e<charactL.size();e++){ %>
<%if(charactL.get(e).getLevel()==i+1){ %>
<li>
<%=charactL.get(e).getName() %>


<%int indx = l.getAccessibility().lastIndexOf(charactL.get(e).getIdCaract()) ;%>
<%=l.getAccessibility().get(indx+1) %>
</li>
<%} %>
<%} %>
	</ul>
	<%} %>
	
	
	
	
	
	<form method="post" action="sValidar">
		<input type="submit" value="Validar" <%if(l.isValidated()){ %>disabled<%} %>/>
	</form>
	<br>
	<form method="post" action="sEliminar">
		<input type="submit" value="Eliminar"/>
	</form>

</body>
</html>