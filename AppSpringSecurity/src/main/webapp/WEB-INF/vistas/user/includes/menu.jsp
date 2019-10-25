<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
	<h1>Home User</h1>
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