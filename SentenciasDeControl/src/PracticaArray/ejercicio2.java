package PracticaArray;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leed 5 números en un array, sólo dejad introducir cada número si es positivo,
		 * si no lo es volved a pedirlo hasta que lo sea. Después recorred el array y
		 * mostrad sus cuadrados.
		 */

		Scanner sc = new Scanner(System.in);

		int[] num = new int[5];

		for (int i = 0; i < num.length; i++) {

			do {

				System.out.println("introduce un numero");
				num[i] = sc.nextInt();

				if (num[i] <= 0) {
					System.out.println("Deben ser numeros positivos");
				}
				
			} while (num[i] < 0);
			
		}
		
		for(int i=0;i<num.length;i++) {
			
			System.out.println("numero es "+num[i]+" el cuatrado es "+num[i]*num[i]);
			
		}

	}

}
