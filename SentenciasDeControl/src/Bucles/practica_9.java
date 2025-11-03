package Bucles;

import java.util.Locale;
import java.util.Scanner;

public class practica_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media,
		 * la cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden
		 * más de 1.75.
		 */

		int edad, edadMy = 0, edadMe = 0, sumedad = 0, alturaMy = 0;
		double altura, mediaAl = 0, sumaltura = 0;

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {

			System.out.println("Edad?");
			edad = sc.nextInt();

			sc.useLocale(Locale.ENGLISH);
			System.out.println("Altura?");
			altura = sc.nextDouble();

			if (edad > 18)
				edadMy++;

			if (altura > 1.75)
				alturaMy++;

			sumedad = edad + sumedad;

			sumaltura = altura + sumaltura;

			edadMe = sumedad / 5;

			mediaAl = sumaltura / 5;

		}

		System.out.println("Cantida Personas Mayores de 18 = " + edadMy);
		System.out.println("Cantida Personas Mayores de 1.75 = " + alturaMy);
		System.out.println("Edad media Personas  = " + edadMe);
		System.out.println("altura media Personas  = " + mediaAl);

	}

}
