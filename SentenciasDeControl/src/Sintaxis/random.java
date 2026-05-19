package Sintaxis;

import java.util.Random;

public class random {
	
	public static void main(String[] args) {
		
		//Podemos generar números aleatorios con la clase Random del paquete util

		Random r = new Random();
		int valorAleatorio = r.nextInt(6)+1; // Entre 0 y 5, más 1.

		//O con el método random de la clase Math:
		double num=Math.random(); //genera un número entre 0 y 1, pero nunca el 1.
		
	}

}
