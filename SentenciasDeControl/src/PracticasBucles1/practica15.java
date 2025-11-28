package PracticasBucles1;

import java.util.Locale;
import java.util.Scanner;

public class practica15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pide un número (que debe estar entre 0 y 10) y mostrar la tabla de
		 * multiplicar de dicho número.
		 */

		int num, resultado;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		System.out.println("Numero?");
		num = sc.nextInt();

		while (num <= 0 || num >= 10) {

			System.out.println("Error");
			num = sc.nextInt();

		}

		for (int i = 0; i < 10; i++) {

			resultado = num * i;

			System.out.println(num + " X " + i + " = " + resultado);

		}

	}

}
