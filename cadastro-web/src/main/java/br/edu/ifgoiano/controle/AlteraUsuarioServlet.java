package br.edu.ifgoiano.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

/**
 * Servlet implementation class AlteraUsuarioServlet
 */

@WebServlet("/alteraUsuario")
public class AlteraUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"), nome = req.getParameter("nome"), email = req.getParameter("email"), senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		Usuario usuario = new Usuario();
		usuario.setId(Integer.valueOf(id));
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha01);
		
		if(senha01.equals(senha02)) {
			
			UsuarioRepositorio repositorio = new UsuarioRepositorio();
			repositorio.alterarUsuario(usuario);
			
			//Redirecionar o usuário para a tela de listagem
			resp.sendRedirect("cadastrarUsuario");
	
		}else {
			String mensagem = usuario.getNome().concat(", as senhas informadas não são iguais");
			req.setAttribute("mensagem", mensagem);
			req.setAttribute("usuario", usuario);
			
			req.getRequestDispatcher("usuarioAlterar.jsp").forward(req , resp);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("usuarioId"));
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		Usuario usuario = repositorio.obterUsuario(id);
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuarioAlterar.jsp").forward(request, response);
	}
}
