package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCheckIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckIn Jcheckin = new JCheckIn();
					Jcheckin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JCheckIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Check-in");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(185, 11, 110, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar Hóspede");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastrarHospede jCadastro = new JCadastrarHospede();
				jCadastro.setLocationRelativeTo(jCadastro);
				jCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				jCadastro.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(287, 214, 157, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reservar Quarto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JReservas Jreservas = new JReservas();
				Jreservas.setLocationRelativeTo(Jreservas);
				Jreservas.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				Jreservas.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(10, 214, 157, 48);
		contentPane.add(btnNewButton_1);
	}
}
