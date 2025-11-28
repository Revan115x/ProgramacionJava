package PracticasBucles1;

import java.util.Scanner;

public class practica_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Realizar un juego para adivinar un número. Para ello pedir un número N, y
		 * luego ir pidiendo números indicando “mayor” o “menor” según sea mayor o menor
		 * con respecto a N. El proceso termina cuando el usuario acierta.
		 */

		int num, numX = 5;

		Scanner sc = new Scanner(System.in);

		System.out.println("numero?");
		num = sc.nextInt();

		while (num != numX) {

			if (num > numX)
				System.out.println("Mayor");
			if (num < numX)
				System.out.println("Menor");

			num = sc.nextInt();

		}

		System.out.println("el numero era " + num);

	}

}
