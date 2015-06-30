<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Lista Usuarios</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/resources/css/Layout1.css" />
</head>

<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/resources/images/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/producto/listado?tipo=0">La Carta</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/categoria/listado">Categorias</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/local/listado?tipo=0">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/listado">Usuarios</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login/cerrarsesion">Cerrar Sesión</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/datos">Datos Usuario</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/distrito/listado">Distritos</a></li>
				
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
			<h1> Lista de Usuarios </h1>
			<p class="mensajeerror">${mensaje}</p>
			<table id="box-table-a">
				<thead>
					<tr>
						<th>Usuario</th>
						<th>Nombre Usuario</th>
						<th>Apellido Usuario</th>
						<th>Nacimiento</th>
						<th>Dirreccion</th>
						<th>DNI</th>
						<th>Telefono</th>
						<th>Tipo de Usuario</th>
						<th>Estado de Usuario</th>
						<th >Opcion</th>
					</tr>
				</thead>
				<tbody>
					<% int num=0; %>
					<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.usuario}</td>
						<td>${usuario.nusuario}</td>
						<td>${usuario.ausuario}</td>
						<td>${usuario.nacimiento}</td>
						<td>${usuario.direccion}</td>
						<td>${usuario.dni}</td>
						<td>${usuario.telefono}</td>
						<td>
							<c:choose>
									<c:when test="${usuario.tipo ==1}">
									Cliente
									</c:when>
									<c:when test="${usuario.tipo==2}">
									Administrador
									</c:when>
									<c:when test="${usuario.tipo==3}">
									Cocinero
									</c:when>
								</c:choose>
						</td>
						<td>  <c:choose>
								<c:when test="${usuario.estado ==1}">
								Activo
								</c:when>
								<c:when test="${usuario.estado==2}">
								Inactivo
								</c:when>
							</c:choose> </td>
						<td>
						<c:choose>
								<c:when test="${usuario.estado ==1}">
								<a href="<%=getServletContext().getContextPath() %>/inicio/usuario/borrar?id=${usuario.id}">OFF</a>
								</c:when>
								<c:when test="${usuario.estado==2}">
								<a href="<%=getServletContext().getContextPath() %>/inicio/usuario/borrar?id=${usuario.id}">ON</a>
								</c:when>
							</c:choose>
						
					</tr>
					</c:forEach>
					
					
					
				</tbody>
			</table>
					
			
			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>