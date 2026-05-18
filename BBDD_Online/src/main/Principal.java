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

		BD_online bd = new BD_online("mysql-properties.xml");
		LinkedList<cursos> curso = new LinkedList<cursos>();

		do {

			try {
				System.out.println("\n *MENU ONLINE CURSOS* \n");
				System.out.println("1. Cargar cursos disponibles");
				System.out.println("2. Inscribirse en un curso");

				opc = sc.nextInt();
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir n�mero 1-5");
				opc = 0;
			}
			switch (opc) {

			case 1:
				sc.nextLine();
				try {

					curso = bd.Cursos();

					if (curso.size() == 0)
						System.out.println("NO HAY CURSOS");

					for (cursos cur : curso) {
						System.out.println(cur.toString());
					}

				} catch (ErrorBaseDatos e) {
					System.out.println("ERROR : " + e.getMessage());
				}
				break;
			case 2:
				sc.nextLine();
				if (curso.size() == 0) {
					System.out.println("NO HAY CURSOS");
					break;
				} else

					do {
						sc.nextLine();
						System.out.println("Categoria");
						String categoria = sc.nextLine();

						System.out.println("Precio minimo");
						double precioMin = sc.nextDouble();

						System.out.println("Precio maximo");
						double precioMaz = sc.nextDouble();

						try {
							curso = bd.CursosDisponibles(categoria, precioMin, precioMaz);
							int cont=0;
							for (cursos cur : curso) {
								System.out.println(cont+" "+cur.toString());
								cont++;
							}

						} catch (ErrorBaseDatos e) {
							System.out.println("ERROR : " + e.getMessage());
						}

					} while (curso.size() == 0);
				
				System.out.println("Elige el curso");
				int pos=sc.nextInt();
				
				//POSICION DEL LINKEDLIST
				cursos c=curso.get(pos);
				
				System.out.println(c.toString());
				
				sc.nextLine();

				System.out.println("Correo Electronico");
				String correo = sc.nextLine();

				String patron = "[A-Za-z]+@[A-Za-z]+\\\\.com";

				/*if (!correo.matches(patron)) {
					System.out.println("no cumple el patron");
					break;
				}*/

				try {
					alumnos alum = bd.BuscarCorreos(correo);
					
					if(alum==null)
						System.out.println("NO EXISTE ESE CORREO");
					
					int filas=bd.inscribirse(c,alum);
					
					switch(filas) {
					case 1:
						System.out.println("Te has inscrito correctamente en "+c.getCategoria());
						bd.actualizar(c);
						break;
					case 2:
						System.out.println("ERROR");
						break;
					}
					
					System.out.println("CURSOS MAS CAROS");
					
					curso = bd.CursosMasCaro();
					
					for(cursos cur: curso)
						System.out.println(cur.toString());
					
					String categoria=bd.categoriaMasInscrita();
					
					System.out.println("CATEGORIA MAS INSCRITOS");
					System.out.println(categoria);
				} catch (ErrorBaseDatos e) {
					e.printStackTrace();
				}

				break;
			}
		} while (opc != 5);
	}
}
