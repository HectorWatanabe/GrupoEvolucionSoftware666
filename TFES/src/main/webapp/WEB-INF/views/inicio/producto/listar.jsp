<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Lista</title>
<link rel="stylesheet" type="text/css" href="../../resources/css/Layout1.css" />
</head>

<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="../../resources/images/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="">Nosotros</a></li>
				<li><a href="">Locales</a></li>
				<li><a href="">La Carta</a></li>
				<li><a href="">Pedidos</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="">Cerrar Sesion</a></li>
				<li><a href="">Datos Usuario</a></li>
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
			<h1> Lista de Productos </h1>
			<table id="box-table-a">
				<thead>
					<tr>
						<th>Producto</th>
						<th>descripcion</th>
						<th>Categoria</th>
						<th>Precio</th>
						<th colspan="2">Opciones</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${productos}" var="producto">
					<tr>
						<td>${producto.nproducto}</td>
						<td>${producto.descripcion}</td>
						<td>${producto.categoria_id}</td>
						<td>${producto.precio}</td>
						<td><a href="">Borrar</a></td>
						<td><a href="">Editar</a></td>
					</tr>
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