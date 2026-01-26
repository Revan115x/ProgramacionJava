package Empresa;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		int numero, planta, periodo, opcion;
		double metros, alquilarGaraje;
		double plazaprecio;
		boolean encontrado = false;

		Empresa alquiler[] = new Empresa[5];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {

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
				System.out.println("Introduce el número del garaje que quieres alquilar:");
				numero = sc.nextInt();
				alquilarGaraje = alquiler[numero].alquiler();
				for (int i = 0; i < alquiler.length; i++) {
					if (alquilarGaraje == 0) {
						System.out.println("El garaje ya está alquilado.");
					}
					System.out.println("Garaje alquilado. Precio: " + alquilarGaraje);
					encontrado = true;
					break;
				}
				if (!encontrado) {
					System.out.println("Garaje no encontrado.");
				}
				break;
			case 2:
				System.out.println("Introduce el número del garaje:");
				numero = sc.nextInt();
				System.out.println("El precio de alquiler del garaje " + numero + " es: " + alquiler[numero].getFinalprecio());
				break;
			}
		} while (opcion != 0);

	}
}
