package EjemplosClaseVariados;

import java.util.Scanner;

public class EjWhile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota un número positivo mayor de dos:");
		numero=sc.nextInt();
		
		while (numero<=2) {
			System.out.println("Número incorrecto.");
			System.out.println("Anota un número positivo mayor de dos:");
			numero=sc.nextInt();
		}
		// Llego a este punto del program si el número es >2
		System.out.println("Enhorabuena has anotado un número correcto");

	}

}
