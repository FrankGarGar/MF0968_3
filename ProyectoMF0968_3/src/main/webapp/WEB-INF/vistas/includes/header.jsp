<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/app.css">
<link rel="stylesheet" href="resources/css/font-awesome.all.min.css">
<script type="text/javascript" src="resources/js/app.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark text-white">
		<a class="navbar-brand" href=""><img alt="Logo"
			class="logo" style="width: 60px;" title="Logo"
			src="resources/img/logo.png"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link text-white" href="home">Home
				</a></li>
				<li class="nav-item" data-tabla="personas"><a
					class="nav-link text-white" href="mantenimiento-productos">Mantenimiento Productos</a></li>
				<li class="nav-item" data-tabla="edificios"><a
					class="nav-link text-white" href="mantenimiento-remoto/">Mantenimiento productos
						remotos</a></li>
			</ul>
			<ul class="form-inline my-2 my-lg-0 " onsubmit="return false;">
				<c:choose>
					<c:when test="${principal!=null}">
						<li class="nav-item text-white">${principal.name}| ${role}</li>
						<li class="nav-item text-white">
							
							<a
							class="nav-link text-danger" href="logout"><i
								class="fas fa-power-off"></i></a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item text-white"><a
							class="nav-link text-success" href="login"><i
								class="fas fa-power-off"></i></a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</nav>