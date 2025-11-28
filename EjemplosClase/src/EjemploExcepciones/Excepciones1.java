package EjemploExcepciones;

import java.util.*;
public class Excepciones1 {
	
// Programa que lee dos n�meros y calcula su divisi�n.
// Controla mediante excepciones que no se anote un dato no num�rico
// y que no se divida por cero

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1=0,numero2=0,div=0;
		Scanner sc=new Scanner(System.in);
		boolean correcto=false;
		
		while(!correcto) {
		
			try {
				System.out.println("Anota primer numero:");
				numero1=sc.nextInt();
			
				correcto=true;
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Formato primer n�mero incorrecto");
				
			}
		}
		System.out.println("N�mero leido:"+numero1);
		
		correcto=false;	
		while(!correcto) {
				
				try {
					System.out.println("Anota segundo n�mero:");
					numero2=sc.nextInt();
				
					correcto=true;
				}catch(InputMismatchException e) {
					sc.nextLine();
					System.out.println("Formato segundo n�mero incorrecto");
					
				}
			
		}
		
		System.out.println("N�mero leido:"+numero2);
		
		try {
			div=numero1/numero2;
			System.out.println("La divisi�n es:"+div);
		}catch(ArithmeticException e) {
			System.out.println("No se puede dividir por cero");
		}
		
		
	}

}

