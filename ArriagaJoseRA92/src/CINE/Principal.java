package CINE;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
import bbdd.*;
import modelos.reservas;
import modelos.salas;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sLeer = new Scanner(System.in);
		int opc = 0;

		DB_CINE bd = new DB_CINE("mysql-properties.xml");

		do {
			System.out.println("1.mostrar informacion de las salas");
			System.out.println("2.mostrar informacion de las salas");
			try {
				opc = sLeer.nextInt();
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir n�mero 1-5");
				opc = 0;
			}

			sLeer.nextLine();
			switch (opc) {
			case 1:
				Vector<salas> salas;
				try {

					salas = bd.listado();

				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:" + e.getMessage());
					break;
				}
				if (salas == null) {
					System.out.println("No hay cursos disponibles");
					break;
				}
				System.out.println("Lista de salas");
				for (int i = 0; i < salas.size(); i++) {
					System.out.println(salas.get(i).toString());
					System.out.println("plazas libres");
					System.out.println(salas.get(i).plazas_libres());
				}
				
				int pos;
				
				do {
					System.out.print("ANOTA NUMERO DE SALA");
					int sala = sLeer.nextInt();
					pos=buscarsala(sala, salas);
					if(pos==-1)
						System.out.println("No existe esa sala");
				}while(pos==-1);
				
				System.out.println("anota numero de entradas:");
				int entradas = sLeer.nextInt();
				
				if(salas.get(pos).plazas_libres()<entradas) {
					System.out.println("No hay suficientes plazas libres");
					break;
				}
				break;

			/*case 2:
				
				try {

					salas = bd.listado();

				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:" + e.getMessage());
					break;
				}
				if (salas == null) {
					System.out.println("No hay cursos disponibles");
					break;
				}
				System.out.println("Lista de salas");
				for (int i = 0; i < salas.size(); i++)
					System.out.println(salas.get(i).toString());
				
				System.out.print("Tecla la sala");
				int sala = sLeer.nextInt();
				
				System.out.print("Tecla la sala");
				int precio= sLeer.nextInt() ;

				System.out.println("entradas");
				int entradas = sLeer.nextInt();
				
				System.out.println("Numero de telefono");
				int telefono = sLeer.nextInt();
				
				reservas a = new reservas(precio,entradas,sala,telefono);
				
				int filas;
				
				try {
					filas = bd.añadir(a);
					switch (filas) {
					case 1:
						System.out.println("\nAlumno a�adido");
						break;
					case 0:
						System.out.println("\nNo a�adido, contacte con sistemas");
						break;

					}
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println("Contacte con sistemas:" + e.getMessage());
				}

				break;*/

			}
		} while (opc != 10);

	}
	
	public static int buscarsala(int sala, Vector<salas> salas) {
		
		int resultado=-1;
		
		for (int i = 0; i < salas.size(); i++) {
			if (salas.get(i).getSala()==sala) {
				return resultado=i;
			}
		}
		
		return resultado;
		
	}
	
}
