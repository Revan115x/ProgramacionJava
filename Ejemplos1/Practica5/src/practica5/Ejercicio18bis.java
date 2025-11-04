package practica5;

import java.util.Scanner;

//Programa que lee una secuencia 5 números y escribe cual ha sido el mayor.
public class Ejercicio18bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int mayor=0;
		Scanner sc=new Scanner(System.in);
		
		for(int i=1;i<=5;i++) {
			System.out.println("Anota número:");
			num=sc.nextInt();
			if (i==1)
				mayor=num;
			else
				if (num>mayor)
					mayor=num;
		}
		
		System.out.println("El número mayor es:"+mayor);
		

	}

}
