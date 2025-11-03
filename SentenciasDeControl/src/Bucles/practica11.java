package Bucles;

import java.util.Locale;
import java.util.Scanner;

public class practica11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee 100 números y cuenta cuantos han sido pares, cuantos impares
		 * y cuantos nulos
		 */

		int num, par = 0, impar = 0, nulos = 0;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		for (int i = 0; i < 10; i++) {

			System.out.println("Numero?");
			num = sc.nextInt();

			if (num == 0)
				nulos++;
			else if (num % 2 == 0)
				par++;
			else
				impar++;

		}

		System.out.println("Cantidad de pares " + par);
		System.out.println("Cantidad de impares " + impar);
		System.out.println("Cantidad de nulos " + nulos);

	}

}
