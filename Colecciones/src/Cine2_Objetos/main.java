package Cine2_Objetos;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		
		int opc, entradas;
		String nombre;
		Random usuario = new Random();
		cine cine = new cine();

		do {
			System.out.println("****************************");
			System.out.println("******   TAQUILLA  *********");
			System.out.println("****************************");
			System.out.println("1. Llega un usuario");
			System.out.println("2. Comprar entradas");
			System.out.println("3. Usuario random abandona");
			System.out.println("4. Lista de cola");
			System.out.println("0. Salir");
			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {

			case 1:
				System.out.println("nombre cliente");
				nombre = sc.nextLine();
				System.out.println("Numero de entradas");
				entradas = sc.nextInt();
				cine.llegarCola(nombre, entradas);
				break;
			case 2:
				cine.comprarEntradas();
				break;
			case 3:
				cine.dejarcola();
				break;
			case 4:
				cine.mostrarcola();
				break;
			}
		} while (opc != 0);

	}

}
