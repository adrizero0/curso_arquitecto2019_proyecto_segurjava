<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<h1>Autenticación</h1>
	<form action="doLogin" method="post" accept-charset="utf-8">
		<div class="form-group">
			<label>Usuario:</label><input type="text" name="dni" class="form-control" style="width:30%" placeholder="Dni"/>
		</div>
		<div class="form-group">
			<label>Password:</label><input type="password" name="password" class="form-control" style="width:30%" placeholder="Contraseña"/>
		</div>
		
		<button type="submit" class="btn btn-default">Enviar</button>
		
	</form>
	<br/><br/>
	

</div>
</body>
</html>