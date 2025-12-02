package PracticaString;

import java.util.Scanner;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Programa que lee cadenas hasta anotar “fin” y las muestra en mayúsculas. */

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

		/*
		 * [abc] El carácter es uno de los que aparecen
		 * 
		 * [^abc] El carácter no es ninguno de los que aparecen
		 * 
		 * [0-9] El carácter está entre el 0 y el 9
		 * 
		 * Los metacaracteres son caracteres con un significado especial:
		 * 
		 * Metacharacter Description
		 * 
		 * | Un patrón u otro: uno|dos
		 * 
		 * ^ Comienza por:
		 * 
		 * $ Termina por
		 * 
		 * \d Un dígito
		 * 
		 * \s Espacio en blanco
		 * 
		 * Los cuantificadores definen cantidades:
		 * 
		 * n+ Cómo mínimo aparece una vez
		 * 
		 * n* Cero o más veces
		 * 
		 * n? Una o ninguna
		 * 
		 * n{x} n aparece x veces
		 * 
		 * n{x,y} n aparece de un mínimo de x veces y un máximo de y veces
		 * 
		 * n{x,} N aparece como mínimo x veces
		 */

	}

}
