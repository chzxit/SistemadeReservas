package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class JCadastrarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastrarUsuario jCadastrarUsuario = new JCadastrarUsuario();
					jCadastrarUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JCadastrarUsuario() {
		DAO dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(154, 92, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(154, 105, 129, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRO");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(167, 21, 135, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setBounds(154, 143, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textFieldUsuario.getText().isEmpty() && !passwordField.getText().isEmpty()){
					Usuario usuario = new Usuario(textFieldUsuario.getText(),passwordField.getText());
					dao.cadastrarUsuario(usuario);
					telaLogin();
					
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Verifique os campos usuário e senha. " ," Aviso!! ", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(326, 227, 98, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 155, 129, 20);
		contentPane.add(passwordField);
	}
	
	
	public void telaLogin() {
		dispose();
		JLogin jLogin = new JLogin();
		jLogin.setLocationRelativeTo(jLogin);
		jLogin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jLogin.setVisible(true);
	}
}
