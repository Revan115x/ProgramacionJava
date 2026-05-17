package main;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import bbdd.*;
import modelos.Usuarios;
import modelos.Anuncios;
import modelos.Vendidos;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opc = 0;

		DB_Wallapop bd = new DB_Wallapop("mysql-properties.xml");

		do {
			/* MENU */
			try {
				System.out.println(" MENU DE WALLAPOP ");
				System.out.println("1.Comprar un producto");

				opc = sc.nextInt();
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir n�mero 1-5");
				opc = 0;
			}

			sc.nextLine();
			switch (opc) {
			case 1:
				System.out.println("\n EMAIL DEL USUARIO");
				String email = sc.nextLine();

				try {
					Usuarios usuario = bd.Usuario(email);

					if (usuario == null) {
						System.out.println("NO EXISTE ESE USUARIO");
						break;
					} else {

						ArrayList<Anuncios> Anuncio = bd.Anuncios();

						System.out.println("Categorias: ");
						for (Anuncios anun : Anuncio) {
							System.out.println(anun.getCategoria());
						}

						System.out.println("\n DIME LA CATEGORIA");
						String cat = sc.nextLine();

						System.out.println("Dime precio minimo");
						double precioMin = sc.nextDouble();

						System.out.println("Dime precio maximo");
						double precioMax = sc.nextDouble();

						ArrayList<Anuncios> AnuncioFiltrado = bd.AnuncioPrecio(cat, precioMax, precioMin);
						int num = 0;

						for (Anuncios anunp : AnuncioFiltrado) {
							System.out.println(num + " " + anunp.toString());
							num++;
						}

						if (AnuncioFiltrado.size() == 0) {
							System.out.println("NO HAY ANUNCIOS CON ESE PRECIO");
							break;
						} else {
							System.out.println("ELIGE EL NUMERO DEL ANUNCIO QUE VAS A COMPRAR");
							int pos = sc.nextInt();

							Anuncios anuncio = AnuncioFiltrado.get(pos);

							String codigo = anuncio.getCodigo();

							Vendidos vend = new Vendidos(codigo, email, anuncio.getPrecioVenta());

							int filas = bd.vendidos(vend);

							switch (filas) {
							case 1:
								System.out.println("COMPRA REALIZADA CORRECTAMENTE");
								bd.eliminarAnuncio(codigo);
								break;
							case 0:
								System.out.println("No añadida, contacte con sistemas");
								break;
							}

						}

					}

				} catch (ErrorBaseDatos e) {
					System.out.println("");
				}

				break;
			}
		} while (opc != 5);
	}
}
