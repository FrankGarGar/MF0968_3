<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/vistas/includes/header.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="listado-productos">
	<div class="container">
		<h1 class="text-center">
			Listado de productos <a href="add-producto"><i
				class="fas fa-plus"></i></a>
		</h1>
		<div class="table-responsive-md table-responsive-sm">
			<table class="table" id="table-remoto">
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
				</tbody>
			</table>
		</div>
	</div>
</main>

<%@include file="/WEB-INF/vistas/includes/footer.jsp"%>