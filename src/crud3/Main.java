package crud3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gestor gestor = new Gestor();
		int opcion = 0;

		do {
			System.out.println("\n--- GESTION DE PIZZERIA ---");
			System.out.println("1. Listado de pizzas");
			System.out.println("2. Nuevo pedido");
			System.out.println("3. Pizza servida");
			System.out.println("4. Salir");
			System.out.print("Elige una opcion: ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				gestor.listarPizzas();
				break;
			case 2:
				System.out.print("Tamano de la pizza (mediana/familiar): ");
				String tamano = sc.nextLine();
				System.out.print("Tipo (margarita/cuatro quesos/funghi...): ");
				String tipo = sc.nextLine();

				gestor.nuevoPedido(tamano, tipo);
				System.out.println("Pedido registrado con exito.");
				break;
			case 3:
				System.out.print("Introduce el codigo de la pizza que se ha servido: ");
				int codigoServir = sc.nextInt();

				int resultado = gestor.servirPizza(codigoServir);

				if (resultado == 1) {
					System.out.println("La pizza " + codigoServir + " ha sido marcada como servida.");
				} else if (resultado == 0) {
					System.out.println("Esa pizza ya estaba servida.");
				} else {
					System.out.println("No se ha encontrado ninguna pizza con ese codigo.");
				}
				break;
			case 4:
				System.out.println("Cerrando el registro de pizzas...");
				break;
			default:
				System.out.println("Opcion no valida.");
			}
		} while (opcion != 4);

		sc.close();
	}
}