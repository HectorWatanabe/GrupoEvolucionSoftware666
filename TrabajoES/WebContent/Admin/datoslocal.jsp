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
<% LocalBean local = (LocalBean)request.getAttribute("local"); %>
<body>
<div id="contenedor">
	<div id="cabecera">
		<div id="logo"><img id="logod" src="<%=getServletContext().getContextPath() %>/logo.png"></div>
		<%int opcion = Integer.parseInt(request.getParameter("opcion"));
				switch(opcion)
				{
				case 1:%>
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
		</div><%break;
		case 2:%>
		<div id="menuar">
		<ul>
			<li><a href="<%=getServletContext().getContextPath() %>/Admin/vista_general.jsp?numero=3">Nosotros</a></li>
			<li><a href="<%=getServletContext().getContextPath() %>/Local?metodo=1&opcion=3">Locales</a></li>
			<li><a href="<%=getServletContext().getContextPath() %>/Producto?metodo=2&opcion=3">La Carta</a></li>
			<li><a href="">Pedidos</a></li>
		</ul>
		<div class="separar"></div>
	</div>
</div>

<div id="cuerpo">

	<div id="menuiz">
		<ul>
			<li><a href="<%=getServletContext().getContextPath() %>/Usuario">Cerrar Sesión</a></li>
				<li><a href="">Datos Usuario</a></li>
		</ul>
	</div>
		
		
	<%	break;}%>
		<div id="contenido">
			
			<% try {
				 %>
				<h1><%=local.getNlocal() %></h1>
					<p style=" margin: 15px; font-size: 15px;">	<strong>Direccion:</strong><%=local.getDireccion() %></p>
					<p style=" margin: 15px; font-size: 15px;">	<strong>Distrito:</strong><%=local.getDistrito() %> </p>
					<p style=" margin: 15px; font-size: 15px;">	<strong>Correo:</strong><%=local.getCorreo() %></p>
					<p style=" margin: 15px; font-size: 15px;">	<strong>Telefono:</strong><%=local.getTelefono() %></p>
					
				<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=es&callback=iniciar"></script>

				<script>
				function iniciar() {
				var mapOptions = {
				center: new google.maps.LatLng(25.80, -80.30),
				zoom: 10,
				mapTypeId: google.maps.MapTypeId.ROADMAP};
				var map = new google.maps.Map(document.getElementById("mapa"),mapOptions);}		
				</script>
				
				<div id="mapa"></div>
				
				
				
				
<%
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