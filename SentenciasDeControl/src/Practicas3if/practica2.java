package Practicas3if;

import java.util.Scanner;

public class practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int primero,segundo;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce primer numero");
		primero=sc.nextInt();
		
		System.out.println("introduce primer numero");
		segundo=sc.nextInt();
		
		if(primero>segundo)
			System.out.println("el mayor es "+primero);
		else
			System.out.println("el mayor es "+segundo);
			
	}

}
