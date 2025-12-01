package PracticaLocalDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class practica3_1 {

	public static void main(String[] args) {//version begoña
		// TODO Auto-generated method stub

		// variables que utilizare
		LocalDate fecha=null;
		int dia, mes, año;
		boolean correcto = false;
		Scanner sc= new Scanner(System.in);

		//bucle para validar bien las fechas en caso de error
		do {
			try {
				//pido las fechas
				System.out.println("dia");
				dia = sc.nextInt();
				System.out.println("mes");
				mes = sc.nextInt();
				System.out.println("año");
				año = sc.nextInt();

				//intento pasar mis variables int a mi variable fecha que es localdate utilizando of(int)
				fecha = LocalDate.of(año, mes, dia);
				correcto = true;
				
				
			} catch (DateTimeParseException e) {// en caso de que los int no se hayan podido pasar a localdate salta esta excepcion
				System.out.println("fecha incorrecta");
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("no se puede introducir un caracter");
			}catch (NullPointerException e) {
				System.out.println("caracteres");
			}
			
		} while (correcto == false);
		
		
		//actualizo correcto nuevamente para bucle
		correcto=false;
		int dias = 0;
		
		//otro bucle para validar bien mis caracteres
		do {
			
			try {
				//Le pido los dias que quiero aumentar si si esta bien valido
				System.out.println("numero de dias");
				dias=sc.nextInt();
				correcto=true;
			}catch (InputMismatchException e) {// si he introduccido algun caracter que no sea numero salga esto
				sc.nextLine();
				System.out.println("no se pueden caracteres");
			}
			
		}while(!correcto);
		
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println(fecha.plusDays(dias).format(patron));
		
	}
	
}
