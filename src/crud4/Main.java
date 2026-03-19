package crud4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gestor gestor = new Gestor();
		int opcion = 0;

		do {
			System.out.println("\nCOLECCION DE DISCOS");
			System.out.println("===================");
			System.out.println("1. Listado.");
			System.out.println("2. Nuevo Disco.");
			System.out.println("3. Borrar.");
			System.out.println("4. Salir.");
			System.out.print("Elige una opcion: ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("\n--- LISTADO ---");
				gestor.listar();
				break;
			case 2:
				System.out.println("\n--- NUEVO DISCO ---");
				System.out.print("Codigo: ");
				String codigo = sc.nextLine();
				System.out.print("Autor: ");
				String autor = sc.nextLine();
				System.out.print("Titulo: ");
				String titulo = sc.nextLine();
				System.out.print("Duracion (minutos): ");
				int duracion = sc.nextInt();
				sc.nextLine();

				String genero = "";
				boolean generoValido = false;
				while (!generoValido) {
					System.out.print("Genero (Rock, Pop, Jazz, Blues): ");
					genero = sc.nextLine();
					if (genero.equalsIgnoreCase("Rock") || genero.equalsIgnoreCase("Pop")
							|| genero.equalsIgnoreCase("Jazz") || genero.equalsIgnoreCase("Blues")) {
						generoValido = true;
					} else {
						System.out.println("Error: Genero no valido. Prueba otra vez.");
					}
				}

				Disco nuevo = new Disco(codigo, autor, titulo, duracion, genero);
				if (gestor.nuevoDisco(nuevo)) {
					System.out.println("Disco anadido correctamente a la coleccion.");
				} else {
					System.out.println("Error: Ya existe un disco con ese codigo.");
				}
				break;
			case 3:
				System.out.println("\n--- BORRAR DISCO ---");
				System.out.print("Introduce el codigo del disco a borrar: ");
				String codBorrar = sc.nextLine();

				if (gestor.borrar(codBorrar)) {
					System.out.println("Disco borrado correctamente.");
				} else {
					System.out.println("Error: No se ha encontrado ningun disco con ese codigo.");
				}
				break;
			case 4:
				System.out.println("Saliendo del gestor de discos...");
				break;
			default:
				System.out.println("Opcion no valida.");
			}
		} while (opcion != 4);

		sc.close();
	}
}