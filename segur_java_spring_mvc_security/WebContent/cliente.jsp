<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	var evt;
	var url="http://localhost:8006/alarmas/lista/";
	var idContrato="${idContrato}";
	
	function sensores(){		
		evt=new EventSource(url+idContrato);
		console.log("Estamos dentro de sensores funcion = "+url+idContrato);
		
		evt.addEventListener("message",function(e){
			var tabla="<table border='1'><tr><th>Sensor</th><th>Estado on/off</th><th>Modo normal/detección</th></tr>";
			var array=JSON.parse(e.data);
			for(var i=0;i<array.length;i++){
				tabla+="<tr><td>"+array[i].idSensor+"</td><td>"+array[i].estado+"</td><td>"+array[i].modo+"</td></tr>";
			}
			tabla+="</table>";
			document.getElementById("tabla").innerHTML=tabla;
		});
	}
</script>

</head>
<body onload="sensores();">
	<h2>Aqui debería crearse la tabla con el servicio Flux, se carga cuando el miscroservicio 07 se para.</h2>
		<div id="tabla"></div>
		
		<br/><br/><br/><br/>
		
		<h2>Crear alerta</h2>
            <br/><br/>
		<form action="doAlerta" method="post">
			<select id="idSensor" name="idSensor">
				<option value="0">Elige</option>
				<c:forEach var="s" items="${sensores}">
					<option value="${s.idSensor}">${s.ubicacion}</option>				
				</c:forEach>
			</select>
			<br/><br/>
			<input type="submit" value="Saltar alarma"/>	
		</form>
</body>
</html>