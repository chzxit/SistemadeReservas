package dao;

import controller.Conexao;
import model.Hospede;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAO {
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	private static String CADASTRAR_HOSPEDE = " INSERT INTO HOSPEDE (ID, NOME, CPF, CEP, TELEFONE, DATANASCIMENTO ) VALUES(NULL,?,?,?,?,?)";

	private static String CONSULTAR_HOSPEDE = " SELECT * FROM HOSPEDE  WHERE ID = ? ";

	private static String ALTERAR_HOSPEDE = " UPDATE HOSPEDE SET NOME = ? , CPF = ?, CEP = ?, TELEFONE = ?, DATANASCIMENTO = ? WHERE ID = ? ";

	private static String EXCLUIR_HOSPEDE = " DELETE FROM HOSPEDE  WHERE ID = ? ";

	private static String LISTAR_HOSPEDE = " SELECT * FROM HOSPEDE WHERE 1 = 1 ";

	private static String CONSULTAR_USUARIO = " SELECT NOME, SENHA  " + " FROM USUARIO " + " WHERE NOME = ? AND SENHA = ? ";

	private static String CADASTRAR_USUARIO = " INSERT INTO USUARIO (NOME,SENHA ) VALUES(?,?)";

	public DAO() {

	}

	public void cadastrarHospede(Hospede hospede) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = CADASTRAR_HOSPEDE;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;
			
			preparedStatement.setString(i++, hospede.getNome());
			preparedStatement.setString(i++, hospede.getCpf());
			preparedStatement.setString(i++, hospede.getCep());
			preparedStatement.setString(i++, hospede.getTelefone());
			preparedStatement.setInt(i++, hospede.getDataNascimento());

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

	}

	public Hospede consultarHospede(int id) throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = CONSULTAR_HOSPEDE;
		Hospede hospede = null;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setInt(i++, id);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				hospede = new Hospede(resultSet.getInt("id"), resultSet.getString("nome"),
						resultSet.getString("Telefone"), resultSet.getString("cpf"), resultSet.getString("cep"),
						resultSet.getInt("dataNascimento"));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

		{
			if (hospede == null) {

				JOptionPane.showMessageDialog(null, "Não foi possivel localizar o hóspede selecionado", "",
						JOptionPane.WARNING_MESSAGE);
				throw new Exception("Não foi possivel localizar o hóspede selecionado");
			}
			return hospede;
		}
	}

	public void alterarCliente(String id, Hospede hospede) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = ALTERAR_HOSPEDE;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, hospede.getNome());
			preparedStatement.setString(i++, hospede.getCpf());
			preparedStatement.setString(i++, hospede.getCep());
			preparedStatement.setString(i++, hospede.getTelefone());
			preparedStatement.setInt(i++, hospede.getDataNascimento());
			preparedStatement.setString(i++, id);

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Hóspede alterado com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

	}

	public void excluirCliente(String id) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = EXCLUIR_HOSPEDE;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, id);

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Hóspede excluido com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

	}

	public ArrayList<Hospede> listarHospede() throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		ArrayList<Hospede> hospedes = new ArrayList<>();
		String query = LISTAR_HOSPEDE;

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				hospedes.add(new Hospede(resultSet.getInt("id"), resultSet.getString("nome"),
						resultSet.getString("telefone"), resultSet.getString("cpf"), resultSet.getString("cep"),
						resultSet.getInt("dataNascimento")));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

		{
			if (hospedes.size() < 0) {

				JOptionPane.showMessageDialog(null, "Não há hóspedes cadastrados ", "", JOptionPane.WARNING_MESSAGE);
				throw new Exception("Não há hóspedes cadastrados");
			}
			return hospedes;
		}
	}

	public Usuario consultarUsuario(String nome, String senha) throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		Usuario usuario = null;
		String query = CONSULTAR_USUARIO;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, nome);
			preparedStatement.setString(i++, senha);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				usuario = new Usuario(resultSet.getString("NOME"), resultSet.getString("SENHA"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado ", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Usuário não cadastrado");
		}
		return usuario;

	}

	public void cadastrarUsuario(Usuario usuario) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = CADASTRAR_USUARIO;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;
			
			preparedStatement.setString(i++, usuario.getNome());
			preparedStatement.setString(i++, usuario.getSenha());

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

	}

	private void fecharConexao() {
		try {
			if (resultSet != null) {
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			Conexao.getInstancia().fecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}