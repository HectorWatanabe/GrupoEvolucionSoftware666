<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Registrar Usuario</title>
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
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/producto/listado1">La Carta</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/producto/promo">Promociones</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario">Registrar</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login">Ingresar</a></li>
				<li></li>

			</ul>
		</div>
		<div id="contenido">
							
		<h2>Inicio de sesion</h2>
			<form:form action="login" method="post">
			
			<table>
	<tr>
		<td>Usuario:</td>
		<td><form:input path="usuario" /></td>
	</tr>
	<tr>
		<td>Clave:</td>
		<td><form:password path="clave" maxlength="15"/></td>
	</tr>
	</table>
			
			
			
		
			<p class="mensajeerror">${mensaje}</p>
		
			<p><input type="submit" name="ingresar" value="Ingresar" /></p>
			</form:form>

			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>