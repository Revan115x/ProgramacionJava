package PracticasWhile;

import java.util.Scanner;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("dime un numero");
		num= sc.nextInt();
		
		while(num>=0) {
			num=num*num;
			System.out.println(num);
			num= sc.nextInt();
		}
	
	System.out.println("todo bien");
		
	}

}
