<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

		<h2>Seleccione Contrato</h2>
            <br/><br/>
		<form action="doLista" method="post">
			<select id="idContrato" name="idContrato">
				<option value="0">Elige</option>
				<c:forEach var="c" items="${contratos}">
					<option value="${c.idContrato}">${c.direccion}</option>				
				</c:forEach>				
			</select>
			<br/><br/>
			<input type="submit" value="Ver Sensores"/>	
		</form>
		
		
		
</body>
</html>