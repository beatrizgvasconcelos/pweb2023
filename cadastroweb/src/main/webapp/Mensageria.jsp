<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Mensageria </title>
</head>
<body>
	<h1>Formulário de Email</h1>

  

 


<form>
    

   
<label for="email">Escolha um email:</label>
    <select id="email" name="email">
      <option value="email1@example.com">email1@example.com</option>
      <option value="email2@example.com">email2@example.com</option>
      <option value="email3@example.com">email3@example.com</option>
    </select>
    <br><br>

    <label for="cumprimento">Tipo de Cumprimento:</label>
    
   
<input type="radio" id="formal" name="cumprimento" value="formal">
    
    <

   
<label for="formal">Cumprimento Formal</label>
    <input type="radio" id="horario" name="cumprimento" value="horario">
    
   
<label for="horario">Cumprimento por Horário</label>
    
   
<br><br>

    <label for="aviso">Aviso de Email Automático:</label>
    
   
<input type="checkbox" id="aviso" name="aviso">
    <br><br>

    <label for="titulo">Título do Email:</label>
    <input type="text" id="titulo" name="titulo">
    <br><br>

    <label for="assunto">Assunto do Email:</label><br>
    <textarea id="assunto" name="assunto" rows="8" cols="50"></textarea>
    
   
<br><br>

    

   


<input type="submit" value="Enviar">
  
 
</form>



</


</
</body>
</html>
