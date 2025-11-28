package PracticaExcepciones;

import java.util.Scanner;

public class ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Modifica la función que valida el DNI para que dé error si los primeros
		 * caracteres no son dígitos usando NumberFormatException.
		 */

		String dni;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce dni:");
		dni = sc.nextLine();
		if (validarDni(dni) == false)
			System.out.println("Dni incorrecto");
		else
			System.out.println("Dni correcto");

	}

	public static boolean validarDni(String dni) {
		char letra;
		int numero;
		String letrasdni = "TRWAGMYFPDXBNJZSQVHLCKE";

		if (dni.length() != 9)
			return false;
		letra = dni.charAt(8);
		// if (!Character.isLetter(letra))
		letra = Character.toUpperCase(letra);
		if (letra < 'A' || letra > 'Z')
			return false;
		/*
		 * for(int i=0;i<8;i++) { //if (Character.isDigit(dni.charAt(i))==false) if
		 * (dni.charAt(i)<'0' || dni.charAt(i)>'9') return false; }
		 */
		try {
			numero = Integer.parseInt(dni.substring(0, 8));
		} catch (NumberFormatException e) {
			return false;
		}

		int pos = numero % 23;

		if (letrasdni.charAt(pos) != letra)
			return false;

		return true;
	}

}
