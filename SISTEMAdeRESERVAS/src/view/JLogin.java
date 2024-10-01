package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Hospede;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin jLogin = new JLogin();
					jLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JLogin() {
		DAO dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(191, 23, 46, 14);
		contentPane.add(lblNewLabel);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(158, 98, 104, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(157, 81, 46, 14);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 151, 104, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(157, 138, 46, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastro();

			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DAO dao = new DAO();
				String nome = textFieldUsuario.getText();
				String senha = passwordField.getText();

				if (!"".equalsIgnoreCase(nome) && !"".equalsIgnoreCase(senha)) {
					try {
						Usuario consultarUsuario = dao.consultarUsuario(nome, senha);
						dao.consultarUsuario(consultarUsuario.getNome(), consultarUsuario.getSenha());
						telaPrincipal();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Confira os campos usúario e senha!! ");

				}
			}
		});
		btnNewButton_1.setBounds(10, 228, 85, 21);
		contentPane.add(btnNewButton_1);
	}

	public void telaPrincipal() {
		dispose();
		JPrincipal jPrincipal = new JPrincipal();
		jPrincipal.setLocationRelativeTo(jPrincipal);
		jPrincipal.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jPrincipal.setVisible(true);
	}

	public void telaCadastro() {
		dispose();
		JCadastrarUsuario jCadastrarUsuario = new JCadastrarUsuario();
		jCadastrarUsuario.setLocationRelativeTo(jCadastrarUsuario);
		jCadastrarUsuario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jCadastrarUsuario.setVisible(true);

	}
}
