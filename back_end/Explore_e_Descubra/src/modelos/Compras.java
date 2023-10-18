package modelos;

public class Compras {

	int id;
	String Data_compras;
	Clientes cliente;
	Pacotes pacoteDeViagem;

	public Compras() {
	}

	public Compras(int id, String data_compras, Clientes cliente, Pacotes pacoteDeViagem) {
		this.id = id;
		Data_compras = data_compras;
		this.cliente = cliente;
		this.pacoteDeViagem = pacoteDeViagem;
	}

	public Compras(String data_compras, Clientes cliente, Pacotes pacoteDeViagem) {
		Data_compras = data_compras;
		this.cliente = cliente;
		this.pacoteDeViagem = pacoteDeViagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData_compras() {
		return Data_compras;
	}

	public void setData_compras(String data_compras) {
		Data_compras = data_compras;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Pacotes getPacoteDeViagem() {
		return pacoteDeViagem;
	}

	public void setPacoteDeViagem(Pacotes pacoteDeViagem) {
		this.pacoteDeViagem = pacoteDeViagem;
	}

	@Override
	public String toString() {
		return "Compras [id=" + id + ", Data_compras=" + Data_compras + ", cliente=" + cliente + ", pacoteDeViagem="
				+ pacoteDeViagem + "]";
	}

}
	