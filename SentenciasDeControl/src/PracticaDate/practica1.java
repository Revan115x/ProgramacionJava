package PracticaDate;

import java.text.spi.DateFormatProvider;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*1. Muestra el día, mes y año actual, incluido el día de la semana.*/
		
		
		LocalDate fecha=LocalDate.now();
		
		/*Creamos la variable patron para fecha europea*/
		DateTimeFormatter patron;
		
		/*Definimos nuestro patron como dia/mes/año*/
		patron=DateTimeFormatter.ofPattern("dd MMMM YYYY");
		
		/*Resultado sin usar patron*/
		System.out.println(fecha+" / "+fecha.getDayOfWeek().name());
		
		/*Resultado usando la variable patron + dia en español*/
		System.out.println(patron.format(fecha)+" / "+fecha.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.getDefault()));
		

	}

}
