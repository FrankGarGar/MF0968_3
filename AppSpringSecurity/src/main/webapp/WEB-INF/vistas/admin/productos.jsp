<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/vistas/admin/includes/header.jsp"%>

<main>
	<div class="contenedor">
		<h1 class="title">Listado de productos</h1>
		<c:choose>
			<c:when test="${productos!='[]'}">
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Código</th>
							<th>Categoria</th>
							<th>Precio</th>
							<th>Stock</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="p">

							<tr>
								<td>${p.id}</td>
								<td>${p.nombre}</td>
								<td>${p.codigo}</td>
								<td>${p.categoria.nombre}</td>
								<td>${p.precio}</td>
								<td>${p.stock}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h3 class="message-error">Sin Productos Actualmente</h3>
			</c:otherwise>
		</c:choose>
	</div>
</main>

<%@include file="/WEB-INF/vistas/admin/includes/footer.jsp"%>
