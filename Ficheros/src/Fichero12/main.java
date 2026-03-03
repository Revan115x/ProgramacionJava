package Fichero12;

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
		String archivo=sc.nextLine();
		
		Path fich1=Paths.get(archivo);
		
		

	}

}
