package crud5;

import java.util.Objects;

public class CuentaCorriente {

	private String dni;
	private String nombre;
	private double saldo;
	private String nacionalidad;

	public CuentaCorriente(String dni) {
		this.dni = dni;
		this.nombre = "";
		this.saldo = 0.0;
		this.nacionalidad = "Española";
	}

	public CuentaCorriente(String dni, double saldo) {
		this.dni = dni;
		this.nombre = "";
		this.saldo = saldo;
		this.nacionalidad = "Española";
	}

	public CuentaCorriente(String dni, String nombre, double saldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.saldo = saldo;
		this.nacionalidad = "Española";
	}

	public CuentaCorriente(String dni, String nombre, double saldo, String nacionalidad) {
		this.dni = dni;
		this.nombre = nombre;
		this.saldo = saldo;
		this.nacionalidad = nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public boolean sacarDinero(double cantidad) {
		if (cantidad > 0 && this.saldo >= cantidad) {
			this.saldo -= cantidad;
			return true;
		}
		return false;
	}

	public boolean ingresarDinero(double cantidad) {
		if (cantidad > 0) {
			this.saldo += cantidad;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [DNI: " + dni + " | Titular: " + nombre + " | Saldo: " + saldo + "€ | Nacionalidad: "
				+ nacionalidad + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CuentaCorriente cuenta = (CuentaCorriente) obj;
		return Objects.equals(dni, cuenta.dni) && Objects.equals(nombre, cuenta.nombre);
	}
}