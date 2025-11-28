package PracticaLocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class practica3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate fecha=null;
		int dia, mes, año;
		boolean correcto = false;
		Scanner sc= new Scanner(System.in);

		do {
			try {
				System.out.println("dia");
				dia = sc.nextInt();
				System.out.println("mes");
				mes = sc.nextInt();
				System.out.println("año");
				año = sc.nextInt();

				fecha = LocalDate.of(año, mes, dia);
				correcto = true;
			} catch (DateTimeParseException e) {
				System.out.println("fecha incorrecta");
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("no se puede introducir un caracter");
			}catch (NullPointerException e) {
				System.out.println("caracteres");
			}
			
		} while (correcto == false);
		
		correcto=false;
		int dias = 0;
		
		do {
			try {
				System.out.println("numero de dias");
				dias=sc.nextInt();
				correcto=true;
			}catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("no se pueden caracteres");
			}
		}while(!correcto);
		
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println(fecha.plusDays(dias).format(patron));
		
	}
	
}
