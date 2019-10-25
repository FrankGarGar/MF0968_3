<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/vistas/admin/includes/header.jsp"%>

<main>
	<div class="contenedor">
		<h1 class="title">Listado de categorias</h1>
		<c:choose>
			<c:when test="${categorias!='[]'}">
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${categorias}" var="c">

							<tr>
								<td>${c.id}</td>
								<td>${c.nombre}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h3 class="message-error">Sin categorias Actualmente</h3>
			</c:otherwise>
		</c:choose>
	</div>
</main>

<%@include file="/WEB-INF/vistas/admin/includes/footer.jsp"%>
