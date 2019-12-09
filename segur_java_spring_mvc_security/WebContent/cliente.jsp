<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	var evt;
	var url="http://192.168.0.10:8006/alarmas/lista/";
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

		<div id="tabla"></div>
</body>
</html>