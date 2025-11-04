package Practica1;

import java.util.Scanner;

public class practica7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int a,b,c;

	/*c=a;
	a=b;
	b=c;*/
	
	try (Scanner sc = new Scanner(System.in)) {
		System.out.print("Valor de a es? ");
		a=sc.nextInt();
		
		System.out.println("a es "+ a);
		
		System.out.print("Valor de b es? ");
		b=sc.nextInt();
	}
	System.out.println("b es ="+ b);
	
	c=a;
	a=b;
	b=c;
	
	System.out.println("el valor de a es= "+a+ " y b es= " +b);
	
	/*System.out.println("e);*/
	
	
	}
}
