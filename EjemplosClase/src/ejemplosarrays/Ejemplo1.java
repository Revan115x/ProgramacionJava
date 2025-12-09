package ejemplosarrays;

import java.util.Locale;
import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double notas[] = new double[5];

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		System.out.println("Introduce 5 notas:");

		for (int i = 0; i < notas.length; i++) {
			System.out.println("nota " + i + ":");
			notas[i] = sc.nextDouble();
		}

		System.out.println("Aprobados:");
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= 5)
				System.out.println(notas[i]);
		}

		System.out.println("Suspensos:");
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < 5)
				System.out.println(notas[i]);
		}
		
	}

}
