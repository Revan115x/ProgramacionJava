package Fichero4;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Modifica el programa anterior para que sólo borre los ficheros que empiecen
		 * por una letra anotada desde teclado
		 */

		
		Scanner sc = new Scanner(System.in);
		/*Declaro path*/
		Path fich;

		/*leo Directorio*/
		System.out.println("directorio:");
		String directorio = sc.nextLine();

		/*convierto el string en path*/
		fich = Paths.get(directorio);

		if (!Files.exists(fich)) {
			System.out.println("Archivo no existe");
		} else {
			if (!Files.isDirectory(fich)) {
				System.out.println("NO ES UNA CARPETA");
			} else {
				/*Declaro Directorystream y le doy el nombre Stream*/
				DirectoryStream<Path> Stream;
				
				try {
					/*Stream vale la ruta de path que le di*/
					Stream = Files.newDirectoryStream(fich);
					
					/*recorre el directorio*/
					for (Path path : Stream) {
						if (!Files.isDirectory(path)) {
							
							/*paso a string la ruta path*/
							String letra = path.getFileName().toString();
							
							/*si empieza por s elimina los archivos*/
							if (letra.startsWith("s")) {
								Files.delete(path);
								System.out.println("Eliminando..");
							} else
								System.out.println("No hay ningun archivo con empiece por S");
						}
					}
					Files.delete(fich);
					System.out.println("Carpeta Eliminada");

				} catch (DirectoryNotEmptyException e) {
					System.out.println("El directirio no esta vacio" + fich);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
