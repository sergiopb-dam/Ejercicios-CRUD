package crud2;

public class Articulo {
	String nombre = "Sin nombre";
	int stock;
	double precio;
	int iva = 21;

	public Articulo(String nombre, int stock, double precio, int iva) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.iva = iva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (!nombre.isBlank()) {
			this.nombre = nombre;
		}
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

}