<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Lista</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/resources/css/Layout1.css" />
</head>

<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/resources/images/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/producto/listado">Comida</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/categoria/listado">Categorias</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/local/listado">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/listado">Usuarios</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login/cerrarsesion">Cerrar Sesi�n</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/datos">Datos Usuario</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/distrito/listado">Distritos</a></li>
				
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
			<h1> Lista de Locales </h1>
			<h3><a href="<%=getServletContext().getContextPath() %>/inicio/local">Agregar Local</a></h3>
			<table id="box-table-a">
				<thead>
					<tr>
						<th>N�</th>
						<th>Local</th>
						<th>Direccion</th>
						<th>Telefono</th>
						<th>Correo</th>
						<th>Distrito</th>
						<th colspan="2">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<% int num=1; %>
					<c:forEach items="${locales}" var="local">
					<tr>
						<td><%=num %></td>
						<td>${local.nlocal}</td>
						<td>${local.direccion}</td>
						<td>${local.telefono}</td>
						<td>${local.correo}</td>
						<td>${local.distrito}</td>	
						<td><a href="">Borrar</a></td>
						<td><a href="">Editar</a></td>
					</tr>
					<% num=num+1; %>	
					</c:forEach>
					
					
					
				</tbody>
			</table>
					
			
			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>�Delicia's</div>
</div>
</body>
</html>

