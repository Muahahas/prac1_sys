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
	
<% for(int i = 0; i<levelsL.size();i++){ %>
<%=levelsL.get(i)%>:<br>
<ul>
<% for(int e = 0; e<charactL.size();e++){ %>
<%if(charactL.get(e).getLevel()==i+1){ %>
<li>
<%=charactL.get(e).getName() %>
<% if(charactL.get(e).getType()==1){ %>
<input type="checkbox">
<%}else{ %>
<select>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
</select>
<%} %>
</li>
<%} %>
<%} %>
</ul>
<%} %>


</body>
</html>