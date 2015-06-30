<%@page import="java.util.ArrayList"%>
<%@page import="pe.com.modelo.Distrito"%>
<%@page import="java.util.Vector"%>
<%@page import="pe.com.modelo.Local"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Editar Datos</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/resources/css/Layout1.css" />
</head>

<%  ArrayList<Distrito> distritos=(ArrayList<Distrito>)request.getAttribute("distritos"); %>
<% Local local = (Local)request.getAttribute("local");%>
<% String tipo = (String)request.getAttribute("tipo");%>

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
			
			
				
				<h2> Editar Local</h2>
			<p class="mensajeerror">${mensaje}</p>
				<form:form action="editar?tipo=${tipo }" method="post">
				<table>
					<tr>
					<%if(local!=null) {%>	<td><input type="hidden" name="id" value="<%=local.getId() %>"><%} %></td>
						</tr>	
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="nlocal" <%if(local!=null) {%>value="<%=local.getNlocal()%>" <%} %>/></td>
					</tr>
					<tr>
						<td>Direccion:</td>
						<td><input type="text" name="direccion" <%if(local!=null) {%>value="<%=local.getDireccion()%>"<%} %>/></td>
					</tr>
					<tr>
						<td>Telefono:</td>
						<td><input type="text" name="telefono" <%if(local!=null) {%>value="<%=local.getTelefono()%>"<%} %>/></td>
					</tr>
					<tr>
						<td>Correo:</td>
						<td><input type="text" name="correo" <%if(local!=null) {%>value="<%=local.getCorreo()%>"<%} %>/></td>
					</tr>
					<tr>
						<td>Distrito:</td>
						<td><select name="distrito">
							<%for(int i=0;i<distritos.size();i++) { 
								%>
							<option value="<%=distritos.get(i).getId()%>"><%=distritos.get(i).getNdistrito() %></option>
							<%} %>
						</select>
			   			</td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="btnGuardar" value="Editar Local" /></td>
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


