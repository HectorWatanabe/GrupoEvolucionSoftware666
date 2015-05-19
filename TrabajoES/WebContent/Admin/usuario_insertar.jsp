
<%@page import="beans.ProductoBean"%>
<%@page import="beans.CategorieBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Registrar Usuario</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/Admin/Layout1.css" />
</head>
<%String mensaje = (String)request.getAttribute("mensaje"); %>
<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/Admin/vista_general.jsp?numero=3">Nosotros</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Local?metodo=1&opcion=3">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=2&opcion=3">La Carta</a></li>
				<li><a href="">Promociones</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/Admin/usuario_insertar.jsp?numero=1">Registrar</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Admin/usuario_insertar.jsp?numero=2">Ingresar</a></li>
				<li></li>

			</ul>
		</div>
		<div id="contenido">
			<%try {
				int opcion = Integer.parseInt(request.getParameter("numero"));
				switch(opcion)
				{
				case 1:%>
			<h2> Ingresar Datos del Nuevo Usuario</h2>
			
			<form action="<%=getServletContext().getContextPath() %>/Usuario?metodo=2" method="post">
<table>
	<tr>
		<td>Usuario:</td>
		<td><input type="text" name="usuario" /></td>
	</tr>
	<tr>
		<td>Nombre del Usuario:</td>
		<td><input type="text" name="nusuario" /></td>
	</tr>
	<tr>
		<td>Apellido del Usuario:</td>
		<td><input type="text" name="ausuario" /></td>
	</tr>
	<tr>
		<td>Año de Nacimiento:</td>
		<td><input type="text" name="nacimiento" /></td>
	</tr>
	<tr>
		<td>Direccion:</td>
		<td><input type="text" name="direccion" /></td>
	</tr>
	<tr>
		<td>telefono:</td>
		<td><input type="text" name="telefono" /></td>
	</tr>
	<tr>
		<td>DNI:</td>
		<td><input type="text" name="dni" /></td>
	</tr>
	<tr>
		<td>Clave:</td>
		<td><input type="password" name="clave" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="guardar" value="Registrarse" /></td>
	</tr>
</table>
<% if(mensaje != null){ %>
			<p><%=mensaje%></p>
			<% } %>
</form>
					
<% break;

				case 2:%>
				
		<h2>Inicio de sesión</h2>
			<form action="<%=getServletContext().getContextPath() %>/Usuario?metodo=1" method="post">
			
			<table>
	<tr>
		<td>Usuario:</td>
		<td><input type="text" name="usuario" /></td>
	</tr>
	<tr>
		<td>Clave:</td>
		<td><input type="password" name="clave" /></td>
	</tr>
	</table>
			
			
			
			<% if(mensaje != null){ %>
			<p><%=mensaje%></p>
			<% } %>
			<p><input type="submit" name="ingresar" value="Ingresar" /></p>
			</form>
	<% break;


				
				}} catch(Exception E ) {%>
	<%=mensaje%><%
}%>		
			
			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>