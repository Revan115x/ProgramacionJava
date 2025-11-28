package PracticaLocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class practica4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee dos fechas de teclado y nos dice cuántos días hay entre
		 * ellas.
		 */

		String fecha1, fecha2;
		LocalDate fechaa = null, fechaa2 = null;

		/* Creamos la variable patron para fecha europea */
		DateTimeFormatter patron;

		/* Definimos nuestro patron como dia/mes/año */
		patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		boolean correcto = false;

		do {
			System.out.println("Dime una fecha (03/10/2009)");
			fecha1 = sc.nextLine();
			try {
				fechaa = LocalDate.parse(fecha1, patron);
				correcto = true;
			} catch (DateTimeParseException e) {
				System.out.println("Fecha en formato incorrecto");
			}
		} while (correcto == false);

		do {
			System.out.println("Dime otra fecha (03/10/2009)");
			fecha2 = sc.nextLine();
			try {
				fechaa2 = LocalDate.parse(fecha2, patron);
				correcto = true;
			} catch (DateTimeParseException e) {
				System.out.println("Fecha en formato incorrecto");
			}

		} while (correcto == false);
		
		long diffTotaldias = 0;
		
		if (fechaa.isBefore(fechaa2))
			diffTotaldias = ChronoUnit.DAYS.between(fechaa, fechaa2);
		else
			diffTotaldias = ChronoUnit.DAYS.between(fechaa2, fechaa);

		System.out.println("la diferencia de dias es de " + diffTotaldias);

	}

}
