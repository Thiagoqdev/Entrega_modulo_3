package modelos;

public class Pacotes {

	private int id_pacotes;
	private String Periodo_pacotes;
	private String Destino_pacotes;
	private float Preco_pacotes;

	public Pacotes() {

	}

	public Pacotes(int id_pacotes, String periodo_pacotes, String destino_pacotes, float preco_pacotes) {
		this.id_pacotes = id_pacotes;
		Periodo_pacotes = periodo_pacotes;
		Destino_pacotes = destino_pacotes;
		Preco_pacotes = preco_pacotes;
	}

	public Pacotes(String periodo_pacotes, String destino_pacotes, float preco_pacotes) {
		Periodo_pacotes = periodo_pacotes;
		Destino_pacotes = destino_pacotes;
		Preco_pacotes = preco_pacotes;
	}

	public int getId_pacotes() {
		return id_pacotes;
	}

	public void setId_pacotes(int id_pacotes) {
		this.id_pacotes = id_pacotes;
	}

	public String getPeriodo_pacotes() {
		return Periodo_pacotes;
	}

	public void setPeriodo_pacotes(String periodo_pacotes) {
		Periodo_pacotes = periodo_pacotes;
	}

	public String getDestino_pacotes() {
		return Destino_pacotes;
	}

	public void setDestino_pacotes(String destino_pacotes) {
		Destino_pacotes = destino_pacotes;
	}

	public float getPreco_pacotes() {
		return Preco_pacotes;
	}

	public void setPreco_pacotes(float preco_pacotes) {
		Preco_pacotes = preco_pacotes;
	}

	@Override
	public String toString() {
		return "Pacotes [id_pacotes=" + id_pacotes + ", Periodo_pacotes=" + Periodo_pacotes + ", Destino_pacotes="
				+ Destino_pacotes + ", Preco_pacotes=" + Preco_pacotes + "]";
	}

}
