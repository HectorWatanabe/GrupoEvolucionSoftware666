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

<h2>Registro de Distrito</h2>
<form:form action="distrito/agregar" method="post">
<div>Nombre Distrito: <form:input path="ndistrito" /></div>
<input type="submit" name="btnGuardar" value="Guardar Distrito" />
</form:form>

</body>
</html>