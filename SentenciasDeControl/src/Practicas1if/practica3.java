package Practicas1if;

import java.util.Scanner;

public class practica3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int primero,segundo;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("dime un numero");
		primero=sc.nextInt();
		
		System.out.println("dime otro numero");
		segundo=sc.nextInt();
		
		if(primero==segundo)
			System.out.println("son iguales");
		else {
			System.out.println("no son iguales");
		}
	}

}
