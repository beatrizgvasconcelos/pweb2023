package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
