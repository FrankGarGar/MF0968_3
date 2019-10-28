<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
<%@include file="/WEB-INF/vistas/admin/includes/header.jsp"%>  
<div class="container-form">
		<h1 class="title">Crear Nuevo Producto</h1>
		<form name="f" action="admin/productos/edit" method="POST" enctype="utf8">
			<input name="id" type="hidden" value="${producto.id}">
			<div class="form-group">
				<input type="text" class="inp" name="nombre" value="${producto.nombre}" placeholder="Nombre">
			</div>
			<div class="form-group">
				<input type="text" class="inp" name="codigo" value="${producto.codigo }" placeholder="Codigo">
			</div>
			<div class="form-group">
				<select name="categoria" class="select">
					<c:forEach items="${categorias}" var="cat">
						<option value="${cat.id}">${cat.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<input type="number" class="inp" step="0.01" name="precio" value="${producto.precio }" placeholder="10.02">
			</div>
			<div class="form-group">
				<input type="number" class="inp" step="1"  name="stock" value="${producto.stock }" placeholder="0">
			</div>
			<div class="form-group">
				<input type="submit" value="Guardar" name="submit" class="b b-gr">
			</div>
		</form>
	</div>
	
<%@include file="/WEB-INF/vistas/admin/includes/footer.jsp"%>