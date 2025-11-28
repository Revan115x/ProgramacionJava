package PracticasBucles1;

import java.util.Scanner;

public class practica_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub

				/*
				 * Leer un número e indicar si es positivo o negativo. El proceso se repetirá
				 * hasta que se introduzca un 0.
				 */

				try (Scanner sc = new Scanner(System.in)) {
					int num;

					do {
						System.out.println("di un numero");
						num = sc.nextInt();

						if (num > 0)
							System.out.println("es positivo");
						else
							System.out.println("es negativo");

					} while (num != 0);
				}

				System.out.println("Fin del programa");


	}

}
