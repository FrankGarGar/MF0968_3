<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de propietarios</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Usuario</th>
				<th>Ultima Conexion</th>
				<th>Rol</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${propietarios}" var="p">

				<tr>
					<td>${p.id}</td>
					<td>${p.nombre}</td>
					<td>${p.apellidos}</td>
					<td>${p.usuario}</td>
					<td>${p.lastConexion}</td>
					<td>${p.role}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>