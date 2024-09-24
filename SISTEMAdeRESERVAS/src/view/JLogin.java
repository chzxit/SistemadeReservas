package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
					JLogin frame = new JLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JLogin() {
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
				if(!textFieldUsuario.getText().isEmpty() && !passwordField.getText().isEmpty()){
					telaPrincipal();
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Verifique os campos usuário e senha. " ," Aviso!! ", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void telaPrincipal() {
		dispose();
		JPrincipal jPrincipal = new JPrincipal();
		jPrincipal.setLocationRelativeTo(jPrincipal);
		jPrincipal.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jPrincipal.setVisible(true);
	}
}
