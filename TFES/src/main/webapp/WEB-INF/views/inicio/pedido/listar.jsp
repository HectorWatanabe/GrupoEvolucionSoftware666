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
			<li><a href="<%=getServletContext().getContextPath() %>/inicio/nosotros1">Inicio</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/pedido?tipo=0">Pedidos</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login/cerrarsesion">Cerrar Sesión</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/datos">Datos Usuario</a></li>
				<li><div style=" color: #e09125; font-weight: bolder;">Pedidos-Estados</div></li>
				<li><a style=" color: #e09125; font-weight: bolder;"href="<%=getServletContext().getContextPath() %>/inicio/pedido?tipo=1">Pendiente</a></li>		
				<li><a style=" color: #e09125; font-weight: bolder;"href="<%=getServletContext().getContextPath() %>/inicio/pedido?tipo=2">Listo</a></li>		
				
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
				<h1> Lista de Pedidos </h1>
			<p class="mensajeerror">${mensaje}</p>
			<table id="box-table-a">
				<thead>
					<tr>
						<th>Pedido N°</th>
						<th>Usuario</th>
						<th>Estado</th>
						<th >Opcion</th>
					</tr>
				</thead>
				<tbody>
					<% int num=0; %>
					<c:forEach items="${pedidos}" var="pedido">
					<c:choose>
					<c:when test="${pedido.estado==tipo}">
					<tr>
						<td>${pedido.id}</td>
						<td>
							<c:forEach items="${usuarios}" var="usuario">
							<c:choose>
									<c:when test="${usuario.id==pedido.usuario_id}">
									${usuario.usuario}
									</c:when>
								</c:choose>
								
							</c:forEach>
						</td>
						<td>  <c:choose>
								<c:when test="${pedido.estado==1}">
								Pendiente
								</c:when>
								<c:when test="${pedido.estado==2}">
								Listo
								</c:when>
							</c:choose> </td>
						<td>
						<c:choose>
								<c:when test="${pedido.estado==1}">
								<a href="<%=getServletContext().getContextPath() %>/inicio/pedido/actualizar?id=${pedido.id}&tipo=${tipo}">Listo</a>
								</c:when>
								<c:when test="${pedido.estado==2}">
								<a href="<%=getServletContext().getContextPath() %>/inicio/pedido/actualizar?id=${pedido.id}&tipo=${tipo}">Pendiente</a>
								</c:when>
							</c:choose>
						
					</tr>
					</c:when>
					
					
					<c:when test="${tipo==0}">
					<tr>
						<td>${pedido.id}</td>
						<td>
							<c:forEach items="${usuarios}" var="usuario">
							<c:choose>
									<c:when test="${usuario.id==pedido.usuario_id}">
									${usuario.usuario}
									</c:when>
								</c:choose>
								
							</c:forEach>
						</td>
						<td>  <c:choose>
								<c:when test="${pedido.estado==1}">
								Pendiente
								</c:when>
								<c:when test="${pedido.estado==2}">
								Listo
								</c:when>
							</c:choose> </td>
						<td>
						<c:choose>
								<c:when test="${pedido.estado==1}">
								<a href="<%=getServletContext().getContextPath() %>/inicio/pedido/actualizar?id=${pedido.id}&tipo=${tipo}">Listo</a>
								</c:when>
								<c:when test="${pedido.estado==2}">
								<a href="<%=getServletContext().getContextPath() %>/inicio/pedido/actualizar?id=${pedido.id}&tipo=${tipo}">Pendiente</a>
								</c:when>
							</c:choose>
						
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



