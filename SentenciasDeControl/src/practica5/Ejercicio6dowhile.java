package practica5;

import java.util.Scanner;

public class Ejercicio6dowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduce número:");
			num = sc.nextInt();
			if (num != 0) {
				if (num % 2 == 0)
					System.out.println("Es par");
				else
					System.out.println("Es impar");
			}

		} while (num != 0);
		System.out.println("Finalizo porque has anotado cero");
	}

}
