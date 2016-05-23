<%@page import="webservices.Characteristic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<Characteristic> charactL = (List<Characteristic>)session.getAttribute("session.characteristicsL");%>
<% List<String> levelsL = (List<String>)session.getAttribute("session.levelsL");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="alta">	
<% for(int i = 0; i<levelsL.size();i++){ %>
<%=levelsL.get(i)%>:<br>
<ul>
<% for(int e = 0; e<charactL.size();e++){ %>
<%if(charactL.get(e).getLevel()==i+1){ %>
<li>
<%=charactL.get(e).getName() %>
<% if(charactL.get(e).getType()==1){ %>
<input name="idC<%=charactL.get(e).getIdCaract() %>" type="checkbox">
<%}else{ %>
<select name="idC<%=charactL.get(e).getIdCaract() %>">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
<%} %>
</li>
<%} %>
<%} %>
</ul>
<%} %>
	<input type="text" style="display:none;" name="typeForm" value="alta2">
	<input type="submit" value="Guardar">
	
</form>

</body>
</html>