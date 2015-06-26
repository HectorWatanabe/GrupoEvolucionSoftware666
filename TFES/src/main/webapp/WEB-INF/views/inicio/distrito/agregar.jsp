<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Ingresar Datos</title>
<link rel="stylesheet" type="text/css" href="../resources/css/Layout1.css" />
</head>


<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="../resources/images/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="">Comida</a></li>
				<li><a href="">Categorias</a></li>
				<li><a href="">Locales</a></li>
				<li><a href="">Usuarios</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="">Cerrar Sesión</a></li>
				<li><a href="">Datos Usuario</a></li>
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
				
				<h2> Agregar Distrito</h2>
			
				<form:form action="distrito/agregar" method="post">
				<table>
					<tr>
						<td>Nombre:</td>
						<td><form:input path="ndistrito" /></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="btnGuardar" value="Guardar Distrito" /></td>
					</tr>
				</table>
				</form:form>		
										
		
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>
