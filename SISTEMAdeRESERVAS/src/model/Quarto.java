package model;

import javax.swing.JOptionPane;

public class Quarto {
	private int numero;
	private boolean disponivel;

	public Quarto(int numero, boolean disponivel) {
		this.disponivel = disponivel;
		this.numero = numero;

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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

		}
	}

	@Override
	public String toString() {
		return " Quarto " + numero;
	}

}
