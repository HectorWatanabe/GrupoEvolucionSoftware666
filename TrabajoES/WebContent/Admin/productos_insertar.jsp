
<%@page import="beans.ProductoBean"%>
<%@page import="beans.CategorieBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Ingresar Productos</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/Admin/Layout1.css" />
</head>
<%Vector<CategorieBean> categorias=(Vector<CategorieBean>)request.getAttribute("categorias");

ProductoBean producto = (ProductoBean)request.getAttribute("producto");%>
<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=2&opcion=1">Comida</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Categoria?metodo=1">Categorias</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Local?metodo=1&opcion=1">Locales</a></li>
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
			<%try {
				int opcion = Integer.parseInt(request.getParameter("numero"));
				switch(opcion)
				{
				case 1:%>
			<h2> Ingresar Datos del Nuevo Producto</h2>
			
			<form action="<%=getServletContext().getContextPath() %>/Producto?metodo=1" method="post">
<table>
	<tr>
		<td>Categoria:</td>
		<td>
			<select name="categoria_id">
				<%for(int i=0;i<categorias.size();i++) { %>
				<option value="<%=categorias.get(i).getId()%>"><%=categorias.get(i).getNcategoria() %></option>
				
				<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<td>Nombre:</td>
		<td><input type="text" name="nproducto" /></td>
	</tr>
	<tr>
		<td>Descripción:</td>
		<td><input type="text" name="descripcion" /></td>
	</tr>
	<tr>
		<td>Precio:</td>
		<td><input type="text" name="precio" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="guardar" value="Guardar producto" /></td>
	</tr>
</table>
</form>
					
<% break;

				case 2:%>
				<h2> Editar Datos del Producto</h2>
				
				<form action="<%=getServletContext().getContextPath() %>/Producto?metodo=2" method="post">
			<input type="hidden" name="id" value="<%=producto.getId() %>" >
<table>
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
		<td><input type="text" name="nproducto" value="<%=producto.getNproducto() %>" /></td>
	</tr>
	<tr>
		<td>Descripción:</td>
		<td><input type="text" name="descripcion" value="<%=producto.getDescripcion() %>" /></td>
	</tr>
	<tr>
		<td>Precio:</td>
		<td><input type="text" name="precio" value="<%=producto.getPrecio() %>" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="guardar" value="Guardar producto" /></td>
	</tr>
</table>
</form>
						
	<% break;


				
				}} catch(Exception E ) {%>
	<%@include file="/Admin/mensaje.jsp" %><%
}%>		
			
			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
</body>
</html>