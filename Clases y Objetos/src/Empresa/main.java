package Empresa;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int numero, planta, periodo, opcion;
		double metros, alquilarGaraje;
		double plazaprecio;
		boolean encontrado = false;
		double beneficiosTotales = 0;

		Empresa alquiler[] = new Empresa[5];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {

			System.out.println("Numero de plaza:");
			numero = sc.nextInt();

			System.out.println("Planta:");
			planta = sc.nextInt();

			System.out.println("Metros cuadrados del garaje:");
			metros = sc.nextDouble();

			alquiler[i] = new Empresa(numero, planta, metros);
		}

		do {
			System.out.println("\n--- Menú ---");
			System.out.println("1. Alquilar un garaje");
			System.out.println("2. Mostrar precio de alquiler de un garaje");
			System.out.println("3. Mostrar garajes libres");
			System.out.println("4. Subir precio de un garaje");
			System.out.println("5. Mostrar beneficios de la empresa");
			System.out.println("0. Salir");
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.print("Introduce el número del garaje: ");
				numero = sc.nextInt();

				encontrado = false;

				for (int i = 0; i < alquiler.length; i++) {

					if (alquiler[i] != null && alquiler[i].getNum() == numero) {

						encontrado = true;

						double precio = alquiler[i].alquiler();
						beneficiosTotales += precio;

						if (precio == 0) {
							System.out.println("El garaje ya está alquilado.");
						} else {
							System.out.println("Garaje alquilado correctamente.");
							System.out.println("Precio anual: " + precio + " €");
						}
						break;
					}
				}

				if (!encontrado) {
					System.out.println("No existe ningún garaje con ese número.");
				}
				break;

			case 2:
				System.out.print("Introduce el número del garaje: ");
				numero = sc.nextInt();
				encontrado = false;
				for (int i = 0; i < alquiler.length; i++) {
					if (alquiler[i] != null && alquiler[i].getNum() == numero) {
						System.out.println("Precio del garaje: " + alquiler[i].getFinalprecio() + " €");
						encontrado = true;
						break;
					}
				}

				if (!encontrado)
					System.out.println("Garaje no encontrado.");
				break;
			case 3:
				System.out.println("GARAJES DISPONIBLES:");

				boolean hayLibres = false;

				for (int i = 0; i < alquiler.length; i++) {
					if (alquiler[i] != null && !alquiler[i].isAlquilado()) {
						System.out.println(alquiler[i]);
						hayLibres = true;
					}
				}

				if (!hayLibres)
					System.out.println("No hay garajes libres.");

				break;
			case 4:
				System.out.print("Número del garaje: ");
				numero = sc.nextInt();

				System.out.print("Porcentaje de subida: ");
				double porcentaje = sc.nextDouble();

				encontrado = false;

				for (int i = 0; i < alquiler.length; i++) {
					if (alquiler[i] != null && alquiler[i].getNum() == numero) {

						encontrado = true;

						if (alquiler[i].subirPrecio(porcentaje))
							System.out.println("Precio actualizado.");
						else
							System.out.println("No se puede subir: garaje alquilado.");

						break;
					}
				}

				if (!encontrado)
					System.out.println("Garaje no encontrado.");

				break;
			case 5:
				System.out.println("Beneficios totales: " + beneficiosTotales + " €");
				break;

			}
		} while (opcion != 0);
	}
}
