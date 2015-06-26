<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
							
		<h2>Inicio de sesión</h2>
			<form:form action="inicio/login" method="post">
			
			<table>
	<tr>
		<td>Usuario:</td>
		<td><form:input path="usuario" /></td>
	</tr>
	<tr>
		<td>Clave:</td>
		<td><form:input path="clave" maxlength="6"/></td>
	</tr>
	</table>
			
			
			
			<% if(mensaje != null){ %>
			<p><%=mensaje%></p>
			<% } %>
			<p><input type="submit" name="ingresar" value="Ingresar" /></p>
			</form:form>

			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>