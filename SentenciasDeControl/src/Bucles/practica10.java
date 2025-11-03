package Bucles;

import java.util.Scanner;

public class practica10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee una secuencia de notas (0 – 10) terminada al introducir –1 y
		 * cuenta el no de suspensos, aprobados, notables y sobresalientes. Validar que
		 * las notas introducidas sean correctas.
		 */

		int notas, contSus = 0, contAp = 0, contNt = 0, contSb = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Dime tus notas?");
		notas = sc.nextInt();

		while (notas > 0) {

			if (notas > 0 && notas <= 10) {

				if (notas <= 4)
					contSus++;
				else if (notas >= 5 && notas <= 7)
					contAp++;
				else if (notas >= 8 && notas <= 9)
					contNt++;
				else if (notas == 10)
					contSb++;
			} else {
				System.out.println("las notas introducidas son incorrectas");
			}
			System.out.println("Dime tus notas?");
			notas = sc.nextInt();

		}

		System.out.println("suspensos =" + contSus);
		System.out.println("aprobados =" + contAp);
		System.out.println("notables =" + contNt);
		System.out.println("sobresalientes =" + contSb);

	}

}
