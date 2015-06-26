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

<h2>Registro de Local</h2>
<form:form action="local/agregar" method="post">
<div>Nombre del Local: <form:input path="nlocal" /></div>
<div>Direccion: <form:input path="direccion" /></div>
<div>Telefono: <form:input path="telefono" maxlength="7"/></div>
<div>Correo: <form:input path="correo" /></div>
<div>Distrito: <form:select path="distrito">
					<c:forEach items="${distritos}" var="distrito">
						<form:option value="${distrito.id}">${distrito.ndistrito}</form:option>  
					</c:forEach>
			   </form:select> </div>

<input type="submit" name="btnGuardar" value="Guardar Distrito" />
</form:form>

</body>
</html>