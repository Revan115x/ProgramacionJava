package Fichero3;

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
		 * Programa que acepta el nombre de una carpeta por teclado y borra todos los
		 * ficheros que contiene (sólo ficheros)
		 */

		Scanner sc = new Scanner(System.in);
		Path fich;

		System.out.println("directorio:");
		String directorio = sc.nextLine();

		fich = Paths.get(directorio);

		if (!Files.exists(fich)) {
			System.out.println("Archivo no existe");
		} else {
			if (!Files.isDirectory(fich)) {
				System.out.println("NO ES UNA CARPETA");
			} else {
				DirectoryStream<Path> Stream;
				try {
					Stream = Files.newDirectoryStream(fich);
					for (Path path : Stream) {
						if (!Files.isDirectory(path)) {
							Files.delete(path);
							System.out.println("Eliminando..");
						}
					}
					Files.delete(fich);
					System.out.println("Carpeta Eliminada");
					
				}catch(DirectoryNotEmptyException e){
					System.out.println("El directirio no esta vacio"+fich);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
