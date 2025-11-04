package Practica1;

import java.util.Locale;
import java.util.Scanner;

public class Practica41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final double PI=3.1416;
		double radio,resultado;
		
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		System.out.println("introduce eñ radio");
		radio=sc.nextDouble();
		
		resultado= radio * 2 * PI;
		
		System.out.println("la longitud es de "+resultado);
		

	}

}
