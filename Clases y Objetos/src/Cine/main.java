package Cine;

import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		LinkedList<taquilla> cola = new LinkedList<taquilla>();
		int opc, entradas;
		String nombre;
		int entradasDispo = 5, entradasRest = 0;

		do {
			System.out.println("******************");
			System.out.println("*****TAQUILLA*****");
			System.out.println("******************");
			System.out.println("1. Llega un usuario");
			System.out.println("2. Comprar entradas");
			System.out.println("3. Usuario random abandona");
			System.out.println("0. Salir");
			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {

			case 1:
				System.out.println("nombre cliente");
				nombre = sc.nextLine();
				System.out.println("Numero de entradas");
				entradas = sc.nextInt();
				entradasRest = entradasDispo - entradas;
				cola.add(new taquilla(nombre, entradas));
				break;
			case 2:
				if (entradasRest > entradasDispo)
					System.out.println("no hay entradas suficientes");
				else
					cola.removeFirst();
				System.out.println("nombre cliente");
				nombre = sc.nextLine();
				System.out.println("Numero de entradas");
				entradas = sc.nextInt();
				cola.addLast(new taquilla(nombre, entradas));
				break;
			case 3:
				break;

			}
		} while (opc != 0);

	}

}
