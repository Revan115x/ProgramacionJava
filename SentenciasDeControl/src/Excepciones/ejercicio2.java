package Excepciones;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Haced una función que lea una fecha en formato dd/mm/aa mientras sea
		 * incorrecta.
		 */

		String fech;
		LocalDate Buena = null;

		Scanner sc = new Scanner(System.in);

		while (Buena == null) {
			
			System.out.println("fecha?");
			fech = sc.nextLine();
			Buena = validarFecha(fech);
		}

		System.out.println(Buena);

	}

	public static LocalDate validarFecha(String fech) {

		LocalDate fecha = null;

		DateTimeFormatter patron;
		patron = DateTimeFormatter.ofPattern("dd/MM/yy");
		try {
			fecha = LocalDate.parse(fech, patron);
		} catch (DateTimeException e) {
			System.out.println("error");
		}

		return fecha;
	}

}
