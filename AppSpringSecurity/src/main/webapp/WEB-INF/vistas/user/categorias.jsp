<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/vistas/user/includes/header.jsp"%>

<h1 class="text-center">Busqueda de productos por ${cat!='' ? cat : 'todas las categorias' }</h1>

<div class="container container-list">
	<c:choose>
		<c:when test="${productosCat!=null && productosCat!=null }">
			<c:forEach items="${productosCat}" var="p">
				<div class="list-item">
					<p class="nombre">${p.nombre}</p>
					<p class="precio">${p.precio}</p>
					<p class="stock">Disponibles :${p.stock}</p>
					<form action="user/productos/addcart" method="POST" enctype="utf8">

						<input type="hidden" value="${p.id}" name="producto_id"> <input
							type="number" max="${p.stock}" min="0" name="cantidad"> <input
							type="submit" class="b b-submit" value="Añadir al carrito">
					</form>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h3 class="message-error">Sin productos en esa categoria actualmente</h3>
		</c:otherwise>
	</c:choose>

</div>
<%@include file="/WEB-INF/vistas/user/includes/footer.jsp"%>
