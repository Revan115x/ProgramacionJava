package Marvel;

import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		LinkedList<personaje> personajes = new LinkedList<>();
		int opc;

		do {
			System.out.println("1. Alta de personaje");
			System.out.println("2. Registrar actividad");
			System.out.println("3. Incrementar nivel de poder");
			System.out.println("4. Mostrar información");
			System.out.println("5. Calcular pago");
			System.out.println("6. Batalla aleatoria");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1: {
				System.out.println("Nombre");
				String nombre = sc.nextLine();

				System.out.println("Universo");
				String Universo = sc.nextLine();

				System.out.println("Nivel Poder");
				double poder = sc.nextDouble();

				if (poder > 100 || poder < 0)
					break;

				System.out.println("1. HEROE / 2. VILLANO");
				int tipo = sc.nextInt();

				switch (tipo) {
				case 1:
					personajes.add(new Heroe(nombre, Universo, poder));
					break;
				case 2:
					personajes.add(new Villano(nombre, Universo, poder));
					break;
				}
				break;
			}
			case 2:
				System.out.println("IDENTIFICACION");
				String ident = sc.nextLine();

				for (personaje per : personajes) {
					if (ident.equalsIgnoreCase(per.identificador)) {
						if (per instanceof Heroe)
							((Heroe) per).misionCompleta();
						else
							((Villano) per).conquistarCiudad();
					}
				}
				break;
			case 3:
				System.out.println("IDENTIFICACION");
				ident = sc.nextLine();

				for (personaje per : personajes) {
					if (ident.equalsIgnoreCase(per.identificador)) {
						System.out.println("AUMENTAR NIVEL DE PODER");
						double incrementar = sc.nextDouble();
						if (incrementar > 100 || incrementar < 0)
							break;

						per.incrementarPoder(incrementar);

						System.out.println("PODER INCREMENTADO");

					}
				}
				break;
			case 4:
				for (personaje per : personajes) {
					System.out.println(per.toString());
				}
				break;
			case 5:
				for (personaje per : personajes) {
					System.out.println("El personaje" + per.getNombre());
					System.out.println("COBRO : " + per.pagarRecompensa());
				}
				break;

			}
		} while (opc != 7);

	}
}
