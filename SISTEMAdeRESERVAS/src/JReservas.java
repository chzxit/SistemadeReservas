import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Choice;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

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
		setBounds(100, 100, 614, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.setBounds(503, 256, 95, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		contentPane.add(btnNewButton);
		
		String[] quartos = { "Quarto Deluxe com Vista para o Mar", "Suíte Presidencial", "Quarto Econômico",
				"Quarto Familiar", "Quarto Standard", "Quarto Luxo com Terraço Privado", "Suíte Júnior",
				"Cabana na Praia", "Quarto Temático para Crianças", "Quarto Romântico com Hidromassagem",
				"Quarto Executivo", "Quarto Loft", "Quarto com Piscina Privativa", "Suíte de Spa",
				"Quarto com Vista para a Montanha", "Quarto Triplo Standard", "Suíte Nupcial",
				"Quarto com Cozinha Compacta", "Quarto de Luxo com Banho Turco", "Quarto com Varanda e Rede",
				"Quarto com Lareira", "Suíte com Sauna Privativa", "Quarto com Vista para o Lago" };
		JList <String> list = new JList<>(quartos);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(66, 34, 511, 194);
		contentPane.add(scrollPane);
		
		
        
       
		
		
		
		
		
		
		

	}
}
