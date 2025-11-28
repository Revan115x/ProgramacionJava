package PracticasBucles2;

import java.util.Locale;
import java.util.Scanner;

public class practica17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Repetir el ejemplo del "simulador de calculadora" para poder realizar todas
		 * las operaciones que el usuario quiera.
		 */

		double num1, num2, operacion = 0;
		char tipo;
		boolean operar=true;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		System.out.println("Quieres operar");
		operar=sc.nextBoolean();

		if(operar==true)
		
		while (true) {
			
			System.out.println("Numero 1 para operar");
			num1 = sc.nextDouble();

			System.out.println("Numero 2 para operar");
			num2 = sc.nextDouble();
			
			System.out.println("Que tipo operacion quieres hacer?(s/r/m/d)");
			sc.nextLine();
			tipo = sc.nextLine().charAt(0); 
			
			switch (tipo) {
			case 's':
			case 'S':
				operacion = num1 + num2;
				break;
			case 'r':
			case 'R':
				operacion = num1 - num2;
				break;
			case 'm':
			case 'M':
				operacion = num1 * num2;
				break;
			case 'd':
			case 'D':
				operacion = num1 - num2;
				break;
			}
			
			System.out.println(operacion);

		}
		
		else
			System.out.println("Fin progrma");
			System.exit(0);
		
	}

}
