package Instrumentos;

import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		/*
		 * Crea un HashSet con los nombres de varios instrumentos musicales. A
		 * continuación lee el nombre de varios instrumentos hasta anotar fin, indica
		 * para cada instrumento si está o no está en el conjunto. Si no está lo añades.
		 */

		HashSet<String> instrumento = new HashSet<>();

		Scanner sc = new Scanner(System.in);

		String instr = null;

		/* Bucle para estar siempre dentro */
		while (true) {

			System.out.println("Nombre del instrumento que usas ('FIN' PARA SALIR)");
			instr = sc.nextLine();

			/* Si lee fin rompe bucle */
			if (instr.equalsIgnoreCase("fin"))
				break;

			/*si en instrumentos ya existe el instrumento nos dira que ya existe*/
			if (instrumento.contains(instr))
				System.out.println("El instrumento ya existe en la lista");
			else {
				/*En caso de que no este se añade*/
				System.out.println("Instrumento añadido correctamente ");
				instrumento.add(instr);
			}

		}

		/* For para leer los datos */
		for (String i : instrumento)
			System.out.println(i);

	}

}
