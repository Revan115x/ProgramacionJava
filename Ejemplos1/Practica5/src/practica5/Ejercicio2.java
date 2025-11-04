package practica5;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce número:");
		num=sc.nextInt();
		while (num!=0) {
			if (num>0)
				System.out.println("Es positivo");
			else
				System.out.println("Es negativo");
			System.out.println("Introduce número:");
			num=sc.nextInt();
		}
		
	}

}
