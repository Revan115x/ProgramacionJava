package PracticaExcepciones;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ejercicio1 {

	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Haced una función que lee un double, controlando que no anoten letras usando
		 * excepciones.
		 */

		double numero;

		sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		numero = leerdouble();
		System.out.println("el numero es " + numero);

	}

	public static double leerdouble() {

		double num = 0;
		boolean correcto = false;

		while (!correcto) {
			try {
				System.out.println("introduce un numero");
				num = sc.nextDouble();
				correcto = true;
			} catch (InputMismatchException e) {
				// mostrar los errores TODO Auto-generated catch block
				// e.printStrackTrace();
				sc.nextLine();
				System.out.println("Error");

			}
		}

		return num;

	}

}
