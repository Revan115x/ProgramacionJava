package PracticaLocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class practica5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee dos horas (horas y minutos) y nos dice los minutos
		 * transcurridos entre ambas.
		 */

		String hora1;
		String hora2;
		boolean correcto = false;

		LocalTime tipo1 = null, tipo2 = null;

		Scanner sc = new Scanner(System.in);

		do{
			System.out.println("Indica la primera hora hh:mm:ss");
			hora1 = sc.nextLine();
			try {
				tipo1 = LocalTime.parse(hora1);
				correcto = true;
			} catch (DateTimeParseException e) {
				System.out.println("Formato hora incorrecto");
			}
		}while (correcto == false);
		
		do{
			System.out.println("Indica la segunda hora hh:mm:ss");
			hora2 = sc.nextLine();
			try {
				tipo2 = LocalTime.parse(hora2);
				correcto = true;
			} catch (DateTimeParseException e) {
				System.out.println("Formato hora incorrecto");
			}
		}while (correcto == false);
		
		
		long diferencia=0;
		
		if (tipo1.isBefore(tipo2))
			diferencia = ChronoUnit.MINUTES.between(tipo1, tipo2);
		else
			diferencia = ChronoUnit.MINUTES.between(tipo2, tipo1);

		System.out.println("la diferencia de minutos es es de "+diferencia);
		
	}

}
