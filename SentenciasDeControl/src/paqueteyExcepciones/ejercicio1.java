package paqueteyExcepciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ejercicio1 {

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
				} else {
					comparar = validarfecha(fecha1, fecha2);
					correcto = true;
				}
				
			} catch (DateTimeParseException e) {
				System.out.println("error");
			}
		} while (correcto == false);
	}
	public static int validarfecha(LocalDate fch, LocalDate fch2) {

		int dias = 0;
		int meses = 0;
		if (fch.getYear() == fch2.getYear() && fch.getMonthValue() == fch2.getMonthValue()) {
			dias = (int) ChronoUnit.DAYS.between(fch, fch2);
			System.out.println("la diferencia de dias es de " + dias);
			return dias;
		}
		meses = (int) ChronoUnit.MONTHS.between(fch, fch2);
		System.out.println("la diferencia de meses es de " + meses);
		return meses;
	}

}
