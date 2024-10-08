package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Hospede;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//integrar com uma api de validação de cpf e uma api de cep.
public class JCadastrarHospede extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldCpf;
	private JTextField textFieldCep;
	private JTextField textFieldTelefone;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastrarHospede frame = new JCadastrarHospede();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JCadastrarHospede() {
		DAO dao = new DAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Hóspede");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(200, 10, 179, 36);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(20, 117, 46, 14);
		contentPane.add(lblNewLabel_1);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(20, 132, 215, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("DATA NASCIMENTO:");
		lblNewLabel_2.setBounds(20, 172, 126, 14);
		contentPane.add(lblNewLabel_2);

		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setBounds(20, 186, 155, 20);
		contentPane.add(textFieldDataNascimento);
		textFieldDataNascimento.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(20, 227, 46, 14);
		contentPane.add(lblNewLabel_3);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(20, 244, 107, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setBounds(410, 117, 46, 14);
		contentPane.add(lblNewLabel_4);

		textFieldCep = new JTextField();
		textFieldCep.setBounds(410, 132, 126, 20);
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("TELEFONE:");
		lblNewLabel_5.setBounds(410, 172, 70, 14);
		contentPane.add(lblNewLabel_5);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(410, 186, 126, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hospede hospede = new Hospede(null, textFieldNome.getText(), textFieldCep.getText(),
						textFieldCpf.getText(), textFieldTelefone.getText(), textFieldDataNascimento.getText());
				if (!textFieldNome.getText().isEmpty() && !textFieldCpf.getText().isEmpty()) {

					if (hospede != null) {
						dao.cadastrarHospedes(hospede);
						abrirCheckIn();

					} else {
						JOptionPane.showMessageDialog(null, "Campos nome e cpf estão vazios. ", " Aviso!! ",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(435, 319, 117, 36);
		contentPane.add(btnNewButton);
	}

	public void abrirCheckIn() {
		dispose();
		JCheckIn Jcheckin = new JCheckIn();
		Jcheckin.setLocationRelativeTo(Jcheckin);
		Jcheckin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Jcheckin.setVisible(true);

	}
}
