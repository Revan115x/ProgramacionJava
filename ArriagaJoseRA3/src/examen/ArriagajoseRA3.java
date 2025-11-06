package examen;

import java.util.Scanner;

public class ArriagajoseRA3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double presupuesto;
		String producto = "";
		boolean correcto = false;
		boolean ok = false;
		boolean validar;
		double preciototal;
		double precio;
		int unidad = 2;

		Scanner sc = new Scanner(System.in);

		System.out.println("De cuanto es tu presupuesto?");
		presupuesto = sc.nextDouble();

		do {
			sc.nextLine();/* limpio el buffer para introducir texto en el bucle */

			do {
				System.out.println("CODIGO PRODUCTO EJ=PX345");
				producto = sc.nextLine();
				producto = producto.toUpperCase();
				validar = validarproducto(producto);/* llamo a la funcion */

				if (validar = false) {
					System.out.println("error");
					correcto = false;
				} else {
					correcto = true;
				}

			} while (!correcto);

			System.out.println("precio producto");

			correcto = false;

			do { /* Bucle para validar numero positivos */
				precio = sc.nextDouble();
				if (precio <= -1) {
					System.out.println("tiene que ser positivo");
					correcto = true;
				} else {
					correcto = false;
				}
			} while (correcto);

			if (validar = true) {
				preciototal = calcularproductos(unidad, precio);
				if (preciototal < presupuesto) {
					System.out.println("precio total es" + preciototal);
					ok = true;
				} else {
					System.out.println("has sobrepasado tu presupuesto");
					ok = false;
				}
			}

		} while (!ok); /* bucle funciona a medias */

		String fin = "fin";
		String Texto = "";

		System.out.println("si quiere terminar escribe Fin");
		Texto = sc.nextLine();
	}

	public static boolean validarproducto(String cosa) {

		String cosa1 = cosa.substring(0, 1);/*
											 * intento coger los dos numeros para hacer un if y verificar si son texto y
											 * si tiene "P"
											 */
		String cosa2 = cosa.substring(3, 5);/*
											 * intento coger los los otros caracteres y ver si son numeros, pero no
											 * tengo ni idea,queria usar CharacterIsdigit pandolo a int
											 */

		char letra = cosa1.charAt(0);
		int numero = cosa2.compareToIgnoreCase(cosa2);
		if (letra >= 'A' && letra <= 'z') {
			if (cosa.equalsIgnoreCase("P"))
				/* if(cosa2.characterIsdigit()) */
				return true;
		} else {
			return false;
		}
		return false;

	}

	public static double calcularproductos(int cantidad, double dinero) {

		double resultado;

		resultado = cantidad * dinero;

		return resultado;

	}

}
