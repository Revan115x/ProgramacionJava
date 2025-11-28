package PracticasBucles2;

import java.util.Locale;
import java.util.Scanner;

public class practica12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee las notas en programación de esta clase y cuenta el no de
		 * aprobados
		 */
		
		int contnotas=0;
		double notas;
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		for(int i=0; i<5;i+=1) {
			
			System.out.println("di un numero");
			notas = sc.nextDouble();
	
			if (notas>0 && notas<=10) {
				if(notas>=5)
					contnotas+=1;
			}else 
				System.out.println("error");
		
		}
		
		System.out.println("numero de aprobados " +contnotas);
	}

}
