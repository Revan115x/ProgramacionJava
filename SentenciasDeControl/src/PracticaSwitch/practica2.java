package PracticaSwitch;

import java.util.Scanner;

public class practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Codificar un programa que simule el funcionamiento de una calculadora que
		 * puede realizar las cuatro operaciones aritméticas básicas (suma, resta,
		 * producto y división) con valores numéricos enteros. El usuario debe
		 * especificar la operación con el primer carácter: S o s para la suma, R o r
		 * para la resta, P, p, M o m para el producto y D o d para la división.
		 */

		int numero1, numero2;
		char letra;

		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el primer numero");
		numero1 = sc.nextInt();

		System.out.println("Dime el segundo numero");
		numero2 = sc.nextInt();

		sc.nextLine(); /* intruccion para limpiar,Obligatorio despues de leer un numero y quieres leer letra*/

		System.out.println("Dime una letra entre (s,r,p,d)");
		letra = sc.nextLine().charAt(0);/* sc.nextLine().charAt(0) siempre hay que ponerlo cuando queremos leer char */

		switch (letra) {
		case 's':
		case 'S':
			System.out.println(+numero1 + numero2);
			break;
		case 'r':
		case 'R':
			System.out.println(+numero1 - numero2);
			break;
		case 'p':
		case 'P':
			System.out.println(+numero1 * numero2);
			break;
		case 'd':
		case 'D':
			System.out.println(+numero1 / numero2);
			break;

		}
	}

}
