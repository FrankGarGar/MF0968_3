<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<c:if test="${error}">
				<div class="alerta-red">${error}</div>
			</c:if>
			<div class="form-group">
				<input type="submit" value="Login" class="b b-submit">
			</div>
			<div class="form-group">
				<p>No tienes Cuenta? <a href="register">click aqui!</a></p>
			</div>
		</form>
	</div>
</body>
</html>