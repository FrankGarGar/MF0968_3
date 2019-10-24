<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
	<div class="container-form">
		<h1>Login</h1>
		<form name="f" action="login" method="POST">
			<div class="form-group">
				<input type="text" class="inp" name="username" placeholder="Usuario">
			</div>
			<div class="form-group">
				<input type="password" class="inp" name="password"
					placeholder=Password>
			</div>
			<div class="form-group">
				<input type="submit" value="Login" class="btn b b-submit">
			</div>
		</form>
	</div>
</body>
</html>