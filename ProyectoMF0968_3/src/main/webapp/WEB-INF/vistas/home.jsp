<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/vistas/includes/header.jsp"%>

<main class="listado-productos">
	<div class="container">
		<h1 class="text-center">Listado de productos</h1>
		<div class="card-deck">
			<c:choose>
				<c:when test="${productos!=null }">
					<c:forEach items="${productos}" var="p">
						<div class="card" style="width: 18rem;">
							<img src="${p.imagen }" class="card-img-top img-thumbnail"
								alt="${p.nombre}">
							<div class="card-body">
								<h5 class="card-title">${p.nombre}</h5>
								<p class="card-text">${p.descripcion}</p>
								<p class="card-text">
									PVD: <span class="precio">${p.precio}€</span>
								</p>
								<div>
									<h6>Almacenes</h6>

								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2 class="text-center">Sin Productos actualmente</h2>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</main>
<%@include file="/WEB-INF/vistas/includes/footer.jsp"%>