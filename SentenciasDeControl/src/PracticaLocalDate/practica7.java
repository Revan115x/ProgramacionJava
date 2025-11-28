package PracticaLocalDate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class practica7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Lee la fecha de nacimiento de una persona y calcula su edad. */

		String nacimiento;
		LocalDate dia = null;
		LocalDate HOY=LocalDate.now();
		boolean correcto = true;
		DateTimeFormatter formato;

		formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Fecha nacimiento Ej 20/03/2000");
			nacimiento = sc.nextLine();

			try {
				dia = LocalDate.parse(nacimiento, formato);
				correcto = true;
			} catch (DateTimeException e) {
				System.out.println("error con el formato");
				correcto = false;
			}

		} while (!correcto);
		
		long años= Math.abs(ChronoUnit.YEARS.between(dia, HOY));
		System.out.println(años);

	}

}
