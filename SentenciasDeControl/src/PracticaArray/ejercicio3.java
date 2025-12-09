package PracticaArray;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * El usuario dice cuántos números va a leer, a continuación leemos la cantidad
		 * de números indicada y los guardamos en un array. Decid cuántas veces se
		 * repite el último número.
		 */
		
		Scanner sc=new Scanner(System.in);
		int cadena = 0;
		int cont=0;
		int ultimo = 0;
		
		System.out.println("numero de la cadena");
		cadena=sc.nextInt();

		int num[]=new int[cadena];
		
		for(int i=0;i<num.length;i++) {
			System.out.println("intento "+i);
			num[i]=sc.nextInt();
			
			ultimo=num[4];
		}
		
		for(int i=0;i<num.length;i++) {
			
			if(num[i]==num[ultimo]) {
				cont++;
			}
			
		}
		
		System.out.println("La cantidad de veces que se repite es "+cont);
		
	}

}
