package EjemploExcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

// Lee una cadena.
// A continuaci�n lee una posici�n hasta que sea correcta
// y muestra el caracter de esa posici�n

public class Excepciones3 {

	public static void main(String[] args) {
		boolean correcto = false;
		int pos;
		Scanner sc = new Scanner(System.in);

		System.out.println("Anota cadena");
		String cadena = sc.nextLine();

		while (!correcto) {
			System.out.println("Introduce posici�n: ");
			try {
				pos = sc.nextInt();
				System.out.println(cadena.charAt(pos));
				correcto = true;

			} catch (InputMismatchException e) {
				sc.nextLine(); //Limpio buffer
				System.out.println("\nNumero introducido incorrecto");

			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("\nTe has salido del String");
			}
		}

	}

}
