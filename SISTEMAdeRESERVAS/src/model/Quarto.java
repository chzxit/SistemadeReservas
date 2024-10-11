package model;



public class Quarto {
	private String id;
	private String numero;
	private String status;

	public Quarto(String numero, String status, String id) {
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Quarto " + numero;
	}

}
