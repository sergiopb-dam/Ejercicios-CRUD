package crud5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gestor gestor = new Gestor();
		int opcion = 0;

		do {
			System.out.println("\n--- GESTION DE CUENTAS CORRIENTES ---");
			System.out.println("1. Listado de cuentas");
			System.out.println("2. Alta de cuenta");
			System.out.println("3. Baja de cuenta");
			System.out.println("4. Ingresar dinero");
			System.out.println("5. Sacar dinero");
			System.out.println("6. Salir");
			System.out.print("Elige una opcion: ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				System.out.println("\n--- LISTADO ---");
				gestor.listar();
				break;
			case 2:
				System.out.println("\n--- ALTA DE CUENTA ---");
				System.out.print("DNI: ");
				String dni = sc.nextLine();
				System.out.print("Nombre del titular: ");
				String nombre = sc.nextLine();
				System.out.print("Saldo inicial: ");
				double saldo = sc.nextDouble();
				sc.nextLine();

				String nacionalidad = "";
				boolean nacValida = false;
				while (!nacValida) {
					System.out.print("Nacionalidad (Española/Extranjera): ");
					nacionalidad = sc.nextLine();
					if (nacionalidad.equalsIgnoreCase("Española") || nacionalidad.equalsIgnoreCase("Extranjera")) {
						nacValida = true;
					} else {
						System.out.println("Error: Nacionalidad no valida.");
					}
				}

				CuentaCorriente nueva = new CuentaCorriente(dni, nombre, saldo, nacionalidad);
				if (gestor.alta(nueva)) {
					System.out.println("Cuenta creada correctamente.");
				} else {
					System.out.println("Error: Ya existe una cuenta con ese DNI.");
				}
				break;
			case 3:
				System.out.println("\n--- BAJA DE CUENTA ---");
				System.out.print("Introduce el DNI de la cuenta a borrar: ");
				String dniBaja = sc.nextLine();

				if (gestor.baja(dniBaja)) {
					System.out.println("Cuenta eliminada correctamente.");
				} else {
					System.out.println("Error: No se encontro ninguna cuenta con ese DNI.");
				}
				break;
			case 4:
				System.out.println("\n--- INGRESAR DINERO ---");
				System.out.print("Introduce el DNI de la cuenta: ");
				String dniIngreso = sc.nextLine();
				System.out.print("Cantidad a ingresar: ");
				double cantIngreso = sc.nextDouble();

				if (gestor.ingresar(dniIngreso, cantIngreso)) {
					System.out.println("Ingreso realizado correctamente.");
				} else {
					System.out.println("Error al ingresar (DNI no encontrado o cantidad no valida).");
				}
				break;
			case 5:
				System.out.println("\n--- SACAR DINERO ---");
				System.out.print("Introduce el DNI de la cuenta: ");
				String dniSacar = sc.nextLine();
				System.out.print("Cantidad a sacar: ");
				double cantSacar = sc.nextDouble();

				if (gestor.sacar(dniSacar, cantSacar)) {
					System.out.println("Retirada realizada correctamente.");
				} else {
					System.out.println(
							"Error al sacar dinero (DNI no encontrado, cantidad negativa o saldo insuficiente).");
				}
				break;
			case 6:
				System.out.println("Cerrando la aplicacion del banco...");
				break;
			default:
				System.out.println("Opcion no valida.");
			}
		} while (opcion != 6);

		sc.close();
	}
}