package Marvel;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		LinkedList<personaje> personajes = new LinkedList<>();
		int opc;
		Random r = new Random();
		String ident;

		personajes.add(new Heroe("SPIDER-MAN", 20));
		personajes.add(new Heroe("IRON MAN", 15));
		personajes.add(new Villano("DR DOOM", 25));
		personajes.add(new Villano("GALACTUS", 30));

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

				System.out.println("Nivel Poder");
				int poder = sc.nextInt();

				System.out.println("1. HEROE / 2. VILLANO");
				int tipo = sc.nextInt();

				switch (tipo) {
				case 1:
					personajes.add(new Heroe(nombre, poder));
					break;
				case 2:
					personajes.add(new Villano(nombre, poder));
					break;
				}
				break;
			}
			case 2:
				if (personajes.size() == 0) {
					System.out.println("No hay personajes");
				} else {
					System.out.println("IDENTIFICACION");
					ident = sc.nextLine();

					for (personaje per : personajes) {
						if (ident.equalsIgnoreCase(per.identificador)) {
							personaje p = per;
							if (p instanceof Heroe)
								((Heroe) p).misionCompleta();
							else
								((Villano) p).conquistarCiudad();
						}
					}
				}
				break;
			case 3:
				if (personajes.size() == 0) {
					System.out.println("No hay personajes");
				} else {
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
				}
				break;
			case 4:
				if (personajes.size() == 0) {
					System.out.println("No hay personajes");
				} else {
					for (personaje per : personajes) {
						System.out.println(per.toString());
					}
				}
				break;
			case 5:
				if (personajes.size() == 0) {
					System.out.println("No hay personajes");
				} else {
					for (personaje per : personajes) {
						System.out.println("El personaje" + per.getNombre());
						System.out.println("COBRO : " + per.pagarRecompensa());
					}
				}
				break;
			case 6:
				if (personajes.size() == 0) {
					System.out.println("No hay personajes");
				} else {
					int rondas=0;
					int cont = 1;
					personaje GANADOR = null;
					for (personaje per : personajes) {
						System.out.println(cont + " PERSONAJE : " + per.getNombre());
						System.out.println("NIVEL DE PODER : " + per.getNivelPoder());
						cont++;
					}

					System.out.println("Elige personaje");
					int elige = sc.nextInt();

					elige--;

					personaje p1 = personajes.get(elige);

					System.out.println("HAZ SELECCIONADO A " + p1.getNombre());

					int num = r.nextInt(personajes.size());

					personaje p2 = personajes.get(num);

					System.out.println("********************************************");
					System.out.println(p1.getNombre() + " VS " + p2.getNombre());
					System.out.println("********************************************");

					boolean victoria = false;

					while (!victoria) {

						int hp = 0;
						int poder = 0;
						int total;
						
						rondas++;
						
						System.out.println("********************************************");
						System.out.println("ROUND "+rondas);
						System.out.println("********************************************");
						
						System.out.println(p1.getNombre());
						System.out.println("HP " + p1.nivelVida + "\n");

						System.out.println(p2.getNombre());
						System.out.println("HP " + p2.nivelVida + "\n");

						System.out.println("Eliege tipo de ataque");
						System.out.println("1. ATAQUE NORMAL");
						System.out.println("2. ATAQUE ESPECIAL");
						int ataque = sc.nextInt();

						switch (ataque) {
						case 1:
							poder = p1.ataqueNormal();
							break;
						case 2:
							poder = p1.ataqueEspecial();
							break;
						}

						System.out.println("ataque es de " + poder);

						p2.actualizarVida(poder);

						System.out.println("vida restante de " + p2.getNombre() + " : " + p2.nivelVida);

						if (p2.nivelVida <= 0) {
							victoria = true;
							GANADOR = p1;
						}
						
						System.out.println("********************************************");
						System.out.println("Turno de la maquina");
						System.out.println("********************************************");

						System.out.println(p2.getNombre());
						System.out.println("HP " + p1.nivelVida);

						System.out.println(p2.getNombre());
						System.out.println("HP " + p2.nivelVida);

						ataque = r.nextInt(0, 2);

						switch (ataque) {

						case 1:
							poder = p2.ataqueNormal();
							break;
						case 2:
							poder = p2.ataqueEspecial();
							break;
						}

						System.out.println("ataque es de " + poder);

						p1.actualizarVida(poder);

						System.out.println("vida restante de " + p1.getNombre() + " : " + p1.nivelVida);

						if (p1.nivelVida <= 0) {
							victoria = true;
							GANADOR=p2;
						}

					}

					System.out.println("-----------------------------------------");
					System.out.println("EL GANADOR HA SIDO = "+GANADOR.getNombre());
					System.out.println("-----------------------------------------");
				}
				break;
			}
		} while (opc != 7);

	}
}
