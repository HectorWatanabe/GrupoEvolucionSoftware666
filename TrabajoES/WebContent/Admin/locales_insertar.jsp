<%@page import="beans.LocalBean"%>
<%@page import="beans.CategorieBean"%>
<%@page import="beans.DistritoBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Ingresar Datos</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/Admin/Layout1.css" />
</head>
<%Vector<DistritoBean> distritos=(Vector<DistritoBean>)request.getAttribute("distritos"); 
CategorieBean categoria = (CategorieBean)request.getAttribute("categoria");
LocalBean local = (LocalBean)request.getAttribute("local");
%>

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
				<li><a href="<%=getServletContext().getContextPath() %>/Usuario">Cerrar Sesión</a></li>
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
			
			<h2> Ingresar Datos del Nuevo Local</h2>
			
							<form action="<%=getServletContext().getContextPath() %>/Local?metodo=1&opcion=1" method="post">
				<table>
					
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="nlocal" /></td>
					</tr>
					<tr>
						<td>Direccion:</td>
						<td><input type="text" name="direccion" /></td>
					</tr>
					<tr>
						<td>Telefono:</td>
						<td><input type="text" name="telefono" /></td>
					</tr>
					<tr>
						<td>Correo:</td>
						<td><input type="text" name="correo" /></td>
					</tr>
					<tr>
						<td>Distrito:</td>
						<td><select name="distrito">
							<%for(int i=0;i<distritos.size();i++) {%>
							<option value="<%=distritos.get(i).getNdistrito()%>"><%=distritos.get(i).getNdistrito() %></option>
							<%} %>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="guardar" value="Guardar local" /></td>
					</tr>
				</table>
				</form>
									
							<% break;
				case 2:%>	
							<h2> Ingresar Datos Categoria</h2>
			
							<form action="<%=getServletContext().getContextPath() %>/Categoria?metodo=1" method="post">
				<table>
					
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="ncategoria" /></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="guardar" value="Guardar categoria" /></td>
					</tr>
				</table>
				</form>		
						
								
								

<%			break;

				case 3:%>
				
				<h2> Editar Datos Categoria</h2>
			
							<form action="<%=getServletContext().getContextPath() %>/Categoria?metodo=2" method="post">
							<input type="hidden" name="id" value="<%=categoria.getId() %>" >
					
				<table>
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="ncategoria" value="<%=categoria.getNcategoria() %>"></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="guardar" value="Guardar categoria" /></td>
					</tr>
				</table>
				</form>		
										
								<% break;
								
				case 4:%>
				
				<h2> Editar Datos del Local</h2>
			
							<form action="<%=getServletContext().getContextPath() %>/Local?metodo=2" method="post">
							<input type="hidden" name="id" value="<%=local.getLocal_id() %>" >
				<table>
					
					<tr>
						<td>Nombre:</td>
						<td><input type="text" name="nlocal" value="<%=local.getNlocal()%>" /></td>
					</tr>
					<tr>
						<td>Direccion:</td>
						<td><input type="text" name="direccion" value="<%=local.getDireccion()%>"/></td>
					</tr>
					<tr>
						<td>Telefono:</td>
						<td><input type="text" name="telefono" value="<%=local.getTelefono()%>"/></td>
					</tr>
					<tr>
						<td>Correo:</td>
						<td><input type="text" name="correo" value="<%=local.getCorreo()%>"/></td>
					</tr>
					<tr>
						<td>Distrito:</td>
						<td><select name="distrito">
							<%for(int i=0;i<distritos.size();i++) { if(distritos.get(i).getNdistrito().equalsIgnoreCase(local.getDistrito())){%>
							<option value="<%=distritos.get(i).getNdistrito()%>" selected="selected"><%=distritos.get(i).getNdistrito() %></option>
							<%}else{ %>
							<option value="<%=distritos.get(i).getNdistrito()%>"><%=distritos.get(i).getNdistrito() %></option>
							<%}} %>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="guardar" value="Guardar local" /></td>
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