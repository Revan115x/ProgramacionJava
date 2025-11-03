package Bucles;

import java.util.Scanner;

public class practica_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leer números hasta que se introduzca un 0. Para cada uno indicar si es par o
		 * impar.
		 */

		int num;
		Scanner sc = new Scanner(System.in);

		System.out.println("Numero?");
		num = sc.nextInt();

		while (num != 0) {

			if (num % 2 == 0) {
				System.out.println("Par");
			} else
				System.out.println("Impar");

			System.out.println("Numero?");
			num = sc.nextInt();
		}

		System.out.println("Fin programa");

	}

}
