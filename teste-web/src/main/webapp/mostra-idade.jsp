<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


	<jsp:useBean id="pessoa" class= "br.edu.ifgoiano.entidade.pessoa"></jsp:useBean>
	<span>Testando seus par�metros:</span><br/>
	 <span>A idade � ${param.idade }. e a altura � {pessoa.altura}</span>
</body>
