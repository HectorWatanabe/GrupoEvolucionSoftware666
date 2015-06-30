<%@page import="pe.com.modelo.Distrito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Editar Datos</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/resources/css/Layout1.css" />
</head>
<% Distrito distrito = (Distrito)request.getAttribute("distrito"); %>

<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/resources/images/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/producto/listado?tipo=0">La Carta</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/categoria/listado">Categorias</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/local/listado?tipo=0">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/listado">Usuarios</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login/cerrarsesion">Cerrar Sesión</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/datos">Datos Usuario</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/distrito/listado">Distritos</a></li>
				
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
				
				<h2> Editar Distrito</h2>
			<p class="mensajeerror">${mensaje}</p>
				<form:form action="editar" method="post">
				<table>
						<tr>
					<%if(distrito!=null) {%>	<td><input type="hidden" name="id" value="<%=distrito.getId() %>"><%} %></td>
						</tr>	
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="ndistrito" <%if(distrito!=null) {%>value="<%=distrito.getNdistrito() %>"<%} %>></td>
						
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="guardar" value="Editar distrito" /></td>
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
