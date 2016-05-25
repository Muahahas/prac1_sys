<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="util.dateInput" %>
    <%@ page import="java.util.List"%>
<%@ page import="webservices.Local"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<Local> typeEvent = (List<Local>)session.getAttribute("session.typeLogL");%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="sLog">

Desde: 
<select name="yearsMin">
	<%for(int i=0; i<dateInput.years.size(); i++){ %>
		<option value="<%=dateInput.years.get(i) %>">
			<%=dateInput.years.get(i) %> 
		</option>
	<% } %>
</select>	/
<select name="monthsMin">
	<%for(int i=0; i<dateInput.months.size(); i++){ %>
		<option value="<%=dateInput.months.get(i) %>">
			<%=dateInput.months.get(i) %> 
		</option>
	<% } %>
</select>	/
<select name="daysMin">
	<%for(int i=0; i<dateInput.days.size(); i++){ %>
		<option value="<%=dateInput.days.get(i) %>">
			<%=dateInput.days.get(i) %> 
		</option>
	<% } %>
</select>
<br>
	
Fins a:
<select name="yearsMax">
	<%for(int i=0; i<dateInput.years.size(); i++){ %>
		<option value="<%=dateInput.years.get(i) %>">
			<%=dateInput.years.get(i) %> 
		</option>
	<% } %>
</select>	/
<select name="monthsMax">
	<%for(int i=0; i<dateInput.months.size(); i++){ %>
		<option value="<%=dateInput.months.get(i) %>">
			<%=dateInput.months.get(i) %> 
		</option>
	<% } %>
</select>	/
<select name="daysMax">
	<%for(int i=0; i<dateInput.days.size(); i++){ %>
		<option value="<%=dateInput.days.get(i) %>">
			<%=dateInput.days.get(i) %> 
		</option>
	<% } %>
</select>
<br>
	
<input type="checkbox" name="isTypeEvent">
<select name="typeEvent">
	<%for(int i=0; i<typeEvent.size(); i++){ %>
		<option value="<%=i+1 %>">
			<%=typeEvent.get(i) %> 
		</option>
	<% } %>
</select>
<br>
<br>
<input type="submit" value="cerca">
</form>

</body>
</html>