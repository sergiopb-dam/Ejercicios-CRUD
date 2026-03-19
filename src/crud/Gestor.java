package crud;

import java.util.ArrayList;

public class Gestor {
	private ArrayList<Alumno> alumnos = new ArrayList<>();

	public void imprimirAlumnos() {
		if (alumnos.isEmpty()) {
			System.out.println("No hay ningún alumno.");
		} else {
			for (Alumno a : alumnos) {
				System.out.println(a);
			}
		}
	}

	public void añadirAlumno(Alumno a) {
		alumnos.add(a);
	}

	public void buscarAlumno(String nombreAlumno) {
		boolean encontrado = false;
		for (Alumno a : alumnos) {
			if (a.getNombre().equalsIgnoreCase(nombreAlumno)) {
				System.out.println("Alumno encontrado: " + a);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("El alumno no se encuentra en la lista.");
		}
	}

	public void modificarNota(String nombreAlumno, double nuevaNota) {
		boolean encontrado = false;
		for (Alumno a : alumnos) {
			if (a.getNombre().equalsIgnoreCase(nombreAlumno)) {
				a.setNota(nuevaNota);
				System.out.println("Nota actualizada correctamente.");
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("No se pudo modificar: el alumno no existe.");
		}
	}

	public void borrarAlumno(String nombreAlumno) {
		boolean eliminado = alumnos.removeIf(a -> a.getNombre().equalsIgnoreCase(nombreAlumno));

		if (eliminado) {
			System.out.println("Alumno " + nombreAlumno + " eliminado con éxito.");
		} else {
			System.out.println("No se encontró ningún alumno con ese nombre.");
		}
	}
}