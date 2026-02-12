package Cine.linkedList;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		LinkedList<Usuario> cola = new LinkedList<Usuario>();
		int opc, entradas;
		String nombre;
		Random usuario = new Random();

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
				cola.add(new Usuario(nombre, entradas));
				break;

			case 2:
				Usuario u = cola.removeFirst();
				if (u.comprar() == 0)
					System.out.println("NO HAY SUFICIENTES ENTRADAS");
				else {
					System.out.println("Entradas compradas");
				}
				if (Usuario.getEntradasGeneral() == 0) {
					System.out.println("Ya no quedan entradas");
					cola.clear();
					break;
				}
				break;

			case 3:
				if (cola.isEmpty())
					System.out.println("No hay nadie en cola");
				else {
					int colagetout = usuario.nextInt(cola.size());
					System.out.println(cola.get(colagetout).getNombre() + " abandonó la cola");
					cola.remove(colagetout);
				}
				break;

			case 4:
				if (cola.isEmpty())
					System.out.println("NO HAY NADIE EN COLA");
				else {
					for (int i = 0; i < cola.size(); i++) {
						if(cola.size()>1)
							System.out.println("***************************");
						System.out.println(cola.get(i).datosNombre());
					}
				}
				break;
			}
		} while (opc != 0);

	}

}
