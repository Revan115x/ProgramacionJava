package fichero9;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lista los archivos de un directorio (sólo los archivos). Para
		 * cada archivo que puede leer, imprimirá su contenido en pantalla
		 */

		Charset charset = Charset.forName("UTF-8");
		Scanner sc = new Scanner(System.in);
		/*Declaramos para leer*/
		BufferedReader reader = null;

		System.out.println("Introduce nombre de la carpeta");
		String carpeta = sc.nextLine();

		Path carp = Paths.get(carpeta);

		if (!Files.exists(carp))
			System.out.println("no existe la carpeta");
		else {
			if (!Files.isDirectory(carp)) {
				System.out.println("No es una carpeta");
			} else {
				try {
					DirectoryStream<Path> Stream = Files.newDirectoryStream(carp);
					for (Path path : Stream) {
						if(Files.isRegularFile(path)) {
							System.out.println(path.getFileName().toString()+"---------");
							//muestro el contenido del path
							
						}
						
						reader = Files.newBufferedReader(path, charset);
						String line = null;
						while ((line = reader.readLine()) != null) {
							System.out.println(line);
						}
						reader.close();
					}
					
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}

		}
	}
}
