package Fichero14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 14. Programa que elimina una palabra introducida por teclado de un fichero.
		 * El nombre del fichero de entrada y el de salida se introducen por teclado y
		 * no pueden coincidir.
		 */
		
		Scanner sc = new Scanner(System.in);
		Path entrada,Salida;
		BufferedWriter escribir=null;
		BufferedReader leer=null;
		Charset charset = Charset.forName("UTF-8");
		
		System.out.println("Indica el fichero de ENTRADA");
		String fich1=sc.nextLine();
		
		System.out.println("Indica el fichero de SALIDA");
		String fich2=sc.nextLine();
		
		entrada=Paths.get(fich1);
		Salida=Paths.get(fich2);
		
		if(!Files.isDirectory(Salida) ||!Files.isDirectory(entrada))
			System.out.println("ERROR: NO CARPTAS SOLO FICHEROS");
		else
			try {
				if(Files.isSameFile(entrada, Salida)){
					System.out.println("No pueden ser el mismo fichero");
				}
				escribir=Files.newBufferedWriter(Salida,charset);
				leer=Files.newBufferedReader(entrada,charset);
				String line=null;
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		System.out.println("FIN PROGRAMA");
		
	}

}
