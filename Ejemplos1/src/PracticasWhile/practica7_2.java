package PracticasWhile;

import java.util.Scanner;

public class practica7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que determina cuantas cifras tiene un número. Utilizar un método que
		 * recibe el números y nos retorna la cantidad de cifras que tiene
		 */

		int numero, digito;

		Scanner sc = new Scanner(System.in);
		System.out.println("numero");
		numero = sc.nextInt();

		digito = calculardigitos(numero);
		System.out.println("Tiene " + digito + " digitos");

	}

	public static int calculardigitos(int num) {

		int cont = 0;
		while (num > 0) {
			num = num / 10;
			cont++;
		}
		return cont;

	}

}
