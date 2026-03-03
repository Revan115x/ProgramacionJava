package Fichero7;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Programa que cuenta los caracteres de un archivo */

		Scanner sc = new Scanner(System.in);
		// Array de bytes para leer todos los bytes del archivo
		InputStream leer = null;
		int byt = 0, cont = 0;

		// definimos la ruta del archivo.txt
		Path fich = Paths.get("salida.txt");

		// preguntamos si es un fichero
		if (!Files.isRegularFile(fich))
			System.out.println("no es un fichero");
		else {
			/* try para controlar excepciones */
			try {
				// "leer" nos permiten trabajar byte a byte y abre el fichero
				leer = Files.newInputStream(fich);
				while ((byt = leer.read()) != -1) {
					cont++;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Numero de caracteres es " + cont);
	}

}
