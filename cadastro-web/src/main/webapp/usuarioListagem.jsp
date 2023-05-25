<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 class="text-center">Lista de usuários</h1>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
		</tr>
		<c:forEach var = "usuario" items = "${listaUsuarios}" varStatus="id">
			<tr>
				<td> ${usuario.id} </td>
				<td> ${usuario.nome} </td>	
				<td><a href="mailto:${usuario.email}"> ${usuario.email} </a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>