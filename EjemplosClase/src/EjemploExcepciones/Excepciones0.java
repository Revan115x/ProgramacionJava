package EjemploExcepciones;

import java.util.*;
public class Excepciones0 {
	
// Programa que lee dos n��meros y calcula su divisi�n sin tener en cuenta las excepciones


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1=0,numero2=0,div=0;
		Scanner sc=new Scanner(System.in);
		boolean correcto=false;
		
		System.out.println("Anota primer numero:");
		numero1=sc.nextInt();
			
		
		System.out.println("N�mero leido:"+numero1);
		
		
		System.out.println("Anota segundo n�mero:");
		numero2=sc.nextInt();
				
		
		System.out.println("N�mero leido:"+numero2);
		
		div=numero1/numero2;
		System.out.println("La divisi�n es:"+div);
		
		
		
	}

}

