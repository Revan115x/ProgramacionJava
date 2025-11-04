package PracticasWhile;

import java.util.Locale;
import java.util.Scanner;

public class practica14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*14. Programa que lee un número y escribe todos los pares anteriores a él*/
		
		
		int numero,par=0;
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		System.out.println("di un numero");
		numero = sc.nextInt();
		
		for(int i=0 ; i<numero;i+=1) {
			
			if(i%2==0)
				System.out.println(+i);
				
		}
	}

}
