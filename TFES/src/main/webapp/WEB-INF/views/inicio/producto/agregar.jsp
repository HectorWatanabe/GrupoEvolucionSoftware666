<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Registro de Producto</h2>
<form:form action="producto/agregar" method="post">
<div>Nombre del Producto: <form:input path="nproducto" /></div>
<div>Descripcion: <form:input path="descripcion" maxlength="200"/></div>
<div>Distrito: <form:select path="categoria_id">
					<c:forEach items="${categorias}" var="categoria">
						<form:option value="${categoria.id}">${categoria.ncategoria}</form:option>  
					</c:forEach>
			   </form:select> </div>

<div>Precio: <form:input path="precio" /></div>

<input type="submit" name="btnGuardar" value="Guardar " />
</form:form>

</body>
</html>