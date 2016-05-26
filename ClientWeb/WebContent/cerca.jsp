<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="webservices.Local"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<String> streetsL =(List<String>)session.getAttribute("session.streetsL");%>
<% List<String> typesL = (List<String>)session.getAttribute("session.typesL");%>
<% List<Local> resultL = (List<Local>)session.getAttribute("session.resultL");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cerca</title>
</head>
<body>
<a href="index.html">Enrere</a>
<h1>Cerca</h1>

<form method="get" action="sCerca">
	Cerca per:
	<br>
	<input type="checkbox" name="tipusCerca1" >Nom
	<input type="text" name="nomLocal" value="Introdueix terme a cercar">
	<br>
	<br>
	<input type="checkbox" name="tipusCerca2"  >Tipus Local
	<select name="typeLocal">
		<%for(int i=0; i<typesL.size(); i++){ %>
			<option value="<%=i+1%>">
				<%=typesL.get(i) %> 
			</option>
		<% } %>
	</select>	
	<br>
	<br>
	<input type="checkbox" name="tipusCerca3" >Carrer
	<select name="nameAddr">
		<%for(int i=0; i<streetsL.size(); i++){ %>
			<option value="<%=streetsL.get(i) %>">
				<%=streetsL.get(i) %> 
			</option>
		<% } %>
	</select>	
	<br>
	<br>
	<input type="checkbox" name="tipusCerca4" >Validacio: 
	<br>
	<input type="radio" name="validat" value="0" checked > Local/s no validat/s.
	<input type="radio" name="validat" value="1"> Local/s validat/s.
	<br>
	<br>
	<input name="local" value="-1" style="display:none">
	<input type="submit" value="Cercar" id="searchBtn"/>


</form>

<!-- <br><br> -->
<%-- <% if(!resultL.isEmpty() || resultL!=null) {%> --%>
<!-- 	Resultados -->
<!-- 	<ul> -->
<%-- 	<% for(int i = 0; i<resultL.size();i++){ %> --%>
<%-- 		<li> <a href="infoLocal.html"><%=resultL.get(i) %></a>: <%=resultL.get(i) %> </li> --%>
<%-- 	<% } %> --%>
<!-- 	</ul> -->
<%-- <% } %> --%>

</body>
</html>
