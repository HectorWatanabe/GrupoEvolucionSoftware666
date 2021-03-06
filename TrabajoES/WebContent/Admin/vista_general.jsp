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
<script language="javascript" type="text/javascript"></script>
<title>Delicia's Lista</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/Admin/Layout1.css" />
</head>

<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/logo.png"></div>
		<div id="menuar">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/Admin/vista_general.jsp?numero=3">Nosotros</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Local?metodo=1&opcion=3">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=2&opcion=3">La Carta</a></li>
				<li><a href="">Promociones</a></li>
			</ul>
			<div class="separar"></div>
		</div>
	</div>

	<div id="cuerpo">
		<div id="menuiz">
			<ul>
				<li><a href="<%=getServletContext().getContextPath() %>/Admin/usuario_insertar.jsp?numero=1">Registrar</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Admin/usuario_insertar.jsp?numero=2">Ingresar</a></li>
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
			<h2 style=" margin-left: 50px;"> Lista de Locales </h2>
			<table id="box-table-a">
				<thead>
					<tr>
						<th>Nombres</th>
						<th>Direccion</th>
						<th>Distrito</th>
						<th>Visitar</th>
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
						<td><a href="<%=getServletContext().getContextPath() %>/Local?metodo=4&codigo=<%=locales.get(i).getLocal_id() %>">Ver</a></td>
					
					<%
						}
					%>
				</tbody>
			</table>
				
					<%
					break;
					
					case 2:%>
					<%Vector<ProductoBean> productos=(Vector<ProductoBean>)request.getAttribute("productos"); %>
			<h2 style=" margin-left: 50px;"> Lista de Productos </h2>
			<table id="box-table-a">
				<thead>
					<tr>
						<th>Nombres</th>
						<th>Categoria</th>
						<th>Descripcion</th>
						<th>Precio</th>
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
				
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		
					<% break;
					case 3:
						break;
					

					
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