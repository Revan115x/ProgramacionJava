package PracticaString;

import java.util.Scanner;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Programa que lee cadenas hasta anotar “fin” y las muestra en mayúsculas.*/

		String letra = "";
		String palabra = "FIN";

		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("Palabra?");
			letra = sc.nextLine();

			letra = letra.toUpperCase();

			System.out.println(letra);

			if (letra.equals(palabra)) {
				System.out.println("Fin programa");
				break;
			}

		} while (!letra.equals(palabra));
		
		sc.close();

	}

}
