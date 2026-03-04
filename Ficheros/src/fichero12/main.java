package fichero12;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
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
		 * Codificar un programa que lee un fichero de texto y escribe en otro sólo las
		 * líneas que contiene una palabra introducida por teclado.
		 */

		
		Scanner sc=new Scanner(System.in);
		Charset charset = Charset.forName("UTF-8");
		Path fich1=Paths.get("texto");
		Path fich2=Paths.get("texto2");
		
		/*Declaramos los buffer para leer*/
		BufferedReader leer =null;
		BufferedWriter escribir=null;
		
		if(!Files.isRegularFile(fich2) || !Files.isRegularFile(fich1))
			System.out.println("TIENEN QUE SER FICHEROS!");
			else {
				try {
					/*pedimos la palabra*/
					System.out.println("palabra?");
					String palabra=sc.nextLine();
					
					/*pasamos las palabra a minuscula y mayuscula para que pueda leer ambas palabras*/
					String palabraMay=palabra.toUpperCase();
					palabra=palabra.toLowerCase();					
					/*decimos que leer vale fich1 y charset*/
					leer=Files.newBufferedReader(fich1,charset);
					
					/*Escribir es fich2,charset(codificacion),create para que lo cree si no existe*/
					escribir = Files.newBufferedWriter(fich2, charset,CREATE);
					
					String line=null;
					
					/*bucle que leer lo que tiene el fich1*/
					while((line=leer.readLine())!=null) {
						/*la linea */
						if(line.indexOf(palabra)!=-1 || line.indexOf(palabraMay)!=-1)
							escribir.write(line);
							escribir.newLine();
					}
					
					/*cerramos los buffers*/
					escribir.close();
					leer.close();
					
				}catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}
	}

}
