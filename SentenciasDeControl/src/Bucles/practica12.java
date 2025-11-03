package Bucles;

import java.util.Locale;
import java.util.Scanner;

public class practica12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee las notas en programación de esta clase y cuenta el no de
		 * aprobados
		 */
		
		int notas,aprobados=0;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		for(int i=0;i<10;i++) {
			
			System.out.println("Nota");
			notas=sc.nextInt();
			
			if(notas>5)
				aprobados++;
			
		}
		
			System.out.println("Aprobados son= "+aprobados);

	}

}
