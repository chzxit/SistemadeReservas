package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class JCheckIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckIn frame = new JCheckIn();
					frame.setVisible(true);
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
		btnNewButton.setBounds(10, 79, 157, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quartos");
		btnNewButton_1.setBounds(297, 79, 157, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Resgistrar Check-in");
		btnNewButton_2.setBounds(297, 231, 147, 31);
		contentPane.add(btnNewButton_2);
	}
}
