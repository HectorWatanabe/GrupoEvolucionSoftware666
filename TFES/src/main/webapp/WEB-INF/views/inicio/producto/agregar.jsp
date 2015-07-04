<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delicia's Ingresar Datos</title>
<link rel="stylesheet" type="text/css" href="<%=getServletContext().getContextPath() %>/resources/css/Layout1.css" />
</head>


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
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/login/cerrarsesion">Cerrar Sesi�n</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/usuario/datos">Datos Usuario</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/inicio/distrito/listado">Distritos</a></li>
				
				<li></li>
			</ul>
		</div>
		<div id="contenido">
			
			
				
				<h2> Agregar Platillo </h2>
			<p class="mensajeerror">${mensaje}</p>
				<form:form action="producto" method="post">
				<table>
					<tr>
						<td>Nombre del Producto:</td>
						<td><form:input path="nproducto" /></td>
					</tr>
					<tr>
						<td>Descripcion:</td>
						<td><form:input path="descripcion" maxlength="200"/></td>
					</tr>
					<tr>
						<td>Categoria:</td>
						<td><form:select path="categoria_id">
							<c:forEach items="${categorias}" var="categoria">
							<form:option value="${categoria.id}">${categoria.ncategoria}</form:option>  
							</c:forEach>
			  			 	</form:select>
			  			</td>
					</tr>
					<tr>
						<td>Precio:</td>
						<td><form:input path="precio" /></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" name="btnGuardar" value="Guardar Producto " /></td>
					</tr>
				</table>
				</form:form>		
										
		
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>�Delicia's</div>
</div>
</body>
</html>


