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
			JOptionPane.showMessageDialog(null, "Quarto foi reservado com sucesso! ");
		}
	}

	@Override
	public String toString() {
		return " Quarto " + numero;
	}

	public void contaQuarto() {
		int valorDiaria = 200;
		int quantidadeDias = 3;
		double conta = valorDiaria * quantidadeDias;

		double pix = conta * 0;
		double dinheiro = conta * 0;
		

	}

}
