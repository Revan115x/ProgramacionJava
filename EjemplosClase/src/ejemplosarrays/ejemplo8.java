package ejemplosarrays;

import java.util.Scanner;

public class ejemplo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 8. Codificar un programa que lea tantos enteros como desee el usuario (máximo
		 * 20) y los introduce en un array. Luego introducir un número y buscarlo
		 * secuencialmente.
		 */

		Scanner sc = new Scanner(System.in);

		int num[] = new int[20];
		int buscar;
		int cont = 0;

		for (int i = 0; i < num.length; i++) {

			System.out.println("Introduce los numeros");
			num[i] = sc.nextInt();
			cont++;

		}

		boolean correcto = false;

		System.out.println("Has introducido " + cont);

		for (int i = 0; i < cont; i++) {

			while (!correcto) {

				System.out.println("Buscar numero");
				buscar = sc.nextInt();

				if (buscar == num[i]) {
					System.err.println("encontrado");
					correcto = true;
				}

				System.out.println("no se ha encontrado");

			}

		}
	}

}
