package Practicas1if;

import java.util.Scanner;

public class practica4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int horas;
		double salario;
		final double normal=15,extra=22;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("cuantas horas has trabajado?");
		horas=sc.nextInt();
		
		if(horas<=35)
			salario=horas*normal;
		else
			salario=35*normal+ (horas-35);
		System.out.println("salario es:" +salario);
	}

}
