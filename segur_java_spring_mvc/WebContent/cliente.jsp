<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	var evt;
// 	var url="http://servidor-zuul:7000/zuulalarmas/alarmas/lista/";
// 	var url="http://servicio-alarmas/alarmas/lista/";
	var url="http://localhost:8006/alarmas/lista/";
	function doSensores(){
		var idContrato=document.getElementById("idContrato").value;
		
		evt=new EventSource(url+idContrato);
		
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
<body>

		<h2>Seleccione Contrato</h2>
            <br/><br/>

			<select id="idContrato" name="idContrato" onclick="doSensores();">		
				<c:forEach var="c" items="${contratos}">
					<option value="${c.idContrato}">${c.idContrato}</option>				
				</c:forEach>				
			</select>
			<br/><br/>
			<input type="submit" value="Ver Sensores"/>			

		
		<div id="tabla"></div>
</body>
</html>