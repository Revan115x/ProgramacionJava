package practica5;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce número:");
		num=sc.nextInt();
		while (num>=0) {
			System.out.println("El cuadrado es:"+ Math.pow(num, 2));
			System.out.println("Introduce número:");
			num=sc.nextInt();
		}
		
	}

}
