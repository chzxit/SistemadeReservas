package model;

import javax.swing.JOptionPane;

public class Quarto {
	private String id;
	private String numero;
	private boolean disponivel;

	public Quarto(String numero, boolean disponivel, String id) {
		this.disponivel = disponivel;
		this.numero = numero;
		this.id = id;

	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public void reservar() {
		if (disponivel) {
			this.disponivel = false;
			JOptionPane.showMessageDialog(null, "Quarto foi reservado com sucesso! ");
		}
	}

	@Override
	public String toString() {
		return " Quarto " + numero;
	}

	
}
