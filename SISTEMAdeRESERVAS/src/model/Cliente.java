package model;

public class Cliente {
	private String nome;
	private String telefone;
	private String cpf;
	private String cep;

	public Cliente(String nome, String telefone, String cpf, String cep) {
		super();
		this.cep = cep;
		this.cpf = cpf;
		this.nome = nome; 
		this.telefone = telefone;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
