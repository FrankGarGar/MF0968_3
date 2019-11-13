<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/vistas/includes/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<main class="listado-productos container">
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
	<h1 class="text-center">Agregar nuevo Producto</h1>
	<form:form method="post" action="add-producto" modelAttribute="producto">
		<div class="form-group">
			<form:input type="hidden" id="id" path="id"/>
			<form:label path="nombre" for="nombre">Nombre</form:label>
				<form:input class="form-control" type="text" id="nombre" path="nombre"
					placeholder="Ingresa Nombre..."/>
					<form:errors path="nombre" cssClass="alert alert-danger" element="div" />
		</div>
		<div class="form-group">
		<form:label path="imagen" for="imagen">Imagen</form:label>
				<form:input class="form-control" type="text" id="imagen" path="imagen"
					placeholder="Ingresa ruta de imagen..."/>
				<form:errors path="nombre" cssClass="alert alert-danger" element="div" />
			
		</div>
		<div class="form-group">
				<form:label path="descripcion" type="text" for="descripcion">Descripcion</form:label>
				<form:input class="form-control" id="descripcion" path="descripcion"
					placeholder="Ingresa Descripcion..."/>
					<form:errors path="descripcion" cssClass="alert alert-danger" element="div" />
		</div>
		<div class="form-group">
				<form:label path="precio" for="precio">Precio</form:label>
				<form:input type="number" class="form-control" id="precio" path="precio"
					placeholder="Ingresa Precio..." step="0.01"/>
					<form:errors path="precio" cssClass="alert alert-danger" element="div" />
		</div>
		<%--<div class="form-group">
			<label for="almacenes">Donde se almacena</label>
			<select multiple class="form-control" id="exampleFormControlSelect2">
		      <c:forEach items="${almacenes}" var="a">
		      </c:forEach>
		    </select>
		</div>--%>
		<div class="form-group">
			<input class="btn btn-primary" value="Guardar" type="submit">
		</div>
	</form:form>
</main>
<%@include file="/WEB-INF/vistas/includes/footer.jsp"%>