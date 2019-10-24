<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<div class="container-form">
		<form name="f" action="login" method="POST" enctype="utf8">
			<div class="form-group">
				<input type="text" class="inp" name="usuario" placeholder="Usuario">
			</div>
			<div class="form-group">
				<input type="password" class="inp" name="password" placeholder=Password>
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
				<input type="submit" value="Login" name="submit" class="inp">
			</div>
		</form>
	</div>
</body>
</html>