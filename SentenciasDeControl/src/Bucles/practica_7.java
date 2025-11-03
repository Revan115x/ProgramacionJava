package Bucles;

import java.util.Scanner;

public class practica_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Pedir números hasta que se introduzca uno negativo, y calcular la media. */

		int num, media = 0, sum = 0, cont = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("numero?");
		num = sc.nextInt();

		while (num > 0) {

			cont++;
			sum = sum + num;
			media = sum / cont;

			System.out.println("otro numero");
			num = sc.nextInt();

		}

		System.out.println("la media es de " + media);

	}

}
