<%@page import="beans.CategorieBean"%>
<%@page import="dao.CategoriaDao"%>
<%@page import="beans.ProductoBean"%>
<%@page import="beans.LocalBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Lista de Locales</title>
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
			
			<% try {
				int opcion = Integer.parseInt(request.getParameter("numero"));
				switch(opcion)
				{
				case 1:%>
					<%Vector<LocalBean> locales=(Vector<LocalBean>)request.getAttribute("locales"); %>
			<h2> Lista de Locales </h2>
			<table>
				<thead>
					<tr>
						<th>Nombres</th>
						<th>Direccion</th>
						<th>Distrito</th>
						<th>Telefono</th>
						<th>Correo</th>
						<th colspan="2">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(int i=0; i<locales.size();i++){			
					%>
					<tr>
						<td><%=locales.get(i).getNlocal()%></td>
						<td><%=locales.get(i).getDireccion()%></td>
						<td><%=locales.get(i).getDistrito()%></td>
						<td><%=locales.get(i).getTelefono()%></td>
						<td><%=locales.get(i).getCorreo()%></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Local_Borrar?codigo=<%=locales.get(i).getLocal_id()%>">Borrar</a></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Local_Editar?codigo=<%=locales.get(i).getLocal_id()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
					
					<%
					break;
					
					case 2:%>
					<%Vector<ProductoBean> productos=(Vector<ProductoBean>)request.getAttribute("productos"); %>
			<h2> Lista de Productos </h2>
			<table>
				<thead>
					<tr>
						<th>Nombres</th>
						<th>Categoria</th>
						<th>Descripcion</th>
						<th>Precio</th>
						<th colspan="2">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(int i=0; i<productos.size();i++){			
					%>
					<tr>
						<td><%=productos.get(i).getNproducto()%></td>
						<td><%=productos.get(i).getCategoria_id() %></td>
						<td><%=productos.get(i).getDescripcion()%></td>
						<td><%=productos.get(i).getPrecio()%></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Local_Borrar?codigo=<%=productos.get(i).getId()%>">Borrar</a></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Local_Editar?codigo=<%=productos.get(i).getId()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
					<% break;
				
					

					case 3:%>
					<%Vector<CategorieBean> categorias=(Vector<CategorieBean>)request.getAttribute("categorias"); %>
			<h2> Lista de Categorias </h2>
			<table>
				<thead>
					<tr>
						<th>Nombres</th>
						<th colspan="2">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(int i=0; i<categorias.size();i++){			
					%>
					<tr>
						<td><%=categorias.get(i).getNcategoria()%></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Local_Borrar?codigo=<%=categorias.get(i).getId()%>">Borrar</a></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Local_Editar?codigo=<%=categorias.get(i).getId()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
					<% break;
					
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