package EjemplosClaseVariados;

import java.util.Locale;
import java.util.Scanner;

public class ejDowhile3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Leo una nota de teclado hasta que sea correcta
		double nota;
		
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		/*
		do {
			System.out.println("Anota calificación:");
			nota=sc.nextDouble();
			if (nota<0 || nota>10)
				System.out.println("Nota incorrecta");
			
		}while(nota<0 || nota>10);
		//Salgo cuando la nota es correcta
		// nota>=0 && nota<=10
		 * 
		 */
		
		System.out.println("Anota calificación:");
		nota=sc.nextDouble();
		while(nota<0 || nota>10) {
			System.out.println("Nota incorrecta");
			System.out.println("Anota calificación:");
			nota=sc.nextDouble();
		}
		
		System.out.println("Has introducido bien la nota");

	}

}
