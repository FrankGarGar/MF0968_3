<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error 404</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/css/404.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/404.js"></script>
</head>
<body>

	<h1>Error 500</h1>
	<p class="zoom-area">
		<b>Error</b> en el servidor vuelve a intentarlo en unos minutos
	</p>
		<div class="dfc">
			<div class="five"></div>
			<div class="cero"></div>
			<div class="cero"></div>
		</div>

	<div class="link-container">
		<a onclick="history.back()" class="more-link back">Go Back</a>
	</div>
</body>
</html>