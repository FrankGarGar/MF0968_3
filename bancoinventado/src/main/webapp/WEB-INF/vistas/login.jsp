<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div>
		<form name="f" action="login" method="POST">
			<div class="form-group">
				<input type="text" class="inp" name="usuario" placeholder="Usuario">
			</div>
			<div class="form-group">
				<input type="password" class="inp" name="password" placeholder=Password>
			</div>
			<div class="form-group">
				<input type="submit" value="Login" name="submit" class="inp">
			</div>
		</form>
	</div>
</body>
</html>