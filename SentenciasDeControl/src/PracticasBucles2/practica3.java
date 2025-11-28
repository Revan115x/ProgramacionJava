package PracticasBucles2;

import java.util.Scanner;

public class practica3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num;

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un numero");
		num = sc.nextInt();
		
		while(num != 0) {
			if(num % 2 ==0)
				System.out.println("par");
			else
				System.out.println("impar");
				num=sc.nextInt();
		}
		System.out.println("fin");
	}
	}
