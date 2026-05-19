package main;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import bbdd.*;
import modelos.*;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opc = 0;

		BD_Biblioteca bd = new BD_Biblioteca("mysql-properties.xml");

		do {
			/* MENU */
			try {
				System.out.println("1. Prestar Libro");
				System.out.println("2. Añadir Ejemplares");
				opc = sc.nextInt();
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir n�mero 1-5");
				opc = 0;
			}

			sc.nextLine();
			switch (opc) {
			case 1:
				System.out.println("nombre usuario");
				String nombre = sc.nextLine();
				try {
					usuarios usuario = bd.MostrarUsuario(nombre);

					if (usuario == null) {
						System.out.println("No existe el usuario");
						break;
					} else {
						if (usuario.getPenalizado() == 1) {
							System.out.println("Usuario Penalizado");
							break;
						}

						System.out.println(usuario.toString());

						int num = usuario.getNumero();

						ArrayList<libros> libro = bd.MostrarLibrosUser(num);

						System.out.println("Libros en prestamo actual");

						for (libros lib : libro)
							System.out.println(lib.toString());

						System.out.println("DIME EL ISBN DEL LIBRO");
						String isbn = sc.nextLine();

						libros lib;

						lib = bd.verificarLibro(isbn);

						prestamos pres = (new prestamos(usuario.getNumero(), lib.getIsbn()));

						int filas = bd.altaprestamo(pres);

						switch (filas) {
						case 1:
							System.out.println("Alta correcta");
							break;
						case 2:
							System.out.println("Alta mal");
							break;
						}

					}

				} catch (ErrorBaseDatos e) {
					System.out.println("ERROR :" + e.getMessage());
				}

				break;
			case 2:
				/*NO ME HA DADO TIEMPO A CORREGIR EL INICIO*/
				ArrayList<libros> libro = new ArrayList<libros>();
				String fin = null;
				int unidades = 0;

				while (!fin.equals("fin")) {
					System.out.println("DIME EL ISBN DEL LIBRO");
					String isbn = sc.nextLine();
					libros lib;
					try {
						lib = bd.verificarLibro(isbn);

						if (lib == null)
							System.out.println("No existe");

						System.out.println("numero de unidades");
						unidades = sc.nextInt();

						libros libr = (new libros(isbn, unidades));

						libro.add(libr);

						System.out.println("quieres seguir (fin)");
						fin = sc.nextLine();

					} catch (ErrorBaseDatos e) {
						System.out.println("ERROR : " + e.getMessage());
					}
				}

				try {
					int filas = bd.AñadirEjemplares(libro);

					switch (filas) {
					case 1:
						System.out.println("Alta correcta");
						break;
					case 2:
						System.out.println("Alta mal");
						break;
					}
				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:" + e.getMessage());
				}

				break;
			}

		} while (opc != 3);
	}
}
