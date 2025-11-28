package PracticasBucles1;

import java.util.Locale;
import java.util.Scanner;

public class practica14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Programa que lee un número y escribe todos los pares anteriores a él */

		int num;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		System.out.println("Numero?");
		num = sc.nextInt();

		num--;
		
		while (num > 0) {

			if(num%2==0) {
				System.out.println(num);}
			
			num++;

		}
		

	}

}
