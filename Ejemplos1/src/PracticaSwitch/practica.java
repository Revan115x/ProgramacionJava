package PracticaSwitch;

import java.util.Scanner;

public class practica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int dia;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce los dias que tiene el mes");
		dia=sc.nextInt();

		switch(dia) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(dia<1 || dia>31);
				System.out.println("dia incorrecto");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(dia<1 || dia>30);
				System.out.println("Dia incorrecto");
				break;
			case 2:
				if(dia<1 || dia >28);
				System.out.println("dia incorrecto");
				break;
				
		}
		
	}

}
