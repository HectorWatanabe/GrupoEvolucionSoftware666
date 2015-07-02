
<%@page import="beans.ProductoBean"%>
<%@page import="beans.CategorieBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%S>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-TypeS" content="text/html; charset=ISO-8859-1">
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
			<li><a href="<%=getServletContext().getContextPath() %>/Admin/listas_vistaU.jsp?numero=3">Nosotros</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Local?metodo=1&opcion=2">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=2&opcion=2">La Carta</a></li>
				<li><a href="">Pedidos</a></li>
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

<h1>USUARIOS</h1>
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>