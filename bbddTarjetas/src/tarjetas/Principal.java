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
			System.out.println("5. movimientos de tarjeta y cambio cargo");
			System.out.println("6. Bloquear tarjeta");
			System.out.println("7. Desbloquear tarjeta");
			System.out.println("8. Alta movimiento");
			System.out.println("9. Eliminar tarjeta");
			System.out.println("10.INGRESAR DINERO");
			System.out.print("\t Teclea opción: ");
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

				int num;
				boolean encontrado = false;
				try {
					do {
						System.out.println("Anota número de cuenta: ");
						num = sc.nextInt();
						// Método que busca la cuenta en la tabla de cuentas
						encontrado = bd.buscarCuenta(num);
					} while (encontrado == false);
					numTarjeta = bd.Maximocuenta() + 1;

					sc.nextLine();
					System.out.println("Introduce el titular: ");
					String titular = sc.nextLine();

					System.out.println("Su clave: ");
					String clave = sc.nextLine();

					int filas = bd.añadir_Tarjeta(new Tarjeta(numTarjeta, num, titular, clave));

					switch (filas) {
					case 1:
						System.out.println("Tarjeta añadida correctamente");
						break;
					case 0:
						System.out.println("No añadida, contacte con sistemas");
						break;
					}
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");
				}

				break;

			case 3:
				System.out.println(" NUMERO DE TARJETA ");
				numTarjeta = sc.nextInt();
				sc.nextLine();
				
				System.out.println("CONTRASEÑA DE LA TARJETA");
				String clave = sc.nextLine();
				
				try {
					Tarjeta tar = null;
					tar = bd.MostrarTarjeta(numTarjeta,clave);

					if (tar == null)
						System.out.println("NO EXISTE TARJETA CON ESE NUMERO");
					else {

						if (!tar.getTipo().equals("D")) {
							System.out.println("NO ES DE DEBITO");
							break;
						}

						if (tar.getBloqueada() != 0) {
							System.out.println("LA TARJETA ESTA BLOQUEDA NO PUEDES ACCEDER");
							break;
						}

						System.out.println("Retirar Dinero");
						double dinero = sc.nextInt();

						Cuenta cuenta = null;
						cuenta = bd.SaldoTarjeta(tar.getNumeroCuenta());

						System.out.println(cuenta.getSaldo());

						if (dinero > cuenta.getSaldo()) {
							System.out.println("NO PERMITIDO RETIRAR POR FALTA DE SALDO");
							break;
						}

						System.out.println("Retirando dinero.....");

						int filas = bd.ActualizarSaldo(cuenta, dinero);

						switch (filas) {
						case 1:
							System.out.println("SALDO ACTUALIZADO BEBE");
							break;
						case 0:
							System.out.println("No se ha podido actualizar saldo, contacte con sistemas");
							break;
						}
					}
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");
				}
				break;

			case 4:
				System.out.println(" NUMERO DE TARJETA ");
				numTarjeta = sc.nextInt();
				sc.nextLine();
				
				System.out.println("CONTRASEÑA DE LA TARJETA");
				clave = sc.nextLine();
				
				try {
					Tarjeta tar = null;
					tar = bd.MostrarTarjeta(numTarjeta,clave);

					if (tar == null)
						System.out.println("NO EXISTE TARJETA CON ESE NUMERO");
					else {

						if (!tar.getTipo().equals("C")) {
							System.out.println("ERROR : LA TARJETA ES DE DEBITO");
							break;
						}

						if (tar.getBloqueada() != 0) {
							System.out.println("LA TARJETA ESTA BLOQUEDA NO PUEDES ACCEDER");
							break;
						}

						System.out.println("Retirar Dinero");
						double dinero = sc.nextDouble();

						
						if (dinero > tar.getLimite()) {
							System.out.println("NO PERMITIDO RETIRAR POR EXCEDER EL LIMITE DE LA TARJETA");
							break;
						}
						//int filas = bd.ActualizarSaldo(cuenta, dinero);
						
						int filas = bd.movimientos(tar, dinero);

						switch (filas) {
						case 1:
							System.out.println("retirando dinero.....");
							break;
						case 0:
							System.out.println("No se ha podido actualizar saldo, contacte con sistemas");
							break;
						}
					}
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");
				}
				break;

			case 5:
				System.out.println(" NUMERO DE TARJETA ");
				numTarjeta = sc.nextInt();
				sc.nextLine();
				try {
					ArrayList<Movimiento>movimientos;

					movimientos=bd.MovimientosTarjetaCargo(numTarjeta);
					
					for(Movimiento mov: movimientos) {
							
							System.out.println(mov.toString());
							
							double resultado=mov.getImporte();
							double TotalResultado=0;
							TotalResultado += resultado;
					}
					
					
				}catch(ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Contacte con sistemas");
				}
				break;
			}
		} while (opc != 11);

	}

}
