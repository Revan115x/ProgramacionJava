package practica5;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int suma=0; //Variable de tipo acumulador
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce número:");
		num=sc.nextInt();
		while (num!=0) {
		    suma = suma + num;
			System.out.println("Introduce número:");
			num=sc.nextInt();
		}
		System.out.println("La suma total es:"+suma);
		
	}

}
