package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		Quarto[] quartos = { new Quarto(243, true), new Quarto(244, true), new Quarto(245, true), new Quarto(246, true),
				new Quarto(247, true), new Quarto(248, true), new Quarto(249, true), new Quarto(250, true),
				new Quarto(251, true), new Quarto(252, true), new Quarto(253, true), new Quarto(254, true),
				new Quarto(255, true), new Quarto(256, true), new Quarto(257, true), new Quarto(258, true) };

		JComboBox<Quarto> comboBox = new JComboBox<>(quartos);
		comboBox.setBounds(164, 109, 115, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// vericação do botão de reservar:
				Quarto quartoSelecionado = (Quarto) comboBox.getSelectedItem();

				if (quartoSelecionado != null) {
					if (quartoSelecionado.isDisponivel()) {
						quartoSelecionado.reservar();
						
					}else if(!quartoSelecionado.isDisponivel()) {
						JOptionPane.showMessageDialog(btnNewButton, "Quarto indisponível, escolha outro. ");
						
					}
				}

			}

		});
		btnNewButton.setBounds(323, 221, 101, 29);
		contentPane.add(btnNewButton);
	}
}
