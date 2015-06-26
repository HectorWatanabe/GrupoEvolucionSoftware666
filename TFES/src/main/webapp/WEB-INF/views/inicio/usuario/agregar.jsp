<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Registro de Usuario</h2>
<form:form action="usuario/agregar" method="post">
<div>Usuario: <form:input path="usuario" /></div>
<div>Nombre del Usuario: <form:input path="nusuario" /></div>
<div>Apellido del Usuario: <form:input path="ausuario" /></div>
<div>Clave: <form:password path="clave" maxlength="6"/></div>
<div>Nacimiento: <form:input path="nacimiento" /></div>
<div>Dni: <form:input path="dni" maxlength="8" /></div>
<div>Direccion: <form:input path="direccion" /></div>
<div>Telefono: <form:input path="telefono" maxlength="9" /></div>
<input type="submit" name="btnGuardar" value="Registro" />
</form:form>

</body>
</html>