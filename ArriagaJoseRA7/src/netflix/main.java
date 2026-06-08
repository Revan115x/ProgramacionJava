package netflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opc;
		ArrayList<suscripcion> cuentas = new ArrayList<>();

		Random r = new Random();

		ArrayList<pelicula> peliculas = new ArrayList<>();
		suscripcion s = null;

		peliculas.add(new pelicula("POCOYO", 0));
		peliculas.add(new pelicula("Star wars", 0));
		peliculas.add(new pelicula("Scareface", 0));
		peliculas.add(new pelicula("X-MEN", 1));
		peliculas.add(new pelicula("LALA LAND", 1));

		do {
			System.out.println("1. ALTA NUEVA SUSCRIPCION");
			System.out.println("2. VER PELICULA");
			System.out.println("3. DESCONECTAR");
			System.out.println("4. COBRAR A LOS USUARIOS");
			System.out.println("5. SALIR");

			opc = sc.nextInt();

			sc.nextLine();
			switch (opc) {
			case 1:
				boolean encontrado = false;
				String mail;
				System.out.println("EMAIL");
				mail = sc.nextLine();
				for (suscripcion sub : cuentas) {
					if (sub.getMail().equalsIgnoreCase(mail)) {
						if (sub instanceof suscripcionPrime) {
							cuentas.remove(0);
							cuentas.add(new suscripcionStandard(sub.getMail(), sub.getPasswd()));
							System.out.println("SE CAMBIO LA CUENTA A STANDARD");
							encontrado = true;
						}
						if (sub instanceof suscripcionStandard) {
							cuentas.remove(0);
							cuentas.add(new suscripcionPrime(sub.getMail(), sub.getPasswd()));
							System.out.println("SE CAMBIO LA CUENTA A PRIME");
							encontrado = true;
						}
					}
				}
				if (encontrado == false) {
					int contraseña = r.nextInt(1000, 10000);
					System.out.println("DIME EL TIPO 1.Standard / 2. Prime");
					int tipo = sc.nextInt();
					switch (tipo) {
					case 1:
						cuentas.add(new suscripcionStandard(mail, contraseña));
						break;
					case 2:
						cuentas.add(new suscripcionPrime(mail, contraseña));
					}
				}

				for (suscripcion sub : cuentas) {
					System.out.println(sub.toString());
				}

				break;
			case 2:
				if (cuentas.size() == 0) {
					System.out.println("NO HAY USUARIOS");
				} else {
					suscripcion s1 = null;
					int cont = 0;
					boolean correcto = false;
					System.out.println("Introduce el Email");
					mail = sc.nextLine();
					do {
						System.out.println("Introduce contraseña");
						int pass = sc.nextInt();
						if (cont >= 3) {
							System.out.println("HAS AGOTADO TUS INTENTOS");
							break;
						}
						for (suscripcion sub : cuentas) {
							if (pass != sub.getPasswd()) {
								cont++;
							} else {
								correcto = true;
								s1 = sub;
							}
						}
					} while (!correcto);
					sc.nextLine();
					if (s1.verCaducado() == 1)
						break;
					if (s1.conexiones() == 1)
						break;
					s1.conectar();
					cont = 0;
					System.out.println("TITULO PELICULA");
					String titulo = sc.nextLine();
					pelicula p = null;

					for (pelicula peli : peliculas) {
						if (peli.getTitulo().equalsIgnoreCase(titulo)) {
							p = peli;
						}
					}
					if(p != null) {
					    s1.verPelicula(p.getCosto());
					}
				}
				break;
			case 3:
				System.out.println("Email");
				mail = sc.nextLine();
				for (suscripcion sub : cuentas) {
					if (sub.getMail().equalsIgnoreCase(mail)) {
						s = sub;
					}
				}
				s.desconectar();
				break;
			}
		} while (opc != 5);

	}

// LO HE INTENTADO :,,,(

}
