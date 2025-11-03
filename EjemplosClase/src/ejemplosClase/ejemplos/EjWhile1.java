package ejemplosClase.ejemplos;

import java.util.Scanner;

public class EjWhile1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero,n=2;
		
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
		
		while(n<=numero) {
			System.out.println(n);
			n=n+2;
		}

	}

}
