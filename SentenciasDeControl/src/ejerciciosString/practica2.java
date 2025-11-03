package ejerciciosString;

import java.util.Scanner;

public class practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee nombres de ciudades europeas y cuenta cuantas empiezan por
		 * una letra introducida por teclado
		 */

		String ciudad = "";
		char letra;
		int cont = 0;
		boolean ronda = true;

		Scanner sc = new Scanner(System.in);

		System.out.println("que letra?");
		letra = sc.nextLine().charAt(0);

		letra = Character.toUpperCase(letra);

		do {

			System.out.println("nombre ciudad");
			ciudad = sc.nextLine();

			ciudad = ciudad.toUpperCase();

			if (letra == ciudad.charAt(0)) {
				cont++;
			}

			System.out.println("otra ronda true/false");
			ronda = sc.nextBoolean();
			sc.nextLine();

		} while (ronda == true);

		System.out.println("el numero de veces que esta la letra son " + cont);
		
		sc.close();
	}

}
