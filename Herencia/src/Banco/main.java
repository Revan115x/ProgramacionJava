package Banco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*En un banco existen cuentas de dos tipos: la normal y el cuentón. Una cuenta
		normal tiene un interés del 3% mientras que en un cuentón es del 4%. Mientras
		que una cuenta normal se puede abrir con cualquier cantidad de dinero, un
		cuentón se tiene que abrir con al menos 600 euros. Cada cuenta tiene un número
		único que le es asignado por el banco en el momento de abrirla. Además cada
		cuenta puede tener varios titulares (máximo 3), que vienen identificados por su nif.
		Codificar un programa usando herencia que mantenga un linkedList de cuentas en
		el que se puedan hacer las siguientes operaciones:
		a) Dar de alta una cuenta.
		b) Cancelar (borrar) todas las cuentas en las que figure un titular anotado por
		teclado.
		c) Al anotar un número de días, nos muestre la información de todas las cuentas,
		incluido el dinero que han producido.
		Ejemplo: Si una cuenta tiene un capital de 400 euros y se le aplica un
		interés del 3% durante 30 días, el dinero producido es:(400 * 3 * 30) / 365.
		d) Sortee un viaje entre todos los cuentones abiertos.*/
		
		
		
		Scanner sc = new Scanner(System.in);
		int opc;
		String nif;
		double dinero = 0;
		HashSet<String> titulares = new HashSet<>();
		ArrayList<Cuenta> cuentas = new ArrayList<>();

		do {
			System.out.println("1. ALTA NUEVA CUENTA");
			System.out.println("2. BORRAR CUENTA POR TITULAR");
			System.out.println("3. DINERO PRODUCIDO POR CUENTA");
			System.out.println("4. SORTEO DE VIAJE");
			System.out.println("5. SALIR");

			opc = sc.nextInt();

			sc.nextLine();
			switch (opc) {
			case 1:
				titulares.clear();
				boolean seguir = true;

				while (seguir && titulares.size() < 3) {

					System.out.println("NIF DE TITULAR:");
					nif = sc.nextLine();
					titulares.add(nif);

					if (titulares.size() < 3) {

						System.out.println("¿Quiere añadir otro titular? (S/N)");
						String respuesta = sc.nextLine();

						if (!respuesta.equalsIgnoreCase("S")) {
							seguir = false;
						}
					} else {
						System.out.println("Límite de 3 titulares alcanzado.");
					}
				}

				do {
					System.out.println("CANTIDAD MONETARIA PARA ABRIR CUENTA:");
					dinero = sc.nextDouble();
					sc.nextLine();

				} while (dinero < 0);

				System.out.println("Que tipo de cuenta es 1.Cuenta Normal/ 2. Cuenton");
				int tipo = sc.nextInt();

				if (tipo == 1) {
					cuentas.add(new cuentaNormal(titulares, dinero));
				} else {
					if (dinero >= 600)
						cuentas.add(new cuentaCuenton(titulares, dinero));
					else
						System.out.println("Para abrir cuento debes de ingresar 600 o mas");
				}

				System.out.println(cuentas.toString());
				break;
			case 2:
				System.out.println("DIME EL NIF DEL TITULAR");
				nif = sc.nextLine();
				int borrar = borrarCuenta(cuentas, nif);

				if (borrar == 0)
					System.out.println("No hay titular asociado");
				else
					System.out.println("Titular borrado");

				break;
			case 3:
				System.out.println("DIME EL NUMERO DE DIAS");
				int dias = sc.nextInt();

				for (Cuenta c : cuentas) {
					System.out.println("La Cuenta " + c.getNumIdent());

					System.out.println("Ha generado" + c.calcularGanancia(dias));
				}

				break;
			case 4:
				ArrayList<Cuenta> cuentones = new ArrayList<>();

				for (Cuenta c : cuentas) {

					if (c instanceof cuentaCuenton) {
						cuentones.add(c);
					}
				}

				if (cuentones.isEmpty()) {

					System.out.println("No hay cuentones para realizar el sorteo.");

				} else {

					Random r = new Random();

					int ganador = r.nextInt(cuentones.size());

					System.out.println("El ganador del viaje es:");
					System.out.println(cuentones.get(ganador));
				}
				break;
			}
		} while (opc != 5);

	}

	public static int borrarCuenta(ArrayList<Cuenta> cuentas, String nif) {

		int cont = 0;

		ListIterator<Cuenta> it = cuentas.listIterator();
		while (it.hasNext()) {

			Cuenta c = it.next();

			if (c.getTitulares().contains(nif)) {
				it.remove();
				cont++;
			}
		}
		return cont;

	}

}
