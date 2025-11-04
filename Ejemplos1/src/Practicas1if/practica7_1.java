package Practicas1if;

import java.util.Scanner;

public class practica7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int temperatura;
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce una temperatura");
		temperatura=sc.nextInt();
		
		if(temperatura>30)
			System.out.println("natacion");
		
		else
			if (temperatura>20 && temperatura<=30)
				System.out.println("tenis");
			else
				if(temperatura>10 && temperatura<=20)
					System.out.println("golf");
				else
					if(temperatura>5 && temperatura<=10)
					System.out.println("esqui");
		
					else
						if(temperatura<=5)
						System.out.println("parchis");
	}
}
