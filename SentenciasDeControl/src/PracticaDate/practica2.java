package PracticaDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Lee dos fechas de teclado (día, mes y año) y ordénalas de menor a mayor. */

		String fechaUser;
		String fechaUser2;
		boolean correcto = false;

		LocalDate fecha1 = null, fecha2 = null;

		/* Creamos la variable patron para fecha europea */
		DateTimeFormatter patron;

		/* Definimos nuestro patron como dia/mes/año */
		patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Primera Fecha");
			fechaUser = sc.nextLine();
			System.out.println("Segunda Fecha");
			fechaUser2 = sc.nextLine();

			try {

				fecha1 = LocalDate.parse(fechaUser, patron);
				correcto = true;
				fecha2 = LocalDate.parse(fechaUser2, patron);
				correcto = true;

				if (fecha1.isAfter(fecha2))
					System.out.println(patron.format(fecha2));
				else
					System.out.println(patron.format(fecha1));

			} catch (DateTimeParseException e) {
				System.out.println("formato incorrecto");
				System.exit(0);

			}
		} while (!correcto);

	}
}
