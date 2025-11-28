package PracticasBucles1;

import java.util.Locale;
import java.util.Scanner;

public class practica13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Programa que lee un número y escribe todos los anteriores a él */

		int num, anterior = 0;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		System.out.println("Numero?");
		num = sc.nextInt();

		while (num > 0) {

			num = num - 1;
			System.out.println(num);

		}

	}

}
