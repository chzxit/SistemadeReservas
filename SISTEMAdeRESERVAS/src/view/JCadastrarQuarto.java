package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Quarto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class JCadastrarQuarto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastrarQuarto frame = new JCadastrarQuarto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JCadastrarQuarto() {
		DAO dao = new DAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("RESERVAS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(219, 11, 115, 35);
		contentPane.add(lblNewLabel);
		// Array para criar os quartos:
		Quarto[] quartos = { new Quarto("243", "Disponivel", null), new Quarto("244","Disponivel", null),
				new Quarto("245", "Disponivel", null), new Quarto("246", "Disponivel", null), new Quarto("247", "Disponivel", null),
				new Quarto("248", "Disponivel", null), new Quarto("249", "Disponivel", null), new Quarto("250", "Disponivel", null),
				new Quarto("251", "Disponivel", null), new Quarto("252", "Disponivel", null), new Quarto("253", "Disponivel", null),
				new Quarto("254", "Disponivel", null), new Quarto("255", "Disponivel", null), new Quarto("256", "Disponivel", null),
				new Quarto("257", "Disponivel", null), new Quarto("258", "Disponivel", null) };

			JComboBox <Quarto> comboBox = new JComboBox(quartos);
			comboBox.setBounds(195, 106, 182, 29);
			contentPane.add(comboBox);
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// vericação do botão de reservar:
				Quarto quartoSelecionado = (Quarto) comboBox.getSelectedItem();

				if (quartoSelecionado != null) {

					dao.cadastrarQuartos(quartoSelecionado);
					

				}else {
					JOptionPane.showMessageDialog(btnNewButton, "","Selecione o quarto desejado ",JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		btnNewButton.setBounds(436, 221, 101, 29);
		contentPane.add(btnNewButton);
		
	}

}
