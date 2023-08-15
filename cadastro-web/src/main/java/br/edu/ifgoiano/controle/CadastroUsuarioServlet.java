package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 7869758393435911873L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String senha1 = req.getParameter("senha1");
		String senha2 = req.getParameter("senha2");

		if(senha1.equals(senha2)){
			Usuario usu = new Usuario();
			usu.setEmail(req.getParameter("email"));
			usu.setSenha(senha1);
			
			UsuarioRepositorio repositorio = new UsuarioRepositorio();
			repositorio.inserirUsuario(usu);
			
			resp.sendRedirect("index.html");
		}else {
			req.getRequestDispatcher("usuarioCadastro.jsp").forward(req, resp);
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioRepositorio repositorio = new UsuarioRepositorio();

		req.setAttribute("usuarios", repositorio.listarUsuario());

		req.getRequestDispatcher("usuarioListagem.jsp").forward(req, resp);
	}

}
