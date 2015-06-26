<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsf/html"  prefix="h"%> 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >

   <h:head>
      <title>JSF Tutorial!</title>
      <h:outputStylesheet library="css" name="Layout1.css"  />
   </h:head>
   <h:body>
   <div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/logo.png"></div>
		<div id="menuar">
			<ul>
			<li><a href="<%=getServletContext().getContextPath() %>/Admin/listas_vistaU.jsp?numero=3">Nosotros</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Local?metodo=1&opcion=2">Locales</a></li>
				<li><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=2&opcion=2">La Carta</a></li>
				<li><a href="">Pedidos</a></li>
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

<h1>USUARIOS</h1>
			
			
		</div>
		<div class="separar"></div>
	</div>

	<div id="pie"> <br>©Delicia's</div>
</div>
   </h:body>
</html> 