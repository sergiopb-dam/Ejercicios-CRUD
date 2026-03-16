package crud;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gestor gestor = new Gestor();
		int opcion = 0;
		do {
			imprimirMenu();
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("\nOpción Errónea.");
			}
			switch (opcion) {

			case 1:
				gestor.imprimirAlumnos();
				break;

			case 2:
				try {
					System.out.println("\nIntroduce el nombre del alumno: ");
					String nombreAlumno = sc.nextLine();

					System.out.println("\nIntroduce la nota del alumno: ");
					double notaAlumno = Integer.parseInt(nombreAlumno);

					Alumno alumnado = new Alumno(nombreAlumno, notaAlumno);
					gestor.añadirAlumno(alumnado);
				} catch (NumberFormatException e) {
					System.out.println("\nValores Erróneos introducidos.");
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("\nIntroduce el nombre del alumno: ");
				String nombreAlumno = sc.nextLine();
				
				System.out.println("\nIntroduce su nueva nota: ");
				double notaAlumno = Integer.parseInt(nombreAlumno);
				
				gestor.modificarNota(nombreAlumno, notaAlumno);
				break;

			case 4:
				System.out.println("\nIntroduce el nombre del alumno a borrar: ");
				String alumnoBorrar = sc.nextLine();
				
				
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
		System.out.println("\n1. Listado");
		System.out.println("2. Nuevo Alumno");
		System.out.println("3. Modificar");
		System.out.println("4. Borrar");
		System.out.println("5. Salir");
		System.out.println("\nIntroduce la opción que desees ejecutar: ");
	}

}
