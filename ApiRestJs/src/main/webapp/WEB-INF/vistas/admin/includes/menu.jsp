<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>
	<ul>
		<li><a href="admin/home">Home</a></li>
		<li><a href="admin/productos">Productos</a></li>
		<li><a href="admin/categorias">Categorias</a></li>
		<li><a href="admin/usuarios">Usuarios</a></li>
		<li><a href="logout">Logout</a></li>
	</ul>
</nav>
<c:if test="${error!=null}">

	<h3 class="message-error">${error}</h3>

</c:if>