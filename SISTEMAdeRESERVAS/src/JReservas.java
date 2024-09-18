import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class JReservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JReservas frame = new JReservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JReservas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		String [] quartos = {"Quarto 234","Quarto 454","Quarto 432","Quarto 237","Quarto 975","Quarto 886","Quarto 656","Quarto 535","Quarto 322","Quarto 121"};	
		JComboBox <String>comboBox = new JComboBox(quartos);
		comboBox.setBounds(137, 102, 135, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBounds(336, 219, 95, 35);
		contentPane.add(btnNewButton);
	}

}
