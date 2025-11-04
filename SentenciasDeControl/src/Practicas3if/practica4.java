package Practicas3if;

import java.util.Scanner;

public class practica4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int primero,segundo,tercero;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce primer numero");
		primero=sc.nextInt();
		
		System.out.println("introduce primer numero");
		segundo=sc.nextInt();
		
		System.out.println("introduce primer numero");
		tercero=sc.nextInt();
		
		if(primero==segundo || segundo==tercero || primero==tercero)
			System.out.println("no se pueden repetir");
		else
			if(primero>segundo && primero>tercero)
				System.out.println("mayor es"+primero);
			else
				if(segundo>tercero && segundo>primero)
				System.out.println("mayor es"+segundo);
				else
					if(tercero>segundo && tercero>primero)
						System.out.println("mayor es"+tercero);
	}

}
