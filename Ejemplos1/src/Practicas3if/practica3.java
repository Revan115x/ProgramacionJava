package Practicas3if;

import java.util.Scanner;

public class practica3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int primero,segundo;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce primer numero");
		primero=sc.nextInt();
		
		System.out.println("introduce primer numero");
		segundo=sc.nextInt();
		
		if(primero>segundo)
			System.out.println("el orden es "+primero+ " "+segundo);
		else
			System.out.println("el orden es "+segundo+ " "+primero);
	}

}
