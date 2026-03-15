package ExamenExtra;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

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
import java.util.Scanner;
import java.nio.file.OpenOption;
import Examen_pt1.auto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Tenemos una carpeta con vuestro apellido dentro de la carpeta de vuestra
		 * aplicación. Esa carpeta contiene varios ficheros de texto con la información
		 * de varios libros (un libro en cada línea) separada por comas (titulo, autor,
		 * precio ): Ejemplo: El fichero ventas_enero.txt podría tener el siguiente
		 * contenido:
		 * 
		 * La Odisea, Homero,24.5 Geisha, Arthur Golden,15.25
		 * 
		 * El fichero ventas_febrero.txt podría tener el siguiente contenido:
		 * 
		 * Carrie,Stephen King,12 Ulises, James Joyce, 21
		 * 
		 * Leed todos los ficheros de esta carpeta que empiecen por “ventas” y generad
		 * un único fichero con vuestro nombre ( a la misma altura que la carpeta de
		 * vuestro apellido) que contenga todos los libros cuyo precio sea superior a 20
		 * euros. Cada línea del nuevo fichero tendrá el siguiente formato: Título:’La
		 * Odisea’ autor:Homero Titulo:’Ulises’ autor:James Joyce
		 * 
		 * Esta prueba evalúa los siguientes criterios:
		 */

		/*Declaro Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*DirectoryStream de tipo Path para leer lo que contiene la carpeta*/
		DirectoryStream<Path> Leer;
		/*Buffer reader para leer los que contiene los ficheros */
		BufferedReader leerf = null;
		/*BufferWriter para escribir en un fichero*/
		BufferedWriter Escribir = null;
		/*la codificacion que le pasare al escribir IMPORTANTE */
		Charset charset = Charset.forName("UTF-8");
		/*Declaro paath para la ruta*/
		Path ruta;
		/*Linkedlist o arraylist para guardar pasar a objetos lo que contienen los ficheros*/
		ArrayList<Informacion> libros = new ArrayList<Informacion>();

		System.out.println("Indicame la ruta del Archivo");
		String carpeta = sc.nextLine();

		/*paso de String a Path*/
		ruta = Paths.get(carpeta);

		/*valido que sea un fichero*/
		if (!Files.isDirectory(ruta))
			System.out.println("Debe de una carpeta");

		/*Try obligatorio para leer lo que contiene las carpetas y ficheros*/
		try {
			/*Le digo que lea lo que contiene la carpeta "ruta" que le pase*/
			Leer = Files.newDirectoryStream(ruta);
			/*String line para leer lineas*/
			String line = null;
			
			/*Le indico a bufferweiter la ruta donde escribira,el tipo y si no existe la cree*/
			Escribir = Files.newBufferedWriter(Paths.get("libros.txt"), charset, CREATE, APPEND);
			
			/*for para leer la carpeta*/
			for (Path path : Leer) {
				
				/*Si empiza por ventas leermos lo que contiene*/
				if (path.getFileName().toString().startsWith("ventas")) {
					/*Leerf es leer los path "ficheros" que contiene leer "ruta" */
					leerf = Files.newBufferedReader(path);
					/*bucle para ir leyendo linea a linea*/
					while ((line = leerf.readLine()) != null) {
						
						/*capturamos las expeciones que nos pueda dar*/
						try {
							
							/*Guardamos toda la infomacin en un array de string*/
							/*Separamos el array por comas*/
							/*trim para limpiar los espacios*/
							String resultados[] = line.split(",");
							String titulo = resultados[0].trim();
							String autor = resultados[1].trim();
							Double precio = Double.parseDouble(resultados[2].trim());

							/*guarmos la imformacion en objeto */
							Informacion a = new Informacion(titulo, autor, precio);

							/*añadimos el objeto al arraylist*/
							libros.add(a);

							/*si el objeto a es mayor de 20 lo escribimos en "Escribir"*/
							if (a.getPrecio() > 20) {
								Escribir.write(a.toString());
								/*salto de linea*/
								Escribir.newLine();
							}

						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
					/*cerramos leer fuera del bucle*/
					leerf.close();
				}

			}
			/*cerramos escribir fuera del for */
			Escribir.close();

		} catch (IOException E) {
			System.out.println("ERROR");
		}

		System.out.println("Fin del Programa");
	}

}
