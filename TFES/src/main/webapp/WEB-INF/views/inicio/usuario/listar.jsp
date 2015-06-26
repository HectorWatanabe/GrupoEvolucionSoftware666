<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Listado Usuarios</h2>
<ul>
<c:forEach items="${usuarios}" var="usuario">
	<li>
		Id: ${usuario.id}<br />
	</li>
	<li>
		Usuario: ${usuario.usuario}<br />
	</li>
	<li>
		Nombre Usuario: ${usuario.nusuario}<br />
	</li>
	<li>
		Apellido Usuario: ${usuario.ausuario}<br />
	</li>
	<li>
		Clave: ${usuario.clave}<br />
	</li>
	<li>
		Nacimiento: ${usuario.nacimiento}<br />
	</li>
	<li>
		Tipo: ${usuario.tipo}<br />
	</li>
	<li>
		DNI: ${usuario.dni}<br />
	</li>
	<li>
		Direccion: ${usuario.direccion}<br />
	</li>
	<li>
		Telefono: ${usuario.telefono}<br />
	</li>
</c:forEach>
</ul>
</body>
</html>