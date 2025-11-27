package Excepciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ejercicio5 {

	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. Lee dos fechas de teclado en formato dd/mm/aa, de manera que la primera
		 * sea menor que la segunda. Controla con excepciones que la fecha sea correcta.
		 * Haz una función que reciba las dos fechas y si son del mismo mes retorna los
		 * días que hay entre ambas, si no retorna los meses que hay entre ambas.
		 */
		sc = new Scanner(System.in);

		LocalDate fecha1, fecha2;
		int comparar;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yy");
		String uno, dos;
		boolean correcto = false;

		do {
			System.out.println("Primera fecha dd/mm/aa");
			uno = sc.nextLine();

			System.out.println("Primera fecha dd/mm/aa");
			dos = sc.nextLine();

			try {
				fecha1 = LocalDate.parse(uno, patron);
				fecha2 = LocalDate.parse(dos, patron);

				if (fecha1.isAfter(fecha2)) {
					System.out.println("la primer fecha debe ser menor que la segunda");
					correcto = false;

				} else if (fecha1.getYear() == fecha2.getYear() && fecha1.getMonthValue() == fecha2.getMonthValue()) {
					comparar = validarfecha(fecha1, fecha2);
					System.out.println("Las fechas son del mismo mes y año, la diferencia de dias es: " + comparar);
					correcto = true;
				} else {
					correcto = true;
					System.out.println("correcto");
				}

			} catch (DateTimeParseException e) {
				System.out.println("error");
				correcto = false;
			}

		} while (correcto == false);

	}

	public static int validarfecha(LocalDate fch, LocalDate fch2) {

		int dias = 0;
		dias = (int) ChronoUnit.DAYS.between(fch, fch2);
		return dias;

	}

}
