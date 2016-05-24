<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<String> streetsL = (List<String>)session.getAttribute("session.streetsL");%>
<% List<String> typesL = (List<String>)session.getAttribute("session.typesL");%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Benvingut</h1>
<form method="post" action="alta">
	Introduir nom local:	
	<input type="text" name="nomLocal">
	<br>
	
	Seleccionar tipo local:	 
	<select name="typeLocal">
		<%for(int i=0; i<typesL.size(); i++){ %>
			<option value="<%=i+1%>">
				<%=typesL.get(i) %> 
			</option>
		<% } %>
	</select>		 
	<br>

	Introduir Carrer:
	<select name="nameAddr">
		<%for(int i=0; i<streetsL.size(); i++){ %>
			<option value="<%=streetsL.get(i) %>">
				<%=streetsL.get(i) %> 
			</option>
		<% } %>
	</select>		
	<br>
	
	Introduir numero:
	<input type="number" name="num">*
	<br>
	Introduir observacions:<br>
	<textarea name="obs" cols="30" rows="5"></textarea>
<!-- 		<input type="text" name="obs"> -->
	<br>
	* Camps obligatoris
	<br>
	<input type="text" style="display:none;" name="typeForm" value="alta1">
	<input type="submit" value="Continua">
	
</form>

</body>
</html>