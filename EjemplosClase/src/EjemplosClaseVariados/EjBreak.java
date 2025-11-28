package EjemplosClaseVariados;

import java.util.Scanner;

// Leo números positivos, salgo cuando me anoten un número negativo o cero
// Además si me anotan el número -1 muestro un mensaje y salgo del bucle
// Al final digo cuántos números me han anotado.
public class EjBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, cont = 0;
		Scanner sc = new Scanner(System.in);
		/*
		 * System.out.println("Anota número"); num=sc.nextInt(); while(num>0) { cont++;
		 * System.out.println("Anota número"); num=sc.nextInt(); } if (num==-1)
		 * System.out.println("Has anotado un -1");
		 */
		do {
			System.out.println("Anota número");
			num = sc.nextInt();
			if (num <= 0) {

				if (num == -1)
					System.out.println("Has anotado un -1");

				break;
			}
			cont++;
		} while (num > 0);

		System.out.println("Total de números positivos:" + cont);

	}

}
