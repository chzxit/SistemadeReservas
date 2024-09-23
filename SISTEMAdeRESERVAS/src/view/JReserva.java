package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		String[] quartos = { " ", "Quarto 243", "Quarto 244", "Quarto 245", "Quarto 246", "Quarto 247", "Quarto 248",
				"Quarto 249", "Quarto 250", "Quarto 251", "Quarto 252", "Quarto 253", "Quarto 254", "Quarto 255",
				"Quarto 256", "Quarto 257", "Quarto 258", "Quarto 259", "Quarto 260" };
		JComboBox<String> comboBox = new JComboBox(quartos);
		comboBox.setBounds(164, 109, 115, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() != null) {
					JOptionPane.showMessageDialog(btnNewButton, "Quarto reservado com sucesso! ");
				}

			}
		});
		btnNewButton.setBounds(323, 228, 101, 22);
		contentPane.add(btnNewButton);
	}
}
