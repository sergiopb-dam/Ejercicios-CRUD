package crud2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gestor gestor = new Gestor();
		int opcion = 0;

		do {
			System.out.println("\n--- GESTISIMAL ---");
			System.out.println("1. Listado");
			System.out.println("2. Alta");
			System.out.println("3. Baja");
			System.out.println("4. Modificacion");
			System.out.println("5. Entrada de mercancia");
			System.out.println("6. Salida de mercancia");
			System.out.println("7. Salir");
			System.out.print("Elige una opcion: ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				gestor.listar();
				break;
			case 2:
				System.out.print("Nombre del articulo: ");
				String nombreAlta = sc.nextLine();
				System.out.print("Stock inicial: ");
				int stock = sc.nextInt();
				System.out.print("Precio: ");
				double precio = sc.nextDouble();
				System.out.print("IVA: ");
				int iva = sc.nextInt();

				if (gestor.alta(nombreAlta, stock, precio, iva)) {
					System.out.println("Articulo guardado correctamente.");
				} else {
					System.out.println("Error: Ya existe un articulo con ese nombre.");
				}
				break;
			case 3:
				System.out.print("Nombre del articulo a dar de baja: ");
				String nombreBaja = sc.nextLine();

				if (gestor.baja(nombreBaja)) {
					System.out.println("Articulo eliminado correctamente.");
				} else {
					System.out.println("Error: No se ha encontrado el articulo.");
				}
				break;
			case 4:
				System.out.print("Nombre del articulo que quieres modificar: ");
				String nombreMod = sc.nextLine();
				System.out.print("Nuevo nombre: ");
				String nuevoNom = sc.nextLine();
				System.out.print("Nuevo precio: ");
				double nuevoPre = sc.nextDouble();
				System.out.print("Nuevo IVA: ");
				int nuevoIva = sc.nextInt();

				if (gestor.modificar(nombreMod, nuevoNom, nuevoPre, nuevoIva)) {
					System.out.println("Articulo modificado correctamente.");
				} else {
					System.out.println("Error: No se ha encontrado el articulo.");
				}
				break;
			case 5:
				System.out.print("Nombre del articulo: ");
				String nombreEnt = sc.nextLine();
				System.out.print("Cantidad que entra: ");
				int cantEnt = sc.nextInt();

				if (gestor.entrada(nombreEnt, cantEnt)) {
					System.out.println("Stock actualizado correctamente.");
				} else {
					System.out.println("Error al actualizar el stock (comprueba nombre y cantidad).");
				}
				break;
			case 6:
				System.out.print("Nombre del articulo: ");
				String nombreSal = sc.nextLine();
				System.out.print("Cantidad que sale: ");
				int cantSal = sc.nextInt();

				if (gestor.salida(nombreSal, cantSal)) {
					System.out.println("Stock actualizado correctamente.");
				} else {
					System.out.println("Error: No hay stock suficiente o el articulo no existe.");
				}
				break;
			case 7:
				System.out.println("Cerrando GESTISIMAL...");
				break;
			default:
				System.out.println("Opcion no valida.");
			}
		} while (opcion != 7);

		sc.close();
	}
}