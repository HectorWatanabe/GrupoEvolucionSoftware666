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
<title>Delicia's Lista</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/Admin/Layout1.css" />
</head>

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
				<li><a href="<%=getServletContext().getContextPath() %>/Usuario">Cerrar Sesi�n</a></li>
				<li><a href="">Datos Usuario</a></li>
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			<% try {
				int opcion = Integer.parseInt(request.getParameter("numero"));
				switch(opcion)
				{
				case 1:%>
					<%Vector<LocalBean> locales=(Vector<LocalBean>)request.getAttribute("locales"); %>
			<h1> Lista de Locales </h1>
			<table id="box-table-a">
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
						<td><a href="<%=getServletContext().getContextPath() %>/Local?metodo=2&codigo=<%=locales.get(i).getLocal_id()%>">Borrar</a></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Local?metodo=3&codigo=<%=locales.get(i).getLocal_id()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<br><br>
			<a href="<%=getServletContext().getContextPath() %>/Distrito?metodo=1"><input type="button" value="Ingresar Local"></a>
					
					<%
					break;
					
					case 2:%>
					<%Vector<ProductoBean> productos=(Vector<ProductoBean>)request.getAttribute("productos"); %>
			<h1> Lista de Productos </h1>
			<table id="box-table-a">
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
						<td><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=4&codigo=<%=productos.get(i).getId()%>">Borrar</a></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=3&codigo=<%=productos.get(i).getId()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
				<br><br>
			<a href="<%=getServletContext().getContextPath() %>/Producto?metodo=1"><input type="button" value="Ingresar Producto"></a>
				
					<% break;
				
					

					case 3:%>
					<%Vector<CategorieBean> categorias=(Vector<CategorieBean>)request.getAttribute("categorias"); %>
			<h1> Lista de Categorias </h1>
			<table id="box-table-a">
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
						<td><a href="<%=getServletContext().getContextPath() %>/Categoria?metodo=2&codigo=<%=categorias.get(i).getId()%>">Borrar</a></td>
						<td><a href="<%=getServletContext().getContextPath() %>/Categoria?metodo=3&codigo=<%=categorias.get(i).getId()%>">Editar</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
				<br><br>
			<a href="<%=getServletContext().getContextPath() %>/Admin/locales_insertar.jsp?numero=2"><input type="button" value="Ingresar Categoria"></a>
				
					<% break;
					
				}

} catch(Exception E ) {%>
	<%@include file="/Admin/mensaje.jsp" %><%
}%>	
			
			
			
			
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>�Delicia's</div>
</div>
</body>
</html>