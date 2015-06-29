<%@page import="pe.com.modelo.Usuario"%>
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
			<li><a href="<%=getServletContext().getContextPath() %>/inicio/nosotros1">Nosotros</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/local/listado1?tipo=0">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/producto/listado1?tipo=0">La Carta</a></li>
				<li><a href="">Pedidos</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login/cerrarsesion">Cerrar Session</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/datos">Dato Usuario</a></li>
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
			<h1> Datos Usuario</h1>
			<% Usuario user =(Usuario)request.getSession().getAttribute("usuario"); %>
			<table>
			<tr>
				<td>Usuario:</td>
				<td><%=user.getUsuario() %></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td> <%=user.getNusuario() %></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><%=user.getAusuario() %></td>
			</tr>
			<tr>
				<td>Fecha Nacimiento:</td>
				<td><%=user.getNacimiento() %></td>
			</tr>
			<tr>
				<td>DNI:</td>
				<td> <%=user.getDni() %></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td> <%=user.getTelefono() %></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><%=user.getDireccion() %></td>
			</tr>
			<tr>
				<td>Estado:</td>
				<% if(user.getEstado()==1){ %>
				<td>Activo</td><%} else {%><td>Inactivo</td><%} %>
			</tr>
			</table>
					
					
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>
