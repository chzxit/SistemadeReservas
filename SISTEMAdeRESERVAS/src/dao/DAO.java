package dao;

import controller.Conexao;
import model.Hospede;
import model.Quarto;
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

	private static String CADASTRAR_HOSPEDES = " INSERT INTO HOSPEDES (ID, NOME, CPF, CEP, TELEFONE, DATANASCIMENTO ) VALUES(NULL,?,?,?,?,?)";

	private static String CONSULTAR_HOSPEDES = " SELECT * FROM HOSPEDES  WHERE ID = ? ";

	private static String ALTERAR_HOSPEDES = " UPDATE HOSPEDES SET NOME = ? , CPF = ?, CEP = ?, TELEFONE = ?, DATANASCIMENTO = ? WHERE ID = ? ";

	private static String EXCLUIR_HOSPEDES = " DELETE FROM HOSPEDES  WHERE ID = ? ";

	private static String LISTAR_HOSPEDES = " SELECT * FROM HOSPEDES WHERE 1 = 1 ";

	private static String CONSULTAR_USUARIO = " SELECT NOME, SENHA  " + " FROM USUARIO "
			+ " WHERE NOME = ? AND SENHA = ? ";

	private static String CADASTRAR_USUARIO = " INSERT INTO USUARIO (NOME,SENHA ) VALUES(?,?)";

	private static String CADASTRAR_QUARTOS = " INSERT INTO QUARTOS (ID, NUMERO ) VALUES(NULL,?)";

	private static String LISTAR_QUARTOS = " SELECT * FROM QUARTOS WHERE 1 = 1 ";

	public DAO() {

	}

	public void cadastrarHospedes(Hospede hospede) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = CADASTRAR_HOSPEDES;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, hospede.getNome());
			preparedStatement.setString(i++, hospede.getCpf());
			preparedStatement.setString(i++, hospede.getCep());
			preparedStatement.setString(i++, hospede.getTelefone());
			preparedStatement.setString(i++, hospede.getDataNascimento());

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

	}

	public Hospede consultarHospedes(int id) throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = CONSULTAR_HOSPEDES;
		Hospede hospede = null;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setInt(i++, id);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				hospede = new Hospede(resultSet.getString("id"), resultSet.getString("nome"),
						resultSet.getString("Telefone"), resultSet.getString("cpf"), resultSet.getString("cep"),
						resultSet.getString("dataNascimento"));

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

	public void alterarHospedes(String id, Hospede hospede) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = ALTERAR_HOSPEDES;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, hospede.getNome());
			preparedStatement.setString(i++, hospede.getCpf());
			preparedStatement.setString(i++, hospede.getCep());
			preparedStatement.setString(i++, hospede.getTelefone());
			preparedStatement.setString(i++, hospede.getDataNascimento());
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

	public void excluirHospedes(String id) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = EXCLUIR_HOSPEDES;
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

	public ArrayList<Hospede> listarHospedes() throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		ArrayList<Hospede> hospedes = new ArrayList<>();
		String query = LISTAR_HOSPEDES;

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				hospedes.add(new Hospede(resultSet.getString("id"), resultSet.getString("nome"),
						resultSet.getString("telefone"), resultSet.getString("cpf"), resultSet.getString("cep"),
						resultSet.getString("dataNascimento")));

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

	public void cadastrarQuartos(Quarto quarto) {
		Connection connection = Conexao.getInstancia().abrirConexao();

		String query = CADASTRAR_QUARTOS;
		try {
			preparedStatement = connection.prepareStatement(query);

			int i = 1;

			preparedStatement.setString(i++, quarto.getNumero());

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Quarto reservado com sucesso! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

	}

	public ArrayList<Quarto> listarQuartos() throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		ArrayList<Quarto> quartos = new ArrayList<>();
		String query = LISTAR_QUARTOS;

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				quartos.add(new Quarto(resultSet.getString("numero"), resultSet.getBoolean("disponivel"),
						resultSet.getString("id")));

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			fecharConexao();
		}

		{
			if (quartos.size() < 0) {

				JOptionPane.showMessageDialog(null, "Não há quartos reservados ", "", JOptionPane.WARNING_MESSAGE);
				throw new Exception("Não há quartos reservados");
			}
			return quartos;
		}
	}

}