package crud4;

import java.util.ArrayList;

public class Gestor {

	ArrayList<Disco> coleccion = new ArrayList<>();

	public void listar() {
		if (coleccion.isEmpty()) {
			System.out.println("La coleccion de discos esta vacia.");
			return;
		}
		for (Disco d : coleccion) {
			System.out.println(d.toString());
		}
	}

	public boolean nuevoDisco(Disco nuevo) {
		for (Disco d : coleccion) {
			if (d.equals(nuevo)) {
				return false;
			}
		}
		coleccion.add(nuevo);
		return true;
	}

	public boolean borrar(String codigo) {
		for (int i = 0; i < coleccion.size(); i++) {
			if (coleccion.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				coleccion.remove(i);
				return true;
			}
		}
		return false;
	}
}