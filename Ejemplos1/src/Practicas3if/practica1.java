package Practicas3if;

import java.util.Scanner;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int primero,segundo;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce primer numero");
		primero=sc.nextInt();
		
		System.out.println("introduce primer numero");
		segundo=sc.nextInt();
		
		if (primero>0 && segundo>0)
			System.out.println("se suman " +(primero+segundo));
		else 
			if(primero<0 && segundo<0)
				System.out.println("se restan "+ (primero-segundo));
			else
				System.out.println("error");
	}

}
