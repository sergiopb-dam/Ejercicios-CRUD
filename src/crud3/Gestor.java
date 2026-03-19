package crud3;

import java.util.ArrayList;

public class Gestor {

	ArrayList<Pizza> pedidos = new ArrayList<>();

	public void listarPizzas() {
		if (pedidos.isEmpty()) {
			System.out.println("Aun no hay pedidos en el dia.");
			return;
		}
		for (Pizza p : pedidos) {
			System.out.println(p.toString());
		}
	}

	public void nuevoPedido(String tamano, String tipo) {
		pedidos.add(new Pizza(tamano, tipo));
	}

	public int servirPizza(int codigo) {
		for (Pizza p : pedidos) {
			if (p.getCodigo() == codigo) {
				if (p.getEstado().equals("pedida")) {
					p.setEstado("servida");
					return 1;
				} else {
					return 0;
				}
			}
		}
		return -1;
	}
}