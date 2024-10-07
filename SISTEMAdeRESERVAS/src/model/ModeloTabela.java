package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

	private static final String[] colunas = { "ID", "Nome", "Telefone", "CPF", "CEP", "DataNascimento"};
	private ArrayList<Hospede> hospedes;

	public ModeloTabela(ArrayList<Hospede> hospedes) {
		super();
		this.hospedes = hospedes;
	}

	@Override
	public int getRowCount() {
		return hospedes.size();
	}

	@Override
	public int getColumnCount() {

		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columIndex) {
		Hospede hospede = hospedes.get(rowIndex);

		if (columIndex == 0) {
			return hospede.getId();
		} else if (columIndex == 1) {
			return hospede.getNome();
		} else if (columIndex == 2) {
			return hospede.getTelefone();
		} else if (columIndex == 3) {
			return hospede.getCpf();
		} else if (columIndex == 4) {
			return hospede.getCep();
		} else if (columIndex == 5) {
			return hospede.getDataNascimento();
		} else {
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

}