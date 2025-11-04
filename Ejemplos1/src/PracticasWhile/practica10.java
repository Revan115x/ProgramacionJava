package PracticasWhile;

import java.util.Locale;
import java.util.Scanner;

public class practica10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee una secuencia de notas (0 – 10) terminada al introducir –1 y
		 * cuenta el no de suspensos, aprobados, notables y sobresalientes. Validar que
		 * las notas introducidas sean correctas.
		 */

		int contSuspensos = 0, contAprobados = 0, contNotables = 0, contSobresalientes = 0, cont = 0;
		double nota = 0;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		for (int alumno = 0; alumno < 3; alumno += 1) {

			System.out.println("nota");
			nota = sc.nextInt();

			cont += 1;

			if (nota >= 0 && nota <= 4) {
				contSuspensos += 1;
				System.out.println("suspenso");
				break;
			}else if (nota >= 5 && nota <= 7) {
				contAprobados += 1;
				System.out.println("aprobado");
				break;
			}else if (nota >= 8 && nota <= 9) {
				contNotables += 1;
				System.out.println("notable");
				break;
			}
			if (nota >= 10) {
				contSobresalientes += 1;
				System.out.println("sobresalientes");
				break;
			}

		}

		System.out.println("los suspensos son" + contSuspensos);
		System.out.println("los aprobados son" + contAprobados);
		System.out.println("los notables son" + contNotables);
		System.out.println("los sobresalientes son" + contSobresalientes);

	}
}
