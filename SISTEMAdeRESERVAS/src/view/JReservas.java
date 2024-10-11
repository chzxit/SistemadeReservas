package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import dao.DAO;
import model.Hospede;
import model.ModeloTabelaHospedes;
import model.ModeloTabelaQuartos;
import model.Quarto;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JReservas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Quarto> quartos;
	private TableRowSorter<ModeloTabelaQuartos> rowSorter;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JReservas Jreservas = new JReservas();
					Jreservas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JReservas() {
		DAO dao = new DAO();
		try {
			quartos = dao.listarQuartos();
		} catch (Exception e) {

			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUARTOS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(273, 11, 108, 14);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 53, 574, 230);
		contentPane.add(scrollPane);

		ModeloTabelaQuartos modeloTabela = new ModeloTabelaQuartos(quartos);

		table = new JTable();
		table.setModel(modeloTabela);
		rowSorter = new TableRowSorter<>(modeloTabela);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Quarto quarto = new Quarto(getTitle(), getTitle(), getTitle());
				if (e.getButton() == 1) {
					try {
						
						dao.reservarQuartos(quarto);

					} catch (Exception e1) {
						e1.printStackTrace();

					}

				}
			}

		});
		btnNewButton.setBounds(586, 319, 100, 34);
		contentPane.add(btnNewButton);

	}
}
