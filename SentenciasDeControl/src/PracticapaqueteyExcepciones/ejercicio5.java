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

		boolean correcto = false;
		String nacimiento, posible = null;
		LocalDate fecha;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		sc = new Scanner(System.in);

		do {

			System.out.println("QUE DIAS HAS NACIDO?");
			nacimiento = sc.nextLine();

			for (int i = 0; i < nacimiento.length(); i++) {
				if (Character.isDigit(nacimiento.charAt(i))) {
					if (i + 10 <= nacimiento.length()) {
					posible=nacimiento.substring(i,i+10);
					}
				}
			}

			try {
				
				fecha=LocalDate.parse(posible,patron);
				System.out.println("LA FECHA ES "+fecha);
				correcto=true;

			} catch (DateTimeException e) {
				System.out.println("NO HAY FECHA");
				sc.nextLine();
			}catch (NullPointerException e) {
				System.out.println("deberias de añadir una fecha");
			}

		} while (!correcto);

	}

}
