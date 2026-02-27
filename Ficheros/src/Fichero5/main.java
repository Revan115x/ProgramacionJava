package Fichero5;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que acepta el nombre de una carpeta por teclado y permita borrarla ,
		 * tanto si está vacía como si no. Si no está vacía debe pedir confirmación.
		 * Dentro de la carpeta sólo tendremos archivos
		 */

		Scanner sc = new Scanner(System.in);

		Path fich;

		System.out.println("Direccion del directorio");
		String directorio = sc.nextLine();

		fich = Paths.get(directorio);
		if (!Files.exists(fich)) {
			System.out.println("Archivo no existe");
		} else {
			if (!Files.isDirectory(fich)) {
				System.out.println("la ruta no pertenece a un directorio");
			} else {
				/*DirectoryStream permite leer todos los ficheros del direcotorio  con nombre files*/
				DirectoryStream<Path> files = null;
				try {
					/*abre esa carpeta que le hemos pasado que es fich*/
					files = Files.newDirectoryStream(fich);
					
					/*Es un puntero que va mirando elementos uno por uno y le damos el nombre it*/
					Iterator<Path> it=files.iterator();

					/*si it no tiene nada elimina la carpeta*/
					if (!it.hasNext()) {
						System.out.println("Directorio Vacio");
						System.out.println("Eliminando Directorio....");
						Files.delete(fich);
						System.exit(0);
					} else {
						System.out.println("Quieres borrar los archivos que contiene la carpeta?");
						boolean borrar = sc.nextBoolean();
						if (!borrar) {
							System.out.println("Haz cancelado");
							System.exit(0);
						} else {
							for (Path file : files) {
								System.out.println("Eliminado archivos...");
								Files.delete(file);
							}
						}
					}
					/*
					 * System.out.println("Eliminano directorio.."); Files.delete(fich);
					 */

				} catch (DirectoryNotEmptyException e) {
					System.out.println("El directirio no esta vacio" + fich);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		System.out.println("Fin del programa");

	}
}
