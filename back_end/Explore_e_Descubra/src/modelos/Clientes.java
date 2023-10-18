package modelos;

public class Clientes {

	private int id;
	private String Nome_cliente;
	private String Cpf_cliente;
	private String Email_cliente;
	private String Senha_cliente;

	public Clientes() {
	}

	public Clientes(int id, String nome_cliente, String cpf_cliente, String email_cliente, String senha_cliente) {
		this.id = id;
		Nome_cliente = nome_cliente;
		Cpf_cliente = cpf_cliente;
		Email_cliente = email_cliente;
		Senha_cliente = senha_cliente;
	}

	public Clientes(String nome_cliente, String cpf_cliente, String email_cliente, String senha_cliente) {
		Nome_cliente = nome_cliente;
		Cpf_cliente = cpf_cliente;
		Email_cliente = email_cliente;
		Senha_cliente = senha_cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return Nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		Nome_cliente = nome_cliente;
	}

	public String getCpf_cliente() {
		return Cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		Cpf_cliente = cpf_cliente;
	}

	public String getEmail_cliente() {
		return Email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		Email_cliente = email_cliente;
	}

	public String getSenha_cliente() {
		return Senha_cliente;
	}

	public void setSenha_cliente(String senha_cliente) {
		Senha_cliente = senha_cliente;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", Nome_cliente=" + Nome_cliente + ", Cpf_cliente=" + Cpf_cliente
				+ ", Email_cliente=" + Email_cliente + ", Senha_cliente=" + Senha_cliente + "]";
	}



}
