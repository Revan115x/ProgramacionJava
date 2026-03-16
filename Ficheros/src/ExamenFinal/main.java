package ExamenFinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.nio.file.OpenOption;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Haced un programa con un menú que realice las siguientes operaciones:
		 * 
		 * - Leed el nombre de una asignatura por teclado, si existe, cread un arrayList
		 * con los alumnos que hayan aprobado. - Dado el dni de un alumno mostrad sus
		 * notas en todas las asignaturas. - Ha habido un error en las calificaciones de
		 * una asignatura. Cread un nuevo fichero ordenado por notas de mayor a menor,
		 * en el que se ha sumado un punto a cada nota. Sustituir el antiguo fichero por
		 * el nuevo.
		 */

		Scanner sc = new Scanner(System.in);
		BufferedReader leerFicheros;
		BufferedWriter EscribirFichero;
		DirectoryStream<Path> LeerDirectorio;
		Charset charset = Charset.forName("UTF-8");
		Path ruta = Paths.get("asignaturas");
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		boolean encontrado = false;

		System.out.println("****************MENU*****************");
		System.out.println("1.*******Alumnos Aprobados***********");
		System.out.println("2.**********alumno nota *************");
		System.out.println("3.*******Alumnos Aprobados***********");
		int opc = sc.nextInt();
		sc.nextLine();

		switch (opc) {
		case 1: {

			System.out.println("Que Asignaturas Buscas");
			String asignatura = sc.nextLine();
			try {
				LeerDirectorio = Files.newDirectoryStream(ruta);
				encontrado = false;
				for (Path path : LeerDirectorio) {
					if (path.getFileName().toString().replace(".info", "").equalsIgnoreCase(asignatura)) {
						String line = null;
						leerFicheros = Files.newBufferedReader(path);

						while ((line = leerFicheros.readLine()) != null) {
							try {
								String datos[] = line.split(",");

								String dni = datos[0].trim();
								String nombre = datos[1].trim();
								String apellido = datos[2].trim();
								int nota = Integer.parseInt(datos[3].trim());

								Alumno al = new Alumno(dni, nombre, apellido, nota);

								if (al.getNota() >= 5)
									listaAlumnos.add(al);

							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						}
						for (int i = 0; i < listaAlumnos.size(); i++) {
							System.out.println(listaAlumnos.get(i).toString()); // imprime cada elemento
						}
						encontrado = true;
						break;
					}
				}
				
			} catch (IOException e) {
				System.out.println("Error");
			}

			break;
		}
		
		case 2:
			System.out.println("DIME EL DNI DEL ALUMNO");
			String dni=sc.nextLine();
			String line = null;
			
			leerFicheros = Files.newBufferedReader(path);
			while ((line = leerFicheros.readLine()) != null) {
				try {
					String datos[] = line.split(",");

					 String dniF = datos[0].trim();
					 if (dni.equalsIgnoreCase(dniF)) {
						 //escribir su nota
					 }
				}
			break;
		
		default:

		}

		System.out.println("Fin del programa");
	}

}
