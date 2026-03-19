package crud;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gestor gestor = new Gestor();
		int opcion = 0;

		String nombre;
		double nota;

		do {
			imprimirMenu();
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nError: Introduce un número para la opción.");
				opcion = 0;
				continue;
			}

			switch (opcion) {
			case 1:
				gestor.imprimirAlumnos();
				break;

			case 2:
				try {
					System.out.println("Introduce el nombre del alumno: ");
					nombre = sc.nextLine();
					System.out.println("Introduce la nota del alumno: ");
					nota = Double.parseDouble(sc.nextLine());

					gestor.añadirAlumno(new Alumno(nombre, nota));
					System.out.println("Alumno añadido.");
				} catch (NumberFormatException e) {
					System.out.println("\nError: La nota debe ser un número (ej: 7.5).");
				}
				break;

			case 3:
				try {
					System.out.println("Introduce el nombre del alumno a modificar: ");
					nombre = sc.nextLine();
					System.out.println("Introduce su nueva nota: ");
					nota = Double.parseDouble(sc.nextLine());

					gestor.modificarNota(nombre, nota);
				} catch (NumberFormatException e) {
					System.out.println("\nError: La nota debe ser un número.");
				}
				break;

			case 4:
				System.out.println("Introduce el nombre del alumno a borrar: ");
				nombre = sc.nextLine();
				gestor.borrarAlumno(nombre);
				break;

			case 5:
				System.out.println("\nSaliendo...");
				break;

			default:
				System.out.println("\nOpción Errónea.");
				break;
			}
		} while (opcion != 5);
		sc.close();
	}

	public static void imprimirMenu() {
		System.out.println("\nALUMNOS/AS");
		System.out.println("===================");
		System.out.println("1. Listado");
		System.out.println("2. Nuevo Alumno");
		System.out.println("3. Modificar");
		System.out.println("4. Borrar");
		System.out.println("5. Salir");
		System.out.print("\nIntroduce la opción: ");
	}
}