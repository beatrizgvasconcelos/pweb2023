<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
		<h1 class="fs-4">Alteração de Usuário</h1>
			<form action="alteraUsuario" method="post" class="d-flex flex-column  p-5">
				<label for="nome" class="form-label" value= "${usuario.nome}">Nome: </label> 
				<input type="text" name="nome" id="nome" class="form-control" value="${usuario.nome}"> 
				<label for="email" class="form-label">E-mail:</label> 
				<input type="text" name="email" id="email" class="form-control" value="${usuario.email}"> 
				<label for="senha01" class="form-label">Senha:</label> 
				<input type="password" name="senha01" id="senha01" class="form-control">

				<label for="senha02" class="form-label">Senha confirmada:</label> 
				<input type="password" name="senha02" id="senha02" class="form-control">
				
				<input type="hidden" name="id" id="id" value="${usuario.id}">
				
				<div class="d-flex align-items-center justify-content-evenly mt-3">
					<input type="submit" value="Salvar" class="btn btn-success">
					<a href="cadastrarUsuario" class="btn btn-danger">Voltar</a>
				</div>
			</form>
			<c:if test="${not empty mensagem}">
				<div class="alert alert-danger" role="alert">
						<span>${mensagem}</span>
				</div>
			</c:if>	
	</div>
</body>
</html>