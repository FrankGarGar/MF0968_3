<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/vistas/admin/includes/header.jsp"%>
<div class="container-form">

	<c:choose>
		<c:when test="${categoria!=null }">
			<h1 class="title">Editar Categoria</h1>
			<form name="f" action="admin/categorias/edit" method="POST"
				enctype="utf8">
				<input name="id" type="hidden" value="${categoria.id}">
				<div class="form-group">
					<input type="text" class="inp" name="nombre"
						value="${categoria.nombre}" placeholder="Nombre">
				</div>
				<div class="form-group">
					<input type="submit" value="Guardar" name="submit" class="b b-gr">
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<h1 class="title">Crear Categoria</h1>
		<form name="f" action="" method="POST" enctype="utf8">
			<div class="form-group">
				<input type="text" class="inp" name="nombre"placeholder="Nombre">
			</div>
			<div class="form-group">
				<input type="submit" value="Guardar" name="submit" class="b b-gr">
			</div>
		</form>
		</c:otherwise>
	</c:choose>

</div>

<%@include file="/WEB-INF/vistas/admin/includes/footer.jsp"%>