package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.entidade.Usuario;

public class UsuarioRepositorio {

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
	}

	public List<Usuario> listarUsuario() {
		ArrayList<Usuario> lstUsuario = new ArrayList<Usuario>();

		String sql = "select id, nome, email, data_nascimento from usuario";

		try (Connection conn = this.getConnection(); 
			 PreparedStatement pst = conn.prepareStatement(sql);) {

			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setDataNascimento(resultSet.getDate("data_nascimento"));

				lstUsuario.add(usuario);
			}
		} catch (SQLException ex) {
			System.out.println("Erro na consulta de usuarios");
			ex.printStackTrace();
		}
		return lstUsuario;

	}

	public void inserirUsuario(Usuario usuario) {
		//Criar a SQL de insert
		StringBuilder sql = new StringBuilder();
		sql.append("insert into usuario ");
		sql.append("(nome, email, senha) ");
		sql.append("values(?, ?, ?)");
		
		try(Connection conn = this.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql.toString());
			) {
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.execute();
			
			conn.commit();
			
		} catch (SQLException e) {
			System.out.println("Erro na inclusão de usuario");
			e.printStackTrace();
		}
	}
	
	public Usuario obterUsuario(int id) {
		String sql = "SELECT nome, email, senha FROM usuario WHERE id = ?";
		
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, id);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(id);
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				
				return usuario;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar o usuário");
			e.printStackTrace();
		}
		
		throw new RuntimeException("Usuário não encontrado!");	
	}
	
	public void alterarUsuario(Usuario usuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario ");
		sql.append("SET nome = ?, email = ?, senha = ?");
		sql.append("WHERE id= ?");
		
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql.toString())) {
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setInt(4, usuario.getId());
			pst.execute();
			
			conn.commit();
		} catch (SQLException e) {
			System.out.println("Erro na edição de usuários");
			e.printStackTrace();
		}
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	

