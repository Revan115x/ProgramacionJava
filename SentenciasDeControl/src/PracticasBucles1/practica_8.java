package PracticasBucles1;

import java.util.Scanner;

public class practica_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Pedir el salario de 10 empleados. Mostrar cuantos ganan más de 1000€. */

		int num, cont = 0;

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {

			System.out.println("salario?");
			num = sc.nextInt();

			if (num >= 1000)
				cont++;

		}

		System.out.println("La cantidad de empleados que ganan mas de 1000€ = " + cont);

	}

}
