package tarjetas;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import bbdd.*;
import modelos.Cuenta;
import modelos.Movimiento;
import modelos.Tarjeta;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opc = 0;
		int numTarjeta;

		BD_Tarjetas bd = new BD_Tarjetas("mysql-properties.xml");

		do {
			System.out.println("\n\nGESTIÓN COLEGIO");
			System.out.println("***************");
			System.out.println("1. Dar de alta tarjeta de crédito");
			System.out.println("2. Dar de alta tarjeta de débito");
			System.out.println("3. Sacar dinero de una tarjeta de débito.");
			System.out.println("4. Sacar dinero de una tarjeta de crédito. ");
			System.out.println("5.");
			System.out.println("6.");
			System.out.println("7.");
			System.out.println("8. Alta movimiento");
			System.out.println("9.");
			System.out.println("10. ");
			System.out.print("\tTeclea opción: ");
			try {
				opc = sc.nextInt();
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir número 1-5");
				opc = 0;
			}

			sc.nextLine();
			switch (opc) {
			case 1:
				System.out.println("Anota el dni: ");
				String dni = sc.nextLine();
				ArrayList<Cuenta> cuentas;
				try {
					cuentas = bd.mostrarCuentas(dni);
					int i = 0;
					for (Cuenta c : cuentas) {
						i++;
						System.out.println(i + ". " + c.toString());
					}
					if (cuentas.size() == 0)
						System.out.println("No hay ninguna titular con este titular");
					else {
						int num;
						do {
							System.out.println("Elige la cuenta introduciendo su posicion: ");
							num = sc.nextInt();
						} while (num > cuentas.size() || num <= 0);

						num--;

						Cuenta c = cuentas.get(num);

						System.out.println("numero de la tarjeta: ej: 5555");
						numTarjeta = sc.nextInt();

						sc.nextLine();
						System.out.println("Introduce el titular: ");
						String titular = sc.nextLine();

						System.out.println("Introduce el límite: ");
						double limite = sc.nextDouble();

						sc.nextLine();
						System.out.println("Su clave: ");
						String clave = sc.nextLine();

						int filas = bd.añadir_Tarjeta(new Tarjeta(numTarjeta, c.getNumero(), titular, limite, clave));

						switch (filas) {
						case 1:
							System.out.println("Tarjeta añadida correctamente");
							break;
						case 0:
							System.out.println("No añadida, contacte con sistemas");
							break;
						}

					}
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");

				}
				break;

			case 2:
				System.out.println("Anota el dni: ");
				dni = sc.nextLine();
				try {
					cuentas = bd.mostrarCuentas(dni);
					int i = 0;
					for (Cuenta c : cuentas) {
						i++;
						System.out.println(i + ". " + c.toString());
					}
					if (cuentas.size() == 0)
						System.out.println("No hay ninguna titular con este titular");
					else {
						int num;
						do {
							System.out.println("Elige la cuenta introduciendo su posicion: ");
							num = sc.nextInt();
						} while (num > cuentas.size() || num <= 0);

						num--;

						Cuenta c = cuentas.get(num);

						numTarjeta = bd.Maximocuenta() + 1;

						sc.nextLine();
						System.out.println("Introduce el titular: ");
						String titular = sc.nextLine();

						System.out.println("Su clave: ");
						String clave = sc.nextLine();

						int filas = bd.añadir_Tarjeta(new Tarjeta(numTarjeta, c.getNumero(), titular, clave));

						switch (filas) {
						case 1:
							System.out.println("Tarjeta añadida correctamente");
							break;
						case 0:
							System.out.println("No añadida, contacte con sistemas");
							break;
						}

					}
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");

				}
				break;
			case 3:
				System.out.println(" NUMERO DE TARJETA");
				numTarjeta = sc.nextInt();
				sc.nextLine();
				try {
					ArrayList<Tarjeta> tarjetas;
					tarjetas = bd.MostrarTarjeta(numTarjeta);

					if (tarjetas.size() == 0)
						System.out.println("NO EXISTE TARJETA CON ESE NUMERO");
					else {
						System.out.println("CONTRASEÑA DE LA TARJETA");
						String clave = sc.nextLine();

						Tarjeta tar = tarjetas.get(0);

						if (!clave.equals(tar.getClave()))
							System.out.println("ERROR CLAVE");
						
						System.out.println("Retirar Dinero");
						int dinero=sc.nextInt();
						
						if(dinero>tar.getLimite())
							System.out.println("NO PUEDES RETIRAR MAS DEL LIMTE");
						

					}

				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");
				}
				break;
			}
		} while (opc != 11);

	}

}
