package crud3;

public class Pizza {

	private static int contador = 1;
	private int codigo;
	private String tamano;
	private String tipo;
	private String estado;

	public Pizza(String tamano, String tipo) {
		this.codigo = contador++;
		this.tamano = tamano;
		this.tipo = tipo;
		this.estado = "pedida";
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pizza " + codigo + " | Tamano: " + tamano + " | Tipo: " + tipo + " | Estado: " + estado;
	}
}