<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="webservices.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Local l = (Local) session.getAttribute("session.Local"); %>
<% List<String> typesL = (List<String>)session.getAttribute("session.typesL");%>
<% Address adr = l.getAddress(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><%=l.getName() %></h1>
<p>Tipus local: <%=typesL.get(l.getTypeLocal()-1) %></p>
<p>Adreça: <%=adr.getType() %>, <%=adr.getStreetName() %>, Nº: <%=adr.getNumber() %></p>
<p>Observacions:</p>
<%if(l.getObservations() == null) {%>
<p>No hi ha observacions</p>
<%}else{ %>
<p><%=l.getObservations() %></p>
<%} %>
<form method="post" action="sValidar">
<input type="submit" value="Validar" <%if(l.isValidated()){ %>disabled<%} %>/>
</form>
<form method="post" action="sEliminar">
<input type="submit" value="Eliminar"/>
</form>

</body>
</html>