<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Ingresar Locales</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/Admin/Layout1.css" />
</head>
<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><h1 id="logo1">Delicia's</h1></div>
		<div id="menuar">
			<ul>
				<li><a href="">Menu 1</a></li>
				<li><a href="">Menu 2</a></li>
				<li><a href="">Menu 3</a></li>
				<li><a href="">Menu 4</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="">Opcion 1</a></li>
				<li><a href="">Opcion 2</a></li>
				<li><a href="">Opcion 3</a></li>
				<li><a href="">Opcion 4</a></li>
			</ul>
		</div>
		<div id="contenido">
			
			<h2> Ingresar Datos del Nuevo Local</h2>
			
			<form action="<%=getServletContext().getContextPath() %>/Local" method="post">
<table>
	
	<tr>
		<td>Nombre:</td>
		<td><input type="text" name="nlocal" /></td>
	</tr>
	<tr>
		<td>Direccion:</td>
		<td><input type="text" name="direccion" /></td>
	</tr>
	<tr>
		<td>Telefono:</td>
		<td><input type="text" name="telefono" /></td>
	</tr>
	<tr>
		<td>Correo:</td>
		<td><input type="text" name="correo" /></td>
	</tr>
	<tr>
		<td>Distrito:</td>
		<td><input type="text" name="distrito" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="guardar" value="Guardar local" /></td>
	</tr>
</table>
</form>
					
			<% try {
				int opcion = Integer.parseInt(request.getParameter("numero"));
				switch(opcion)
				{
				case 1:%>
					<%@include file="/Admin/mensaje.jsp"%><%
					break;
				
				}

} catch(Exception E ) {%>
	<%@include file="/Admin/mensaje.jsp" %><%
}%>	
			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>