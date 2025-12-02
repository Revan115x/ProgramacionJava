package PracticapaqueteyExcepciones;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ejercicio6 {

	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Crea un programa que pida al usuario una fecha de nacimiento con el formato dd/MM/yyyy.
		 * El programa debe: Convertir el texto a un objeto LocalDate.
		 * Validar que la fecha no sea futura.
		 * Validar que el usuario tenga al menos 18 años.
		 * Si la fecha es inválida, lanzar tus propias excepciones:
		 * FechaEnElFuturoException
		 */
		
		sc=new Scanner(System.in);

		String nacimiento=null;
		LocalDate fecha=null;
		LocalDate ahora=LocalDate.now();
		boolean correcto = false;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		do {
			
			System.out.println("fecha nacimiento?");
			nacimiento = sc.nextLine();
			
			try {
				fecha = LocalDate.parse(nacimiento, patron);
				System.out.println(patron.format(fecha));
				
				boolean fechabuena = validarfecha(ahora,fecha);
				if(fechabuena==true) {
					correcto=true;
				}
				
			} catch (DateTimeException e) {// es para no meter textos
				System.out.println("añade fecha");
			}catch (FechaEnElFuturoException e) {
				System.out.println(e.getMessage());
			}

		} while (!correcto);
		
		long años= Math.abs(ChronoUnit.YEARS.between(fecha,ahora));
		System.out.println("TU EDAD ES "+años);
		
		if(años<18) {
			System.out.println("ERES MENOR DE EDAD ESTAS FUERA");
			System.exit(0);
		}
		
	}
	
	public static  boolean validarfecha(LocalDate ahora,LocalDate fecha) throws FechaEnElFuturoException {
		
		boolean bien=false;
		
		if(ahora.isBefore(fecha)) {
			throw new FechaEnElFuturoException("ESTA FECHA ES DEL FUTURO");
		}else
			bien=true;
		
		return bien;
		
	}
	
}
