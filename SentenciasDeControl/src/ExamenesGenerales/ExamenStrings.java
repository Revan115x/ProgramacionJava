package ExamenesGenerales;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ExamenStrings {

	static Scanner sc;

	public static void main(String[] args) {

		/*
		 * Queremos simular la compra en un supermercado de una persona, haz un programa
		 * en java, utilizando las variables y constantes adecuadas y usando
		 * comentarios. Por cada persona que llega al supermercado se anota el
		 * presupuesto máximo del que dispone y después se simula la compra de varias
		 * unidades de varios productos de la siguiente manera: - Se anota el código de
		 * producto, que tiene esta forma PX999, dónde el carácter X es una letra que
		 * indica la sección, y luego tiene entre dos y tres dígitos . Leedlo hasta que
		 * sea correcto, validadlo con una función. (1,5 pto) - Se calculan las unidades
		 * de forma aleatoria (entre 1 y 4). (1 pto) - Se pide el precio unidad,
		 * validando que sea positivo. (0,25 ptos) - Calculamos el precio de las
		 * unidades mediante una función, sabiendo que los productos que pertenecen a la
		 * sección de pescadería (P) tienen un descuento del 20% y los lácteos (L),
		 * tienen un descuento del 3 por 2 unidades. (1,5 pto) - Comprobar que el
		 * usuario no se ha pasado del presupuesto inicial, si es así, la compra de este
		 * último producto se anula y se pide otro código de producto. (1 pto) El
		 * usuario termina su compra cuando se anote “FIN” como código de producto, (0,5
		 * ptos) Si se trata de un envío a domicilio se pide la zona de envío, que puede
		 * ser de la 1 a la 3, si no es así no se puede realizar el envío. En otro caso
		 * se cobra 5,7 ó 10 euros respectivamente, más por el envío, a no ser que se
		 * trate de un jubilado, en cuyo caso el envío es gratis. (1,25 pto) Mostrad el
		 * precio de toda la compra de la persona en cuestión. Repetid el proceso para
		 * varias personas hasta que se anote un presupuesto máximo de 0 euros. (1,5
		 * pto) Al Terminar el programa: - Mostrad de todos los envíos realizados, el
		 * porcentaje realizado a jubilados. (0,5 pto) - Mostrad el importe medio de
		 * todas las compras realizadas, y el importe de las dos compras más caras. (1
		 * pto)
		 */

		// TODO Auto-generated method stub

		Double presupuesto = 0.0, precioUnidad;
		Double totalcomprausuario = (double) 0;
		String codigo;
		int unidades;
		boolean correcto = false;
		Random r = new Random();

		sc = new Scanner(System.in);

		/* creo try para controlar excepciones */
		while (!correcto) {

			try {
				System.out.println("Anota tu presupuesto");
				presupuesto = sc.nextDouble();
				correcto = true;
			} catch (InputMismatchException e) {
				System.out.println("Anota digitos");
				sc.nextLine();/* limpiamos buffer */
			}
		}

		sc.nextLine();

		System.out.println("Introduce codigo articulo");
		codigo = sc.nextLine();

		/* Bucle para validar codigo */

		while (codigo.equalsIgnoreCase("fin") == false) {

			while (!validarCodigo(codigo)) {
				System.out.println("Introduce codigo articulo");
				codigo = sc.nextLine();
				codigo.toUpperCase();/* No pasa a mayusculas */

				System.out.println(codigo);
			}

			unidades = r.nextInt(4) + 1;

			do {
				System.out.println("Anota precio unidad");
				precioUnidad = sc.nextDouble();
				if (precioUnidad <= 0)
					;

			} while (precioUnidad <= 0);

			double precioproducto = CalcularPrecioTotal(codigo, unidades, precioUnidad);

			if (totalcomprausuario + precioproducto > presupuesto)
				System.out.println("Presupuesto superado retira articulo");
			else
				totalcomprausuario += precioproducto;

			System.out.println("Introduce codigo articulo");
			codigo = sc.nextLine();
		}

		/* Gestionar pedido */

		System.out.println("Quieres hacer pedido a domicilio?");
		boolean pedido = sc.nextBoolean();
		if (pedido) {
			// preguntar si es jubilado y la zona
			// incrementar la compra total del usuario con lo que vale hacer el envio
		}

	}

	public static boolean validarCodigo(String codigo) {

		if (codigo.length() < 4 || codigo.length() > 5) {
			System.out.println("la cadena debe medir 4-5 caracteres");
			return false;
		}

		// Debe empezar por P
		if (!codigo.startsWith("P") && !codigo.startsWith("L")) {
			System.out.println("DEBE EMPEZAR POR P O L");
			return false;
		}

		// El segundo carácter debe ser LETRA
		if (!Character.isLetter(codigo.charAt(1))) {
			System.out.println("El SEGUNDO CARARTER DEBER SER LETRA");
			return false;
		}

		// Los siguientes 2 o 3 caracteres deben ser dígitos
		for (int i = 2; i < codigo.length(); i++) {
			if (!Character.isDigit(codigo.charAt(i))) {
				System.out.println("LOS DEMAS CARACTERES NO SON NUMEROS");
				return false;
			}
		}

		/*
		 * PREGUNTAR PORQUE NO VALDRIA ASI if (codigo.length()<=5 || codigo.length()>4)
		 * { /* Tiene que tener longitud de 4-5 if (codigo.startsWith("P")) { // Que
		 * empieze por P if (Character.isLetter(codigo.charAt(1))) {/* CARACTER X SEA
		 * LETRA for (int i = 2; i < codigo.length(); i++) { /* PASAR POR LOS DEMAS PARA
		 * VALIDAR QUE SON NUMEROS if (Character.isDigit(codigo.charAt(i))) return true;
		 * } } } }else System.out.println("error"); return false; }
		 */

		return true;

	}

	public static double CalcularPrecioTotal(String codigo, int unidades, double precioUnidad) {
		double importe = 0;

		if (codigo.charAt(1) == 'L') {
			if (unidades >= 3) {
				int gruposDeTres = unidades / 3;
				int resto = unidades % 3;
				int unidadesAPagar = gruposDeTres * 2 + resto;

				importe = unidadesAPagar * precioUnidad;
			} else {
				importe = unidades * precioUnidad; // sin descuento
			}
			return importe;
		}

		// Pescadería → 20% descuento
		else if (codigo.charAt(1) == 'P') {
			importe = unidades * precioUnidad * 0.8;
			return importe;
		}

		// Otros productos sin descuento
		return unidades * precioUnidad;
	}

}
