package PracticasWhile;

import java.util.Scanner;

public class Practica4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num,num2=0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un numero");
		num = sc.nextInt();
		
		while(num > 0) {
			num2++;
			System.out.println("otra vez");
			num = sc.nextInt();
		}
		System.out.println(num2);
	}

}
