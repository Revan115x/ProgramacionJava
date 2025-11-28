
package PracticasBucles2;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class practica_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee una secuencia de 50 letras y escribe el número de veces que
		 * se repite la primera de ellas.
		 */
		
		
		int cont=1;
		char letra,primera;
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		System.out.println("Introduce texto");
		primera = sc.nextLine().charAt(0);
		
		for (int i=1;i<10;i++) {
		
			
			System.out.println("Introduce texto");
			letra = sc.nextLine().charAt(0);
			
			if(letra==primera)
				cont+=1;
			
		}
		
		System.out.println("se repite la primera letra "+cont);
		
	}

}
