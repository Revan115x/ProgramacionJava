package clasesMathyCharacter;

import java.util.Scanner;

public class ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char caracter,resultado;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un caracter:");
		caracter=sc.nextLine().charAt(0);
		
		resultado=Character.toUpperCase(caracter);
		System.out.println("En mayúsculas es:"+ resultado);
		
		if (Character.isAlphabetic(caracter))
			System.out.println("Es una letra");
		else
			System.out.println("No es una letra");
		
		if (Character.isLowerCase(caracter))
			System.out.println("La letra está en minúscula");
		else
			System.out.println("No está en minúscula");
		
	}

}
