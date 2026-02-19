package Numeros_HashSet;

import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		/*
		 * Lee un conjunto de números, terminando al anotar cero. Lee otro conjunto de
		 * números, termina también al anotar cero. Muestra el contenido de los dos
		 * conjuntos. Di si un conjunto está incluido en otro. Usa HashSet.
		 */

		Scanner sc = new Scanner(System.in);
		HashSet<Integer> Numero = new HashSet<>();
		HashSet<Integer> Numero2 = new HashSet<>();

		int num;

		System.out.println("********************************************");
		System.out.println("****************CONJUNTO 1******************");
		System.out.println("********************************************");

		while (true) {
			System.out.println("Introduce un numero (0 para terminar): ");
			num = sc.nextInt();

			if (num == 0)
				break;

			Numero.add(num);
			System.out.println("NUMERO AÑADIDO");
		}

		System.out.println("********************************************");
		System.out.println("****************CONJUNTO 2******************");
		System.out.println("********************************************");

		while (true) {
			System.out.println("Introduce un numero (0 para terminar): ");
			num = sc.nextInt();

			if (num == 0)
				break;

			Numero2.add(num);
			System.out.println("NUMERO AÑADIDO");

		}

		if (Numero.containsAll(Numero2)) {
			System.out.println(Numero2 + "Esta incluido" + Numero);
		} else {
			System.out.println(Numero + "Esta incluido" + Numero2);
		}
	}
}