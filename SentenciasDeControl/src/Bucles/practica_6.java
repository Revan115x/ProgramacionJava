package Bucles;

import java.util.Scanner;

public class practica_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que va leyendo números desde teclado y calcula la suma de todos
		 * ellos. El programa finaliza cuando el número leído es 0.
		 */

		int num, sum = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("numero?");
		num = sc.nextInt();

		while (num != 0) {

			sum = sum + num;
			num = sc.nextInt();

		}

		System.out.println("la suma es de " + sum);

	}

}
