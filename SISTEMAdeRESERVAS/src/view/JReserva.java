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

public class JReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JReserva frame = new JReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JReserva() {
		DAO dao = new DAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("RESERVAS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(164, 11, 115, 35);
		contentPane.add(lblNewLabel);
		// Array para criar os quartos:
		Quarto[] quartos = { new Quarto("243", true, null), new Quarto("244", true, null),
				new Quarto("245", true, null), new Quarto("246", true, null), new Quarto("247", true, null),
				new Quarto("248", true, null), new Quarto("249", true, null), new Quarto("250", true, null),
				new Quarto("251", true, null), new Quarto("252", true, null), new Quarto("253", true, null),
				new Quarto("254", true, null), new Quarto("255", true, null), new Quarto("256", true, null),
				new Quarto("257", true, null), new Quarto("258", true, null) };

		JComboBox<Quarto> comboBox = new JComboBox<>(quartos);
		comboBox.setBounds(151, 115, 115, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// vericação do botão de reservar:
				Quarto quartoSelecionado = (Quarto) comboBox.getSelectedItem();

				if (quartoSelecionado != null) {
					if (quartoSelecionado.isDisponivel()) {
						dao.cadastrarQuartos(quartoSelecionado);
						abrirCheckIn();

					} else if (!quartoSelecionado.isDisponivel()) {
						JOptionPane.showMessageDialog(btnNewButton, "Quarto indisponível, escolha outro. ");

					}
				}

			}

		});
		btnNewButton.setBounds(323, 221, 101, 29);
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
