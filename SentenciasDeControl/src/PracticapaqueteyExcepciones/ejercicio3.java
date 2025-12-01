package PracticapaqueteyExcepciones;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio3 {

	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 3. Haz un juego interactivo donde el ordenador genera una fecha secreta y el
		 * usuario trata de averiguarla. El usuario va haciendo preguntas en las que
		 * indica una fecha y el ordenador responde si la fecha secreta es mayor o menor
		 * que la introducida. El juego termina cuando se averigua la fecha. Los casos
		 * en los que el usuario no introduzca una fecha con un formato válido deben
		 * manejarse con excepciones.
		 */

		// DECLARO VARIABLES QUE USARE
		int dia, mes, año, cont = 0;
		LocalDate fecha;
		LocalDate fecha2 = LocalDate.of(2006, 07, 04);// DEFINO FECHA ALEATORIA PREGUNTAR COMO GENERAR UNA
		boolean correcto = false, pista = false;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// LLAMO AL SCANNER
		sc = new Scanner(System.in);

		// BUCLE PARA REPETIR EL EJERCICO EN CASO DE ERROR
		while (!correcto) {

			/*
			 * sc = new Scanner(System.in);
			 * 
			 * System.out.println("Dime el dia"); dia = sc.nextInt();
			 * 
			 * System.out.println("Dime mes"); mes = sc.nextInt();
			 * 
			 * System.out.println("Dime año"); año = sc.nextInt(); PREGUNTAR PORQUE NO
			 * FUNCIONA SI LEO AFUERA DEL TRY
			 */

			try {

				// LEO LAS FECHAS
				System.out.println("Dime el dia");
				dia = sc.nextInt();

				System.out.println("Dime mes");
				mes = sc.nextInt();

				System.out.println("Dime año");
				año = sc.nextInt();

				// PASO LOS INT A FECHAS
				fecha = LocalDate.of(año, mes, dia);
				// PASO LA FECHA A MI PATRON
				System.out.println(patron.format(fecha));
				// PASO TAMBIEN LA FECHA "ALEATORIA A MI PATRON PARA QUE PUEDA COMPARAR BIEN"
				patron.format(fecha2);
				cont++;

				System.out.println("Numero de intentos es " + cont);

				// COMPARO LAS FECHAS
				if (fecha.isAfter(fecha2)) {
					System.out.println("te has pasado");
					correcto = false;
				} else if (fecha.isBefore(fecha2)) {
					System.out.println("ES UN POCO MAS ADELANTE");
					correcto = false;
				} else {
					System.out.println("ENHORABUENA HAS ACERTADO LA FECHA!" + fecha2);
					correcto = true;
					break;
				}

				// AÑADIDO BLOQUE PARA DAR PISTAS ENTRE MESES Y AÑOS

				if (cont == 2) {
					System.out.println("quieres una pista? True/false");
					pista = sc.nextBoolean();
					if (pista == true) {
						int meses;
						meses = (int) ChronoUnit.MONTHS.between(fecha, fecha2);
						System.out.println("la diferencia de meses es de " + meses);
					}
				}
				if (cont == 2) {
					System.out.println("quieres una pista? True/false");
					pista = sc.nextBoolean();
					if (pista == true) {
						int años;
						años = (int) ChronoUnit.YEARS.between(fecha, fecha2);
						System.out.println("la diferencia de años es de " + años);
					}
				}

				if (cont == 3) {
					System.out.println("te rindes? true/false");
					pista = sc.nextBoolean();
					if (pista == true) {
						System.out.println("LA FECHA ERA "+patron.format(fecha2)+" PIERDES POR PRINGAO");
						break;
					}
				}

				// PROPONER MEJORAR PROGRAMA INDICANDO EL DIA,MES,AÑO

			} catch (InputMismatchException e) {// ESTA EXCEPCION SIEMPRE DEBE IR DELANTE Y LIMPIAR BUFFER
				System.out.println("Introduce caracteres numericos");
				sc.nextLine();
			} catch (DateTimeException e) {
				System.out.println("Formato incorrecto");
			}

		}

		System.out.println("FIN EL PROGRAMA");

	}

}
