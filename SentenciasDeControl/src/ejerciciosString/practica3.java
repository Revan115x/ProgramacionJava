package ejerciciosString;

import java.util.Scanner;

public class practica3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee nombre y primer apellido de personas. Para cada una de ellas
		 * genera un código con la primera letra del nombre y las tres primeras del
		 * apellido. Si dicho apellido tiene una longitud inferior a 3, se le pide el
		 * segundo apellido y se cogen sus tres primeras letras. Si éste, también tiene
		 * menos longitud se genera el código con la primera del nombre y el apellido
		 * completo que sea más largo de los dos. El código se genera en una función.
		 */

		String apellido = "";
		String apellido2 = "";
		String nombre = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre");
		nombre = sc.nextLine();

		System.out.println("apellido");
		apellido = sc.nextLine();

		System.out.println("segundo apellido");
		apellido2 = sc.nextLine();

		char PrimeraLetra = primerN(nombre);

        String letrasApellido = primerAp(apellido, apellido2);
        
        String codigo = "" + PrimeraLetra + letrasApellido;
        
        System.out.println("Código generado: " + codigo.toUpperCase());
        
        sc.close();

	}

	public static char primerN(String nombres) {

		return nombres.charAt(0);

	}

	public static String primerAp(String Apellido1, String Apellido2) {

		if (Apellido1.length() >= 3) {
			return Apellido1.substring(0, 3);
		} else if (Apellido2.length() >= 3) {
			return Apellido2.substring(0, 3);
		} else {
			if (Apellido1.length() >= Apellido2.length())
				return Apellido1;
			else
				return Apellido2;
		}
	}
}
