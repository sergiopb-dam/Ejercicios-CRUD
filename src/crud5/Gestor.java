package crud5;

import java.util.ArrayList;

public class Gestor {

	ArrayList<CuentaCorriente> cuentas = new ArrayList<>();

	public void listar() {
		if (cuentas.isEmpty()) {
			System.out.println("No hay cuentas registradas en el sistema.");
			return;
		}
		for (CuentaCorriente c : cuentas) {
			System.out.println(c.toString());
		}
	}

	public boolean alta(CuentaCorriente nueva) {
		for (CuentaCorriente c : cuentas) {
			if (c.getDni().equalsIgnoreCase(nueva.getDni())) {
				return false;
			}
		}
		cuentas.add(nueva);
		return true;
	}

	public boolean baja(String dni) {
		CuentaCorriente cuentaBuscada = new CuentaCorriente(dni);

		for (int i = 0; i < cuentas.size(); i++) {
			if (cuentas.get(i).getDni().equalsIgnoreCase(cuentaBuscada.getDni())) {
				cuentas.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean ingresar(String dni, double cantidad) {
		for (CuentaCorriente c : cuentas) {
			if (c.getDni().equalsIgnoreCase(dni)) {
				return c.ingresarDinero(cantidad);
			}
		}
		return false;
	}

	public boolean sacar(String dni, double cantidad) {
		for (CuentaCorriente c : cuentas) {
			if (c.getDni().equalsIgnoreCase(dni)) {
				return c.sacarDinero(cantidad);
			}
		}
		return false;
	}
}