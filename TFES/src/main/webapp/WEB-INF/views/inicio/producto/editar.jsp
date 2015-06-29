<%@page import="pe.com.modelo.Producto"%>
<%@page import="pe.com.modelo.Categoria"%>
<%@page import="java.util.ArrayList"%>
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

<%ArrayList<Categoria> categorias=(ArrayList<Categoria>)request.getAttribute("categorias");

Producto producto = (Producto)request.getAttribute("producto");%>
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
			
			
				
				<h2> Editar Producto</h2>
			<p class="mensajeerror">${mensaje}</p>
				<form:form action="editar" method="post">
				<table>
					<tr>
					<td><%if(producto!=null) {%><input type="hidden" name="id" value="<%=producto.getId() %>" ><%} %></td>
					</tr>
					<tr>
						<td>Categoria:</td>
						<td>
							<select name="categoria_id">
								<%for(int i=0;i<categorias.size();i++) {%>
								<option value="<%=categorias.get(i).getId()%>"><%=categorias.get(i).getNcategoria() %></option>
								<%} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="nproducto" <%if(producto!=null) {%>value="<%=producto.getNproducto() %>"<%} %> /></td>
					</tr>
					<tr>
						<td>Descripción:</td>
						<td><input type="text" name="descripcion" <%if(producto!=null) {%>value="<%=producto.getDescripcion() %>"<%} %> /></td>
					</tr>
					<tr>
						<td>Precio:</td>
						<td><input type="text" name="precio" <%if(producto!=null) {%>value="<%=producto.getPrecio() %>" <%} %>/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="guardar" value="Editar producto" /></td>
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


