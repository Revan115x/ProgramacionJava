package EjemplosClaseVariados;

import java.util.Scanner;

// Tabla de multiplicar
public class Ejfor3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		/*
		 * Scanner sc = new Scanner(System.in); do {
		 * System.out.println("Anota número:"); num = sc.nextInt(); } while (num < 0 ||
		 * num > 10);
		 */
		for (num = 0; num <= 10; num++) {
			System.out.println("----- Tabla del "+num+"-----");
			for (int i = 0; i <= 10; i++)
				System.out.println(num + " * " + i + " = " + (num * i));
		}

	}

}
