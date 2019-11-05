<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/vistas/admin/includes/header.jsp"%>
<div class="container-form">

	<c:choose>
		<c:when test="${categoria.id!=null }">
			<h1 class="title">Editar Categoria</h1>
			
			<form:form method="post" name="f" enctype="utf8" modelAttribute="categoria" action="admin/categorias/edit" cssClass="form">
				<form:input path="id" type="hidden" id="id"/>
				<div class="form-group">
					<form:input path="nombre" placeholder="Nombre" cssClass="inp" type="text" id="nombre" />
				</div>
				<form:errors path="nombre" />
				<div class="form-group">
					<input type="submit" value="Guardar" name="submit" class="b b-gr">
				</div>

			</form:form>
		</c:when>
		<c:otherwise>
			<h1 class="title">Crear Categoria</h1>

			<form:form method="post" name="f" modelAttribute="categoria" action="" cssClass="form">
				<div class="form-group">
					<form:input path="nombre" placeholder="Nombre" cssClass="inp" type="text" id="nombre" />
				</div>
				<form:errors path="nombre" />
				<div class="form-group">
					<input type="submit" value="Guardar" name="submit" class="b b-gr">
				</div>

			</form:form>
		</c:otherwise>
	</c:choose>

</div>

<%@include file="/WEB-INF/vistas/admin/includes/footer.jsp"%>