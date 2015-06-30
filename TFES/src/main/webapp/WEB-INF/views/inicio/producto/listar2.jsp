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
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/pedido?tipo=0">Pedidos</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login/cerrarsesion">Cerrar Session</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/datos">Dato Usuario</a></li>
				<li><div style=" color: #e09125; font-weight: bolder;">La Carta-Categoria</div></li>
				<c:forEach items="${categorias}" var="categoria">
					<li><a style=" color: #e09125; font-weight: bolder;" href="<%=getServletContext().getContextPath() %>/inicio/producto/listado1?tipo=${categoria.id}">${categoria.ncategoria}</a></li>		
									
				</c:forEach>
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
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${productos}" var="producto">
					<c:choose>
									<c:when test="${producto.categoria_id==tipo}">
					<tr>
						<td>${producto.nproducto}</td>
						<td>${producto.descripcion}</td>
						<td>
						
							<c:forEach items="${categorias}" var="categoria">
							<c:choose>
									<c:when test="${categoria.id==producto.categoria_id}">
									${categoria.ncategoria}
									</c:when>
								</c:choose>
							</c:forEach>		
						
						</td>
						<td>${producto.precio}</td>
					</tr>
					</c:when>
					<c:when test="${tipo==0}">
					<tr>
						<td>${producto.nproducto}</td>
						<td>${producto.descripcion}</td>
						<td>
						
							<c:forEach items="${categorias}" var="categoria">
									<c:choose>
									<c:when test="${categoria.id==producto.categoria_id}">
									${categoria.ncategoria}
									</c:when>
								</c:choose>
							</c:forEach>		
						
						</td>
						<td>${producto.precio}</td>
					</tr>
					</c:when>
					
					
					</c:choose>
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
