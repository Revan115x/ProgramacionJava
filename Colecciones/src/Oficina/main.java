package Oficina;

import java.util.LinkedList;
import java.util.Scanner;

import Cine.LinkedList.Usuario;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String nombre, apellido, destinatario, ciudad, pais;
		int opc;
		
		LinkedList<Carta> Correos = new LinkedList<Carta>();

		do {
			System.out.println("╔══════════════════════════════╗");
			System.out.println("║        📬 MENU CORREOS        ║");
			System.out.println("╠══════════════════════════════╣");
			System.out.println("║ 1 Guardar Carta Ordenada     ║");
			System.out.println("║ 2️  Clasificar Cartas         ║");
			System.out.println("║ 3️  Mostrar Colecciones       ║");
			System.out.println("║ 0️  Salir                     ║");
			System.out.println("╚══════════════════════════════╝");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;

			default:
				System.out.println("SOLO SE PERMITEN OPCIONES DEL MENU");
				break;
			}
		} while (opc!=0);
		System.out.println("HAS SALIDO DEL PROGRAMA");
	}
}
