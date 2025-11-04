package practica5;

import java.util.Scanner;

public class Ejerccio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner sc=new Scanner(System.in);
		/*
		do {
			System.out.println("Introduce número (0-10):");
			num=sc.nextInt();
			if (num<0 || num>10)
				System.out.println("Número incorrecto");
		}while(num<0 || num>10);
		*/
		
		System.out.println("Introduce número (0-10):");
		num=sc.nextInt();
		
		while(num<0 || num>10) {
			System.out.println("Número incorrecto");
			System.out.println("Introduce número (0-10):");
			num=sc.nextInt();
		}
		
		for(int i=0;i<=10;i++)
			System.out.println(num + " * "+ i +"=" + num*i);

	}

}
