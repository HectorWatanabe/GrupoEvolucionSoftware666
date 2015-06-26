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

<h2>Registro de Categoria</h2>
<form:form action="categoria/agregar" method="post">
<div>Nombre Categoria: <form:input path="ncategoria" /></div>
<input type="submit" name="btnGuardar" value="Guardar Categoria" />
</form:form>

</body>
</html>