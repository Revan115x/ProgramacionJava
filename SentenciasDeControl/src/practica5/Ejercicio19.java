package practica5;

import java.util.Scanner;

/*
 * Programa que lea dos números enteros y muestre por pantalla todos los números
comprendidos entre esos dos, ambos incluidos. El programa no debe suponer que
el primero será menor que el segundo ni viceversa, pero sí deberá tenerlo en
cuenta para mostrar los números en orden creciente o decreciente según
corresponda.
 */
public class Ejercicio19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1, n2;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Anota primer número:");
			n1 = sc.nextInt();
			System.out.println("Anota segundo número:");
			n2 = sc.nextInt();
			if (n1 == n2)
				System.out.println("Error no pueden ser iguales");
		} while (n1 == n2);

		if (n1 < n2) {
			for (int i = n1; i <= n2; i++)
				System.out.println(i);
		} else {
			for (int i = n1; i >= n2; i--)
				System.out.println(i);
		}
	}

}
