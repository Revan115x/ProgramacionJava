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
				/*for (suscripcion sub : cuentas) {
					if (sub.getMail().equalsIgnoreCase(mail)) {
						encontrado = true;
					}
				}*/

				int contraseña = r.nextInt(1001, 9999);
				System.out.println("DIME EL TIPO 1.Standard / 2. Prime");
				int tipo = sc.nextInt();
				switch (tipo) {
				case 1:
					cuentas.add(new suscripcionStandard(mail, contraseña));
					break;
				case 2:
					cuentas.add(new suscripcionPrime(mail, contraseña));
				}
				break;
			case 2:
				boolean bien = false;
				int cont = 0;
				do {
					System.out.println("Email");
					mail = sc.nextLine();
					//ME DA ERROR PORQUE REGRISTRA EL OTRO USUARIO TAMBIEN -_-
					for (suscripcion sub : cuentas) {
						if (sub.getMail().equalsIgnoreCase(mail)) {
							s = sub;
							bien = true;
						}
						cont++;
					}
				} while (!bien || cont > 3);

				if (s.conexiones() == 1) {
					System.out.println("MUCHAS CONEXIONES");
					break;
				} else {
					if (s.caducado == 1) {
						System.out.println("suscripcion caducada");
						break;
					}

					System.out.println("Titulo pelicula");
					String titulo = sc.nextLine();
					pelicula p = null;
					double pago=0;

					for (pelicula pl : peliculas) {
						if (titulo.equalsIgnoreCase(pl.getTitulo()))
							p = pl;
					}
					for (suscripcion sub : cuentas) {
						if (p.getCosto() == 0) {
							sub.conectar();
							pago = sub.verPelicula(p.getCosto());
							System.out.println(pago);
						} else {
							if  (p.getCosto() == 1) {
								sub.conectar();
								pago = sub.verPelicula(p.getCosto());
								System.out.println(pago);
							}

						}
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
	
	//LO HE INTENTADO :,,,(

}
