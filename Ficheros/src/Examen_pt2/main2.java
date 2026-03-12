package Examen_pt2;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**/
		
		/* carpetas a leer */
		/* /home/inf1/Desktop/Programacion/ProgramacionJava/Ficheros/fich2 */
		/* /home/inf1/Desktop/Programacion/ProgramacionJava/Ficheros/fich1 */

		Scanner sc = new Scanner(System.in);
		/* Declaro los Paths */
		Path fh1, fh2;
		/* String para leer las rutas */
		String carpeta1, carpeta2;

		/* DirectoryStream para leer lo que contiene las carpetas */
		DirectoryStream<Path> Stream1;
		DirectoryStream<Path> Stream2;

		/* Hashset para mostrar los no repetidos en la coleccion */
		HashMap<String,String> archivos1 = new HashMap<>();
		
		do {
			System.out.println("Nombre carpeta1");
			carpeta2 = sc.nextLine();
			System.out.println("Nombre carpeta2");
			carpeta1 = sc.nextLine();

			/* Paso de String a Path */
			fh1 = Paths.get(carpeta2);
			fh2 = Paths.get(carpeta1);

			/* Controlar Carpetas y ficheros */
			if (!Files.exists(fh1))
				System.out.println("La carpeta " + carpeta1 + " no existe");
			if (!Files.exists(fh2))
				System.out.println("La carpeta " + carpeta2 + " no existe");
			if (Files.isRegularFile(fh2) || Files.isRegularFile(fh1))
				System.out.println("TIENEN QUE SER CARPETAS NO ARCHIVOS");

			/* Bucle para controlar en caso de errores */
		} while (!Files.exists(fh1) || !Files.exists(fh2) || Files.isRegularFile(fh2) || Files.isRegularFile(fh1));

		/* try obligatirio para leer path */

		try {
			/* Le indico que Stream1 vale fh1 para que lea el contenido de la carpeta */
			Stream1 = Files.newDirectoryStream(fh1);
			System.out.println("Ficheros de la carpeta " + fh1);

			/* bucle para leer carpeta */
			for (Path path : Stream1) {
				/* Entramos si son ficheros y sus nombres */
				if (Files.isRegularFile(path)) {
					System.out.println(path.getFileName().toString());
					//archivos1.add(path.getFileName().toString());

				}
			}

			System.out.println("\n*************************************************************\n");

			/*
			 * igual que el anterio le indico que Stream2 vale fh2 para que lea el contenido
			 * de la carpeta
			 */
			Stream2 = Files.newDirectoryStream(fh2);
			System.out.println("Ficheros de la carpeta " + fh2);

			/* bucle para leer carpeta */
			for (Path path : Stream2) {
				/* Entramos si son ficheros y sus nombres */
				if (Files.isRegularFile(path)) {
					System.out.println(path.getFileName().toString());
					//archivos1.add(path.getFileName().toString());
				}
			}

			/* For para leer la coleccion ficheros */
			//for (String i : archivos1)
				
					//System.out.println(i);

		} catch (Exception e) {

		}
	}
	
	/*b2
	a1
	a2
	b3
	a3
	a4
	b1
	*/
	
}
