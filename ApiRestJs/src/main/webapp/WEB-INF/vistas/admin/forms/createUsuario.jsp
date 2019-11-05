<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/vistas/admin/includes/header.jsp"%>
<div class="container-form">
	<c:choose>
		<c:when test="${usuario!=null }">
			<h1 class="title">Editar Usuario</h1>
			<form name="f" action="admin/usuarios/edit" method="POST" enctype="utf8">
				<input name="id" type="hidden" value="${usuario.id}"> <input
					type="hidden" name="role" value="${usuario.role }">
				<div class="form-group">
					<input type="text" class="inp" name="username"
						value="${usuario.username}" placeholder="Username">
				</div>
				<div class="form-group">
					<input type="password" class="inp" name="password"
						value="${usuario.password }" placeholder="Password">
				</div>
				<div class="form-group">
					<input type="text" class="inp" name="nombre"
						value="${usuario.nombre }" placeholder="Nombre">
				</div>
				<div class="form-group">
					<input type="text" class="inp" name="apellidos"
						value="${usuario.apellidos }" placeholder="Apellidos">
				</div>
				<div class="form-group">
					<input type="number" class="inp" name="edad"
						value="${usuario.edad }" placeholder="Edad">
				</div>
				<div class="form-group">
					<select name="sexo" class="select">
						<option ${usuario.sexo eq 'M' ? 'selected' : '' } value="M">Hombre</option>
						<option ${usuario.sexo eq 'F' ? 'selected' : '' } value="F">Mujer</option>
					</select>
				</div>
				<div class="form-group">
					<input type="submit" value="Guardar" name="submit" class="b b-gr">
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<h1 class="title">Crear Nuevo Usuario Admin</h1>
			<form name="f" action="" method="POST" enctype="utf8">
				<div class="form-group">
					<input type="text" class="inp" name="username"placeholder="Username">
				</div>
				<div class="form-group">
					<input type="password" class="inp" name="password"placeholder="Password">
				</div>
				<div class="form-group">
					<input type="text" class="inp" name="nombre"placeholder="Nombre">
				</div>
				<div class="form-group">
					<input type="text" class="inp" name="apellidos"placeholder="Apellidos">
				</div>
				<div class="form-group">
					<input type="number" class="inp" name="edad" placeholder="Edad">
				</div>
				<div class="form-group">
					<select name="sexo" class="select">
						<option value="M">Hombre</option>
						<option value="F">Mujer</option>
					</select>
				</div>
				<div class="form-group">
					<input type="submit" value="Guardar" name="submit" class="b b-gr">
				</div>
			</form>
		</c:otherwise>
	</c:choose>

</div>

<%@include file="/WEB-INF/vistas/admin/includes/footer.jsp"%>