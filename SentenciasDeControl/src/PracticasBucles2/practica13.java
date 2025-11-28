package PracticasBucles2;

import java.util.Locale;
import java.util.Scanner;

public class practica13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Programa que lee un número y escribe todos los anteriores a él*/
		
		int numero;
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		System.out.println("di un numero");
		numero = sc.nextInt();
	
		for(int i=0;i<numero;i+=1) {
			
			System.out.println(+i);
			
		}
	}
}
