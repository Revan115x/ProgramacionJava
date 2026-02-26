package Fichero2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import static java.nio.file.StandardCopyOption.*; 
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee la ruta y el nombre de dos ficheros y copia el primero en el
		 * segundo. Si el segundo existe pide confirmación.
		 */

		Scanner sc = new Scanner(System.in);
		Path fich;
		Path fich2;

		do {
			/*/home/inf1/Desktop/Programacion*/
			
			System.out.println("Origen:");
			String archivo1 = sc.nextLine();
			System.out.println("Destino:");
			String archivo2 = sc.nextLine();
			fich = Paths.get(archivo1);
			fich2 = Paths.get(archivo2);
			if (!Files.exists(fich)) {
				System.out.println("Archivo no existe");
			} else { 
				if (Files.exists(fich2)) {
					System.out.println("El archivo destino existe. Confirmas la copia del el primero en el segundo");
					boolean confirmar = sc.nextBoolean();
					if (confirmar) {
						try {
						Files.copy(fich, fich2,REPLACE_EXISTING);
						System.out.println("Copia realizada");
						}
						catch (IOException e) {
							System.out.println("Error");
						}				
					}
				}else {
					try {
						Files.copy(fich, fich2);
						System.out.println("Copia realizada");
						}
						catch (IOException e) {
							System.out.println(e.getMessage());
						}				
				}
			}
			
		} while (!Files.exists(fich2) || !Files.exists(fich));

	}

}
