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
				Tarjeta tar = null;
				try {
					cuentas = bd.mostrarCuentas(dni);
					if (cuentas.size() == 0)
						System.out.println("No hay ninguna titular con este titular");
					else {
						System.out.println("Las cuentas del que es titular el dni introducido");
						System.out.println(cuentas);
						System.out.println("Elige la cuenta introduciendo el numero de la cuenta: ");
						int numCuenta = sc.nextInt();
						sc.nextLine();
						System.out.println("numero de la tarjeta: ej: 5555");
						int numTarjeta = sc.nextInt();
						sc.nextLine();
						System.out.println("Introduce el titular: ");
						String titular = sc.nextLine();
						System.out.println("Introduce el límite: ");
						double limite = sc.nextDouble();
						sc.nextLine();
						System.out.println("Su clave: ");
						String clave = sc.nextLine();
						int filas = bd.añadir_Tarjeta(new Tarjeta(numTarjeta, numCuenta, titular, limite, clave));
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
				System.out.println("Introduce el numero de la cuenta: ");
				int numCuenta = sc.nextInt();
				try {
					Cuenta ct = bd.buscarCuenta(numCuenta);
					if (ct == null)
						System.out.println("No existe esa cuenta");
					else {
						int numTarjeta = bd.BuscarUltimoNumTarjeta() + 1;
						sc.nextLine();
						System.out.println("Introduce el titular: ");
						String titular = sc.nextLine();
						System.out.println("Introduce la clave: ");
						String clave = sc.nextLine();
						int filas = bd.añadir_Tarjeta(new Tarjeta(numTarjeta, numCuenta, titular, clave));
						switch (filas) {
						case 1:
							System.out.println("Tarjeta dada de alta correctamente");
							break;
						case 0:
							System.out.println("Error al dar de alta la tarjeta");
							break;
						}
					}
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");
				}
				break;
			case 3:
				System.out.println("\n--- SACAR DINERO (DÉBITO) ---");
				System.out.print("Introduce el número de tarjeta: ");
				int nt = sc.nextInt();
				sc.nextLine(); // Limpiar buffer
				System.out.print("Introduce la clave: ");
				String clave = sc.nextLine();
				System.out.print("Importe a retirar: ");
				double imp = sc.nextDouble();

				try {
					bd.sacarDineroDebito(nt, clave, imp);
				} catch (ErrorBaseDatos e) {
					System.out.println("OPERACIÓN DENEGADA: " + e.getMessage());
				}

				break;
			case 4:
				System.out.println("\n--- OPERACIÓN CRÉDITO ---");
				System.out.print("Número de tarjeta: ");
				int numTarjeta = sc.nextInt();
				sc.nextLine();
				System.out.print("Clave: ");
				clave = sc.nextLine();

				System.out.print("Importe a sacar: ");
				double importe = sc.nextDouble();

				try {
					// 1. Validar requisitos (Tipo, Bloqueo, Límite)
					bd.validarTarjetaCredito(numTarjeta, clave, importe);
					// 2. Si es válida, crear el objeto movimiento
					// El constructor Movimiento(numTarjeta, importe) pone la fecha actual y cargado
					// = false
					Movimiento mov = new Movimiento(numTarjeta, importe);

					// 3. Registrar en la tabla de movimientos
					int filas = bd.añadir_Movimiento(mov);

					if (filas == 1) {
						System.out.println("Operación de crédito autorizada y movimiento registrado.");
					}

				} catch (ErrorBaseDatos e) {
					System.out.println("OPERACIÓN DENEGADA: " + e.getMessage());
				}
				break;
			case 8:
				System.out.println("\n\nAlta movimiento");
				System.out.println("Anota número de tarjeta: ");
				numTarjeta = sc.nextInt();
				System.out.println("Anota importe: ");
				importe = sc.nextDouble();

				Movimiento m = new Movimiento(numTarjeta, importe);

				try {
					int filas = bd.añadir_Movimiento(m);
					if (filas == 0)
						System.out.println("No se ha dado de alta el movimiento. Contacte con sistemas");
					else
						System.out.println("Movimiento dado de alta correctamente.");
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + "Avise a sistemas");
				}

				break;
			default:
				System.out.println("Opcion Incorrecta.");
				break;
			}
		} while (opc != 11);

	}

}
