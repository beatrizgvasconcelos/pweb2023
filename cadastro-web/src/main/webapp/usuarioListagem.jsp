<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Lista de usuários</h1>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
		</tr>
		<c:forEach var = "usuario" items = "${listagemUsuario}" varStatus="id">
			<tr>
				<td> ${usuario.id} </td>
				<td> ${usuario.nome} </td>	
				<td><a href="mailto:${usuario.email}"> ${usuario.email} </a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>                       