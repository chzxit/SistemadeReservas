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

	private static final String CADASTRAR_HOSPEDES = "INSERT INTO HOSPEDES (ID, NOME, CPF, CEP, TELEFONE, DATANASCIMENTO) VALUES(NULL,?,?,?,?,?)";

	private static final String CONSULTAR_HOSPEDES = "SELECT * FROM HOSPEDES WHERE ID = ?";

	private static final String ALTERAR_HOSPEDES = "UPDATE HOSPEDES SET NOME = ?, CPF = ?, CEP = ?, TELEFONE = ?, DATANASCIMENTO = ? WHERE ID = ?";

	private static final String EXCLUIR_HOSPEDES = "DELETE FROM HOSPEDES WHERE ID = ?";

	private static final String LISTAR_HOSPEDES = "SELECT * FROM HOSPEDES";

	private static final String CONSULTAR_USUARIO = "SELECT NOME, SENHA FROM USUARIO WHERE NOME = ? AND SENHA = ?";

	private static final String CADASTRAR_USUARIO = "INSERT INTO USUARIO (NOME, SENHA) VALUES(?,?)";

	private static final String CADASTRAR_QUARTOS = "INSERT INTO QUARTOS (ID,NUMERO, STATUS) VALUES (NULL,?,'disponivel')";

	private static final String RESERVAR_QUARTOS = "SELECT STATUS FROM QUARTOS WHERE NUMERO = ?";

	private static final String LISTAR_QUARTOS = "SELECT * FROM QUARTOS";
	
	

	public void cadastrarHospedes(Hospede hospede) {
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(CADASTRAR_HOSPEDES)) {

			preparedStatement.setString(1, hospede.getNome());
			preparedStatement.setString(2, hospede.getCpf());
			preparedStatement.setString(3, hospede.getCep());
			preparedStatement.setString(4, hospede.getTelefone());
			preparedStatement.setString(5, hospede.getDataNascimento());

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Hóspede cadastrado com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar hóspede: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public Hospede consultarHospedes(int id) throws Exception {
		Hospede hospede = null;
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_HOSPEDES)) {

			preparedStatement.setInt(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					hospede = new Hospede(resultSet.getString("id"), resultSet.getString("nome"),
							resultSet.getString("telefone"), resultSet.getString("cpf"), resultSet.getString("cep"),
							resultSet.getString("dataNascimento"));
				}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar hóspede: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		if (hospede == null) {
			JOptionPane.showMessageDialog(null, "Não foi possível localizar o hóspede selecionado", "",
					JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possível localizar o hóspede selecionado");
		}
		return hospede;
	}

	public void alterarHospedes(String id, Hospede hospede) {
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(ALTERAR_HOSPEDES)) {

			preparedStatement.setString(1, hospede.getNome());
			preparedStatement.setString(2, hospede.getCpf());
			preparedStatement.setString(3, hospede.getCep());
			preparedStatement.setString(4, hospede.getTelefone());
			preparedStatement.setString(5, hospede.getDataNascimento());
			preparedStatement.setString(6, id);

			preparedStatement.executeUpdate();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Hóspede alterado com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar hóspede: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void excluirHospedes(String id) {
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(EXCLUIR_HOSPEDES)) {

			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Hóspede excluído com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir hóspede: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Hospede> listarHospedes() throws Exception {
		ArrayList<Hospede> hospedes = new ArrayList<>();
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(LISTAR_HOSPEDES);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				hospedes.add(new Hospede(resultSet.getString("id"), resultSet.getString("nome"),
						resultSet.getString("telefone"), resultSet.getString("cpf"), resultSet.getString("cep"),
						resultSet.getString("dataNascimento")));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar hóspedes: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		if (hospedes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há hóspedes cadastrados.", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não há hóspedes cadastrados");
		}
		return hospedes;
	}

	public Usuario consultarUsuario(String nome, String senha) throws Exception {
		Usuario usuario = null;
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(CONSULTAR_USUARIO)) {

			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, senha);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					usuario = new Usuario(resultSet.getString("NOME"), resultSet.getString("SENHA"));
				}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar usuário: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado.", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Usuário não cadastrado");
		}
		return usuario;
	}

	public void cadastrarUsuario(Usuario usuario) {
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(CADASTRAR_USUARIO)) {

			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getSenha());

			preparedStatement.execute();
			connection.commit();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "Quarto cadastrado com sucesso! ");

		} catch (SQLException e) {
			e.printStackTrace();

		} 

	}

	public void reservarQuartos(Quarto quarto) {
		String queryVerifica = "SELECT STATUS FROM QUARTOS WHERE NUMERO = ?";
		String queryAtualiza = "UPDATE QUARTOS SET STATUS = 'indisponivel' WHERE NUMERO = ?";
		String queryReservar = RESERVAR_QUARTOS;
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatementVerifica = connection.prepareStatement(queryVerifica);
				PreparedStatement preparedStatementAtualiza = connection.prepareStatement(queryAtualiza);
				PreparedStatement preparedStatementReservar = connection.prepareStatement(queryReservar)) {

			// Verifica o status do quarto
			preparedStatementVerifica.setString(1, quarto.getNumero());
			ResultSet resultSet = preparedStatementVerifica.executeQuery();

			if (resultSet.next()) {
				// Se o quarto estiver disponível, reserve-o (altere o status para
				// 'indisponível')
				String status = resultSet.getString("STATUS");
				if ("disponivel".equals(status)) {
					preparedStatementAtualiza.setString(1, quarto.getNumero());
					preparedStatementAtualiza.executeUpdate();
					connection.commit();
					JOptionPane.showMessageDialog(null, "Quarto reservado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Este quarto não está disponível para reserva.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Quarto não encontrado.");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao reservar quarto: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Quarto> listarQuartos() throws Exception {
		ArrayList<Quarto> quartos = new ArrayList<>();
		try (Connection connection = Conexao.getInstancia().abrirConexao();
				PreparedStatement preparedStatement = connection.prepareStatement(LISTAR_QUARTOS);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				quartos.add(new Quarto(resultSet.getString("id"), resultSet.getString("numero"),
						resultSet.getString("status")));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar quartos: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		if (quartos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há quartos cadastrados.", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não há quartos cadastrados");
		}
		return quartos;
	}
	
}
