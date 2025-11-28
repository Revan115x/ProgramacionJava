package PracticaExcepciones;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ejercicio2 {

	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Haced una función que lea una fecha en formato dd/mm/aa mientras sea
		 * incorrecta.
		 */
		
		DateTimeFormatter patron;
		patron = DateTimeFormatter.ofPattern("dd/MM/yy");

		LocalDate Buena = null;

		sc = new Scanner(System.in);

		Buena = validarFecha();

		System.out.println(patron.format(Buena));

	}

	public static LocalDate validarFecha() {
		String fech;

		LocalDate fecha = null;

		DateTimeFormatter patron;
		patron = DateTimeFormatter.ofPattern("dd/MM/yy");

		while (fecha == null) {

			System.out.println("fecha?");
			fech = sc.nextLine();
			try {
				fecha = LocalDate.parse(fech, patron);
			} catch (DateTimeParseException e) {
				System.out.println("error");
			}
		}

		return fecha;
	}

}
