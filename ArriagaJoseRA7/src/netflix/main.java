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

		// peliculas
		peliculas.add(new pelicula("POCOYO", 0));
		peliculas.add(new pelicula("Star wars", 0));
		peliculas.add(new pelicula("Scareface", 0));
		peliculas.add(new pelicula("X-MEN", 1));
		peliculas.add(new pelicula("LALA LAND", 1));

		// Usuarios
		cuentas.add(new suscripcionStandard("Carlos", 5563));
		cuentas.add(new suscripcionStandard("luis", 5633));
		cuentas.add(new suscripcionPrime("Marcos", 5633));
		cuentas.add(new suscripcionPrime("Enrique", 5633));

		do {
			System.out.println("1. ALTA NUEVA SUSCRIPCION");
			System.out.println("2. VER PELICULA");
			System.out.println("3. DESCONECTAR");
			System.out.println("4. COBRAR A LOS USUARIOS");
			System.out.println("5. TOTALES");
			System.out.println("6. SALIR");

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
							cuentas.remove(sub);
							cuentas.add(new suscripcionStandard(sub.getMail(), sub.getPasswd()));
							System.out.println("SE CAMBIO LA CUENTA A STANDARD");
							encontrado = true;
						}
						if (sub instanceof suscripcionStandard) {
							cuentas.remove(sub);
							cuentas.add(new suscripcionPrime(sub.getMail(), sub.getPasswd()));
							System.out.println("SE CAMBIO LA CUENTA A PRIME");
							encontrado = true;
						}
					}
				}
				if (encontrado == false) {
					int contraseña = r.nextInt(999, 10000);
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
					for (suscripcion sub : cuentas) {
						if (mail.equalsIgnoreCase(sub.getMail())) {
							s1 = sub;
						}
					}

					if (s1 == null) {
						System.out.println("NO EXISTE ESE USUARIO");
						break;
					}

					while (!correcto && cont < 3) {

						System.out.println("Introduce contraseña");
						int pass = sc.nextInt();
						sc.nextLine();

						if (pass == s1.getPasswd()) {
							correcto = true;
						} else {
							cont++;
							System.out.println("CONTRASEÑA INCORRECTA");
						}
					}

					if (!correcto) {
						System.out.println("HAS AGOTADO TUS INTENTOS");
						break;
					}

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
					if (p != null) {
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
			case 4:
				ArrayList<suscripcion> borrar = new ArrayList<>();

				for (suscripcion sub : cuentas) {

					if (sub.verCaducado() == 1) {

						System.out.println("USUARIO: " + sub.getMail());
						System.out.println("SUSCRIPCION CADUCADA");

						System.out.println("1. RENOVAR");
						System.out.println("2. CANCELAR");

						int op = sc.nextInt();
						sc.nextLine();

						if (op == 1) {

							System.out.println("IMPORTE: " + sub.cobrarmensualidad());

							sub.renovar();

							System.out.println("SUSCRIPCION RENOVADA");

						} else {

							borrar.add(sub);

							System.out.println("SUSCRIPCION CANCELADA");
						}
					}
				}

				for (suscripcion sub : borrar) {
					cuentas.remove(sub);
				}
				break;
			case 5:
				System.out.println("Peliculas gratis: " + suscripcion.peliculasGratis);

				System.out.println("Peliculas de pago: " + suscripcion.peliculasPago);

				System.out.println("Total recaudado: " + suscripcion.totalRecaudado);
				
				break;
			}
		} while (opc != 5);

	}

// LO HE INTENTADO :,,,(

}
