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
 
public class JPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal jPrincipal = new JPrincipal();
					jPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("HOTEL");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(225, 11, 72, 51);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Reservas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JReserva jReserva = new JReserva();
				jReserva.setLocationRelativeTo(jReserva);
				jReserva.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				jReserva.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 159, 133, 41);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Check in");
		btnNewButton_1.setBounds(10, 234, 133, 41);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Check out");
		btnNewButton_2.setBounds(360, 234, 133, 41);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Hospedes");
		btnNewButton_3.setBounds(360, 159, 133, 41);
		contentPane.add(btnNewButton_3);
	}

	
}
