package Fichero8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee un archivo y cuenta las veces que se repite una letra
		 * anotada desde teclado.
		 */
		
		Charset charset = Charset.forName("UTF-8");
		Scanner sc=new Scanner(System.in); 
		/*buffer para leer caracteres*/
		BufferedReader leer=null;
		String palabra = null;
		int cont=0;
		
		/*declaramos path con su ubicacion*/
		Path fich= Paths.get("salida.txt");
		
		/*preguntamos si es fichero*/
		if(!Files.isRegularFile(fich)) {
			System.out.println("no es un archivo");
		}else {
			
			/*si es un fichero entra en try*/
			try {
				
				System.out.println("dime la palabra que quieres comprobar");
				palabra=sc.nextLine();
				
				/*decimos que leer vale fich y charset*/
				leer=Files.newBufferedReader(fich,charset);
				String line=null;
				
				/*Leemos lo que hay dentro del fichero*/
				while((line=leer.readLine()) != null) {
					if(line.indexOf(palabra)!=-1)
						cont++;
				}
				
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("La palabra "+palabra+" se repite "+cont);
		System.out.println("FIN DEL PROGRAMA");
		
	}

}
