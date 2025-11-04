package practica5;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, suma=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un número (cero para terminar):");
		num=sc.nextInt();
		
		while(num!=0) {
			suma=suma+num;
			System.out.println("Introduce un número (cero para terminar):");
			num=sc.nextInt();
		}
		
		System.out.println("La suma es:"+suma);
		
	}

}
