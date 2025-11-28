package PracticasBucles2;

import java.util.Scanner;

public class practica11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee 100 números y cuenta cuantos han sido pares, cuantos impares
		 * y cuantos nulos
		 */

		
		int numero,contpar=0,contImpar=0,contnulo=0;
		
		Scanner sc = new Scanner(System.in);

		
		for(int i=0; i<3;i+=1) {
			
			System.out.println("di un numero");
			numero = sc.nextInt();
			
			if(numero%2==0) 
				contpar+=1;
			else if(numero%3==0)
				contImpar+=1;
			else {
				contnulo+=1;
				System.out.println("nada");}
		}
		
		System.out.println("numero de par " +contpar);
		System.out.println("numero de parImpar " +contImpar);
		System.out.println("numero de nulo " +contnulo);
	}

}
