package clasesMathyCharacter;

import java.util.Locale;
import java.util.Scanner;

public class ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double numero,resultado;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota un número:");
		sc.useLocale(Locale.ENGLISH);
		numero=sc.nextDouble();
		
		System.out.println("El valor del número e es:"+Math.E);
		System.out.println("El valor de PI ES:"+Math.PI);
		
		resultado=Math.pow(numero, 2);
		System.out.println("Al cuadrado es:"+resultado);
		
		resultado=Math.round(numero);
		System.out.println("Redondeado es:"+resultado);
		
		/*Número aleatorio entero entre el 1 y numero*/
		resultado=Math.floor(Math.random()*numero)+1;
		System.out.println("aleatorio:"+ resultado);
		
		
		
		System.out.println("floor:"+Math.floor(numero));
		System.out.println("ceil:"+Math.ceil(numero));
		
		
	}

}
