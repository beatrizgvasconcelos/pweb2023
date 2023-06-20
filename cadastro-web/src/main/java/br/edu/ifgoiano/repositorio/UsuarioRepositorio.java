package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.entidade.Usuario;

public class UsuarioRepositorio {

	
	public UsuarioRepositorio() {
	
	// TODO Auto-generated constructor stub
		
	    try {
			Connection conn = DriverManager.
			        getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
			System.out.println("Conexão realizada com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro na conexão com o baco de dadoss.");
			e.printStackTrace();
		}
		
	}
	public List<Usuario> listarUsuarios(){
		List<Usuario> lstUsuarios =  new ArrayList<Usuario>();
		
		String sql = "select id, nome, email, senha, data_nascimento from usuario";
		
		
		
		
		