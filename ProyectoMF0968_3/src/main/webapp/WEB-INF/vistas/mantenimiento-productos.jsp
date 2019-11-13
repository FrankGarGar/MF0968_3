<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/vistas/includes/header.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="listado-productos">
	<div class="container">
	<c:if test="${alerta!=null}">
		<div class="alert alert-${alerta.nivel } alert-dismissible fade show"
			role="alert">
			${alerta.texto}
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<h1 class="text-center">Listado de productos <a href="add-producto"><i class="fas fa-plus"></i></a></h1>
	<c:choose>
		<c:when test="${productos!=null }">
			<div class="table-responsive-md table-responsive-sm">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Imagen</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.nombre}</td>
							<td><img style="height:80px;" class="img-fluid" alt="Responsive image" alt="${p.nombre}" title="${p.nombre}" src="${p.imagen}"></td>
							<td>${p.descripcion}</td>
							<td>${p.precio}</td>
							<td><a href="add-producto/${p.id}" class="btn btn-warning"><i class="fas fa-edit"></i></a><a href="delete-producto/${p.id}" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<h2 class="text-center">Sin Productos actualmente</h2>
		</c:otherwise>
	</c:choose>
	</div>
</main>

<%@include file="/WEB-INF/vistas/includes/footer.jsp"%>