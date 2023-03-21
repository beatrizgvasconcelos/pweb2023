package br.edu.ifgoiano.controle;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String senha1 = req.getParameter("senha1");
		String senha2 = req.getParameter( "senha2");
	
		
		//verificar se as senhas são iguais
		if(senha1.equals(senha2)) {
			//redirecionar o ususario para a pagina de login
			resp.sendRedirect("index.html");
		
		}else {
	//redirecionar o usuario para mesma pagina de cadastro do usuario
			req.getRequestDispatcher("cadastroUsuario.html").forward(req, resp);
		}
	}
}
 