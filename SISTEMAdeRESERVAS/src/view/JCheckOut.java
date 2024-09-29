package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class JCheckOut extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckOut frame = new JCheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JCheckOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check-out");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(143, 11, 112, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrar Check-out");
		btnNewButton.setBounds(197, 211, 162, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Despesas");
		btnNewButton_1.setBounds(10, 211, 112, 39);
		contentPane.add(btnNewButton_1);
	}

}
