package PracticasBucles1;

import java.util.Scanner;

public class practica_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leer un número y mostrar su cuadrado, repetir el proceso hasta que se
		 * introduzca un número negativo.
		 */

		int num, cuadrado = 0;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un número: ");
			num = sc.nextInt();

			if (num >= 0) {
				cuadrado = num * num;
				System.out.println("El cuadrado de " + num + " es: " + cuadrado);
			}

		} while (num >= 0);

		System.out.println("Programa finalizado");

	}

}
