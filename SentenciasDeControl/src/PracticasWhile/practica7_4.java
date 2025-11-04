package PracticasWhile;

import java.util.Scanner;

public class practica7_4 {

	public static void main(String[] args) {

		/*
		 * Ampliar el ejercicio anterior para calcular el factorial de todos los números
		 * que quiera el usuario.
		 */

		int numero, fact = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Di un numero");
		numero = sc.nextInt();

		while (numero > 0) {

			fact = factorial(numero);
			System.out.println(fact);
			
			System.out.println("Di un numero");
			numero = sc.nextInt();
			
			if (numero == 0) {

				System.out.println("POR NIGGA");
				break;

			}

		}

	}

	public static int factorial(int num) {

		int acumulador = 1;
		for (int i = 1; i <= num; i++) {
			acumulador = acumulador * i;
		}
		return acumulador;

	}

}
