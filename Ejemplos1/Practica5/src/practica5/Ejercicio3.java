package practica5;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce número:");
		num=sc.nextInt();
		while (num!=0) {
			if (num%2==0)
				System.out.println("Es par");
			else
				System.out.println("Es impar");
			System.out.println("Introduce número:");
			num=sc.nextInt();
		}
		
	}

}
