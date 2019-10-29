<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#"><img alt="Logo" title="Logo"
		src=""></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="user/home">Home
			</a></li>
			<li class="nav-item"><a class="nav-link" href="user/productos">Productos</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Categorias</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<c:forEach items="${categorias}" var="cat">
						<a class="dropdown-item" href="user/categorias/${cat.nombre}">${cat.nombre}</a>
					</c:forEach>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="carrito"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${principal.name}</a>
				<div class="dropdown-menu" aria-labelledby="carrito">
					<c:choose>
						<c:when test="${carrito!=null }">
							<c:forEach items="${carrito.cartItems}" var="item">
								<c:set var="total"
									value="${total + (item.cantidad*item.producto.precio)}" />
								<div class="dropdown-item">
									<a class="text-body" href="user/productos/${item.producto.id}">${item.producto.nombre}
										-> ${item.cantidad} = ${item.cantidad*item.producto.precio}€</a> <a
										class="text-danger display-5"
										href="user/productos/delete/${item.id}"><i
										class="fas fa-times-circle"></i></a>
								</div>
							</c:forEach>
							<div class="dropdown-item total text-center">Total:
								${total} €</div>
						</c:when>
						<c:otherwise>
							<p class="text-center">Carrito Vacio</p>
						</c:otherwise>
					</c:choose>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
			</li>
		</ul>
	</div>
</nav>
<c:if test="${error!=null}">

	<h3 class="message-error">${error}</h3>

</c:if>