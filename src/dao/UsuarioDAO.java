package dao;

import java.sql.Connection;
import java.sql.SQLException;

import factory.ConnectionFactory;
import modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	
	Long id;
	String nome;
	String cpf;
	String email;
	String telefone;
	
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Usuario usuario) {
		String sql = "INSERT INTO usuario(nome, cpf, email, telefone) VALUES(?, ?, ? ,?)";
		
		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getCpf());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getTelefone());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
}
