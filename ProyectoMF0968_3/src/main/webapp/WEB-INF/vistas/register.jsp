<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/css/register.css">
<link rel="stylesheet" href="resources/css/app.css">
</head>
<body>
	<div class="container-form">
		<h1>Registro de usuarios</h1>
		<form name="f" action="" method="POST" enctype="utf8">
			<div class="form-group">
				<input type="text" class="inp" name="username" placeholder="Username">
			</div>
			<div class="form-group">
				<input type="password" class="inp" name="password" placeholder="Password">
			</div>
			<div class="form-group">
				<input type="text" class="inp" name="nombre" placeholder="Nombre">
			</div>
			<div class="form-group">
				<input type="text" class="inp" name="apellidos" placeholder="Apellidos">
			</div>
			<div class="form-group">
				<input type="number" class="inp" name="edad" placeholder="Edad">
			</div>
			<div class="form-group">
				<select name="sexo">
					<option value="M">Hombre</option>
					<option value="F">Mujer</option>
				</select>
			</div>
			<div class="form-group">
				<input type="submit" value="Guardar" name="submit" class="b b-gr">
			</div>
			<div class="form-group">
				<p>Ya tienes Cuenta? <a href="login">Login!</a></p>
			</div>
		</form>
	</div>
</body>
</html>