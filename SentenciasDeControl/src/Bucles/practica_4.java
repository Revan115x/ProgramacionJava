package Bucles;

import java.util.Scanner;

public class practica_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Pedir números hasta que se teclee uno negativo, y mostrar cuántos números se
		 * han introducido.
		 */

		int num, cont = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("numero?");
		num = sc.nextInt();

		while (num > 0) {

			cont++;
			num = sc.nextInt();
		}

		System.out.println("la cantidad de numeros es de" + cont);

	}

}
