package PracticaArray;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leed 10 números en un array. Una vez leídos todos recorred el array y mostrad
		 * los que son pares, recorredlo de nuevo para mostrar los impares.
		 */

		Scanner sc = new Scanner(System.in);

		int num[] = new int[4];

		for (int i = 0; i < num.length; i++) {

			System.out.println("introduce numeros");
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < num.length; i++) {

			if (num[i] % 2 == 0) {
				System.out.println("Numeros par "+num[i]);
			}

		}
		
		for (int i = 0; i < num.length; i++) {

			if (num[i] % 2 != 0) {
				System.out.println("Numeros impares "+num[i]);
			}
		}
		
	}

}
