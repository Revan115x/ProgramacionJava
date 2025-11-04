package PracticasWhile;

import java.util.Scanner;

public class practica7_3 {
	
	public static void main(String[] args) {
		
		/*Programa que calcula el factorial de un número, éste no debe ser negativo*/
	
		int numero,fact=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Di un numero");
		numero=sc.nextInt();
		
		if(numero>0) {
			fact=factorial(numero);
			System.out.println(fact);
		}
	
	}
		
		public static int factorial(int num) {
			
			int acumulador =1;
			for(int i=1;i<=num;i++) {
				acumulador=acumulador*i;
		}
		return acumulador;
		
	}

}
