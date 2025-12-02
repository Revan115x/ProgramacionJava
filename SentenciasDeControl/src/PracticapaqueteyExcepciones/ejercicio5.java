package PracticapaqueteyExcepciones;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio5 {
	static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 5. Lee una cadena e intenta extraer una fecha con el formato dd/mm/yyyy de su
		 * contenido (la cadena puede tener otras cosas, por ejemplo “Yo nací el
		 * 29/02/1998”). Los casos en los que no se encuentre ninguna fecha o se
		 * encuentren varias deberán manejarse con excepciones.
		 */

		// variables que utilizare
		String nacimiento = null;
		boolean correcto = false;
		LocalDate fechaCorrecta;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// llamo el scanner para poder leer desde cualquier lado
		sc = new Scanner(System.in);

		// bucle para validar la fecha
		do {
			System.out.println("¿Qué día has nacido?");
			nacimiento = sc.nextLine();
			try {
				fechaCorrecta = validarFecha(nacimiento);
				System.out.println("TU FECHA ES " + patron.format(fechaCorrecta));
				correcto = true;
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}

		} while (!correcto);

	}

	public static LocalDate validarFecha(String f1) throws Exception {

		String posible = null;
		LocalDate fecha = null;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int contador = 0;

		// Recorremos carácter por carácter
		for (int i = 0; i < f1.length(); i++) {

			// Si es dígito, puede comenzar una fecha
			if (Character.isDigit(f1.charAt(i))) {

				// Aseguramos que caben 10 caracteres
				if (i + 10 <= f1.length()) {

					posible = f1.substring(i, i + 10);

					try {
						// Intentamos parsear con patrón
						fecha = LocalDate.parse(posible, patron);
						contador++;

					} catch (DateTimeException e) {
						// No hacemos nada, simplemente ignoramos esta posición
					}
				}
			}
		}

		// Validaciones del ejercicio
		if (contador == 0) {
			throw new Exception("NO SE HA ENCONTRADO NINGUNA FECHA VALIDA.");
		}
		if (contador > 1) {
			throw new Exception("SE HAN ENCONTRADO VARIAS FECHAS EN LA CADENA.");
		}

		return fecha;
	}

}
