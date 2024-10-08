package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaQuartos extends AbstractTableModel {

	private static final String[] colunas = { "ID", "NUMERO","STATUS"};
	private ArrayList<Quarto> quartos;

	public ModeloTabelaQuartos(ArrayList<Quarto> quartos) {
		super();
		this.quartos = quartos;
	}

	@Override
	public int getRowCount() {
		return quartos.size();
	}

	@Override
	public int getColumnCount() {

		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columIndex) {
		Quarto quarto =  quartos.get(rowIndex);

		if (columIndex == 0) {
			return quarto.getId();
		} else if (columIndex == 1) {
			return quarto.getNumero();
		} else if (columIndex == 2) {
			return quarto.getStatus();
		}else {
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

}