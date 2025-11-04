package Examenes;

import java.util.Scanner;

public class examen2022funcionesbien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int aforo = 80, grupo, barralibre = 0, doscopas, totalreservas = 0, total = 0, totalbarra = 0;
		String tipo;
		boolean correcto, tienecarnet, otra;
		double preciogrupo = 0, ganancias = 0;
		String carnet=null;

		Scanner sc = new Scanner(System.in);

		do {
			/*inicializo variables para una noche*/
			aforo=80;
			totalreservas=total=totalbarra=0;

			System.out.println("total aforo " + aforo);
			System.out.println("anota numero de comensales");
			grupo = sc.nextInt();
			while (grupo != -1 && aforo != 0) {
				if (grupo < 0 || aforo - grupo < 0) {
					System.out.println("numero incorrecto de comensales");
				} else {
					sc.nextLine();
					do {
						System.out.println("introduce tipo de menu : (Eco/Deg/Star)");
						tipo = sc.nextLine();
						tipo = tipo.toUpperCase();
						correcto = validarmenu(tipo);
					} while (!correcto);
					do {
						System.out.println("cuantas personas quieren 2 copas?");
						doscopas = sc.nextInt();
						System.out.println("cuantas personas quieren barra libre");
						barralibre = sc.nextInt();
						if (grupo < doscopas + barralibre)
							System.out.println("no hay tantos comensales");
						if (doscopas <= 0 || barralibre <= 0)
							System.out.println("ñas camtodades deben ser positivas");
					} while (grupo < doscopas + barralibre || doscopas < 0 || barralibre < 0);
					/* salida grupo>=doscopas+barralibre && doscopas>=0 && barralibre>=0 */
					preciogrupo = calcularprecio(grupo, tipo, doscopas, barralibre);
					System.out.println("tienes carnet de socio?");
					tienecarnet = sc.nextBoolean();
					if (validarcarnet(carnet)) {
						System.out.println("tiene descuento del 20%");
						preciogrupo = preciogrupo * 0.8;
					}
				}
				System.out.println("el precio de su reserva es " + preciogrupo);
				System.out.println("confirma la reserva(true/false)");
				boolean confirmar = sc.nextBoolean();
				if (confirmar) {
					aforo = aforo - grupo;
					totalreservas++;
					ganancias += preciogrupo;
					total += grupo;
					totalbarra += barralibre;
				}

			}
			System.out.println("quedan" + aforo + " plazas libres");
			if (aforo > 0) {
				System.out.println("numero incorrecto de comensales");
				grupo = sc.nextInt();
			}

			System.out.println("total ganancias" + ganancias);
			System.out.println("total reservas" + totalreservas);
			System.out.println("porcentaje barra libre:" + ((double) (totalbarra / total)) * 100 + "%");

			System.out.println("quiere gestionar la reservas ");
			otra = sc.nextBoolean();
		} while (otra);
	}

	public static boolean validarmenu(String tipo) {

		if (tipo.equals("eco") || tipo.equals("deg") || tipo.equals("star"))
			return true;
		return false;

	}

	public static double calcularprecio(int grupo, String tipo, int doscopas, int barralibre) {

		final double MECO = 25, MDEG = 35, MSTAR = 50, pdos = 9, plibre = 30;
		double precio;

		if (tipo.equalsIgnoreCase("ECO"))
			precio = MECO;
		else if (tipo.equalsIgnoreCase("DEG"))
			precio = MDEG;
		else
			precio = MSTAR;

		precio = precio * grupo + pdos * doscopas + plibre * barralibre;

		return precio;

	}

	public static boolean validarcarnet(String carnet) {

		if (carnet.length() != 4 && carnet.length() != 5)
			return false;
		char letra = carnet.charAt(0);
		if (letra >= 'A' && letra <= 'Z') {
			for (int i = 1; i < carnet.length(); i++)
				if (carnet.charAt(i) < '0' || carnet.charAt(i) > '9')
					return false;
		}
		return true;

	}
}
