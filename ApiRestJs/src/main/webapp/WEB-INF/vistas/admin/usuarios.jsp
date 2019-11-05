<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/vistas/admin/includes/header.jsp"%>

<main>
	<div class="contenedor">
		<h1 class="title">Listado de usuarios <span class="right"><a href="admin/usuarios/create"><i class="fas fa-plus"></i></a></span></h1>
		<c:choose>
			<c:when test="${usuarios!='[]'}">
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Apellidos</th>
							<th>Usuario</th>
							<th>Edad</th>
							<th>Sexo</th>
							<th>Activo</th>
							<th>Rol</th>
							<th>Opciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="u">

							<tr>
								<td>${u.id}</td>
								<td>${u.nombre}</td>
								<td>${u.apellidos}</td>
								<td>${u.username}</td>
								<td>${u.edad}</td>
								<td>${u.sexo}</td>
								<td>${u.enabled==true ? 'Activo' : 'Inactivo' }</td>
								<td>${u.role}</td>
								<td>
									<a href="admin/usuarios/edit/${u.id}" class="b b-w"><i class="fas fa-edit"></i></a>
									<a href="admin/usuarios/delete/${u.id}" class="b b-d"><i class="fas fa-trash"></i></a>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h3 class="message-error">Sin usuarios Actualmente</h3>
			</c:otherwise>
		</c:choose>
	</div>
</main>

<%@include file="/WEB-INF/vistas/admin/includes/footer.jsp"%>
