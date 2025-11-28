package PracticaLocalDate;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class practica6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lea tu fecha de nacimiento y diga el día de la semana (lunes,
		 * martes, miércoles...).
		 */

		String nacimiento;
		LocalDate dia = null;
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
		
		String diaSemana = dia.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.getDefault());


        
        System.out.println("has nacido un " +diaSemana+" del año "+dia.getYear()+" Del mes "+dia.getMonthValue());

	}

}
