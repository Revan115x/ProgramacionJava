package PracticaDate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class practica3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Leer una fecha por teclado (día, mes y año) y calcular la nueva fecha transcurridos un no de días anotado por teclado.*/
		
		String fecha;
		String fecha2;
		LocalDate fechab = null,fechabb = null,calculo = null;
		
		Scanner sc=new Scanner(System.in);
		
		/* Creamos la variable patron para fecha europea */
		DateTimeFormatter patron;

		/* Definimos nuestro patron como dia/mes/año */
		patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Introduce una fecha");
		fecha=sc.nextLine();
		fechab=LocalDate.parse(fecha,patron);
		
		System.out.println("DIAS SUMAR?");
		int numero;
		numero=sc.nextInt();
		try {
			calculo=fechab.plusDays(numero);
		}catch(DateTimeException e){
			System.out.println("Error");
		}
		System.out.println("Se le ha sumado a tu fecha "+numero+" dias y tu fecha queda en = "+patron.format(calculo));
		
	}

}
