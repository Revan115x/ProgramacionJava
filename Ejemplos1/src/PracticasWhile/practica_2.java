package PracticasWhile;

import java.util.Locale;
import java.util.Scanner;

public class practica_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leer números de teclado hasta que la suma de todos ellos sea mayor a 100, y
		 * decir si se ha anotado algún cero.
		 */

		
		int numero1,cont=0,M100=0;
		
		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		do{
			
			System.out.println("di un numero");
			numero1=sc.nextInt();
			
			M100+=numero1;
			
			if(numero1==00)
				cont++;
			
			System.out.println(M100);
			
		}while(M100<=100);
			
		System.out.println("SALES DEL BUCLE");
		
		System.out.println("has superado mayor de 100 un total de= "+M100);
		System.out.println("se ha repetido los ceros "+cont);
		
	}
	

}
