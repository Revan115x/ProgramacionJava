package Excepciones;

import java.security.AlgorithmParameterGenerator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee números de teclado hasta anotar un 0 y calcula su media. Usa
		 * excepciones para que si el usuario se equivoca al introducir un número se
		 * muestre un error y se vuelva a pedir, también usa una excepción para
		 * controlar la división por cero.
		 */

		int num = 0;
		double media = 0;
		int acumulador = 0;
		int cont = 0;

		Scanner sc = new Scanner(System.in);

		do {

			try {
				System.out.println("introduce un numero");
				num = sc.nextInt();

				if (num != 0) {
					acumulador += num;
					cont++;
				}

				media = (double)acumulador / cont;
				System.out.println("Media: " + media);

			} catch (InputMismatchException e) {
				System.out.println("Error: debes introducir un número.");
				num=-1;
				sc.nextLine();
			} catch (ArithmeticException e) {
				//e.printStackTrace();
				System.out.println("No se puede dividir entre cero todavía.");
			}

		} while (num != 0);

		System.out.println("Programa finalizado." +media);

	}

}