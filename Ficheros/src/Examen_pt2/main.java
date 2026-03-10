package Examen_pt2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Leed el nombre de dos carpetas por teclado y mostrad el nombre de todos los
		archivos (no directorios) contenidos en las carpetas sin repetirlos.
		Ejemplo:
		Si tenemos dos directorios con los siguientes archivos:
		Directorio1: a1, a2, a3, b1, b2
		Directorio2: a2, a3, a4, b1,b3
		La salida sería: a1,a2,a3,a4,b1,b2,b3
		(3,5 ptos)*/
	
		Scanner sc=new Scanner (System.in);
		Path fh1,fh2;
		String carpeta1,carpeta2;
		DirectoryStream<Path> Stream1;
		DirectoryStream<Path> Stream2;
		do {
			System.out.println("Nombre carpeta1");
			carpeta2 = sc.nextLine();
			System.out.println("Nombre carpeta2");
			carpeta1 = sc.nextLine();
			fh1 = Paths.get(carpeta2);
			fh2 = Paths.get(carpeta1);
			if (!Files.exists(fh1))
				System.out.println("La carpeta " + carpeta1 + " no existe");
			if (!Files.exists(fh2))
				System.out.println("La carpeta " + carpeta2 + " no existe");
			if (Files.isRegularFile(fh2) || Files.isRegularFile(fh1))
				System.out.println("TIENEN QUE SER CARPETAS NO ARCHIVOS");
			
		} while (!Files.exists(fh1)||!Files.exists(fh2) ||Files.isRegularFile(fh2) || Files.isRegularFile(fh1) );
		
		try {
			Stream1 = Files.newDirectoryStream(fh1);
			for (Path path : Stream1) {
				System.out.println("CARPETA "+fh1);
				if(Files.isRegularFile(fh1))
					System.out.println(path.getFileName().toString());
			}
			
			System.out.println("*************************************************************");
			
			Stream2 = Files.newDirectoryStream(fh2);
			for (Path path : Stream2) {
				System.out.println("CARPETA "+fh2);
				if(Files.isRegularFile(fh2))
					System.out.println(path.getFileName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
