package Bucles;

import java.util.Scanner;

public class practica18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Programa que lee una secuencia 5 números y escribe cual ha sido el mayor.*/
		
		
		int num,mayor=0;
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			
			System.out.println("numeros");
			num = sc.nextInt();
			
			if(num>mayor)
				mayor=num;
			
		}
		
		System.out.println(mayor);
		
	}

}
