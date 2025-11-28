package PracticasBucles2;

import java.util.Locale;
import java.util.Scanner;

public class practica9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media,
		 * la cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden
		 * más de 1.75.
		 */

		int edad, edmedia = 0, contH = 0, cont = 0, contA = 0, acumuladorEd = 0;
		double altura, almedia = 0, acumuladorAl = 0;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		for (int alumno = 0; alumno < 2; alumno++) {

			cont += 1;

			System.out.println("di tu edad");
			edad = sc.nextInt();

			System.out.println("di tu altura");
			altura = sc.nextDouble();

			acumuladorAl = altura + acumuladorAl;
			acumuladorEd = edad + acumuladorEd;

			if (edad >= 18)
				contH += 1;
			if (altura >= 1.75)
				contA += 1;

			edmedia = acumuladorEd / cont;

			almedia = acumuladorAl / cont;

		}

		System.out.println("Personas mayores de edad =" + contH);
		System.out.println("mayores de 1.75 =" + contA);
		System.out.println("la edad media es de =" + edmedia);
		System.out.println("la altura media es de=" + almedia);

	}

}
