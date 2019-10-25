<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/vistas/includes/header.jsp"%>

<nav>
	<ul>
		<li><a href="home">Home</a></li>
		<li><a href="logout">Logout</a></li>
		<li><a href="productos">Productos</a></li>
		<li>Categorias</li>
		<c:if test="${principal!=null}">
			<li>Bienvenido ${principal.name}</li>

		</c:if>
	</ul>
</nav>
<h1>Inicio</h1>

<%@include file="/WEB-INF/vistas/includes/footer.jsp"%>
