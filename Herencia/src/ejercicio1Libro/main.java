package ejercicio1Libro;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*1. En una librería se guarda por cada libro: titulo, autor, editorial y precio. Hay libros
		normales y de texto. Estos tienen como información adicional el curso al que
		corresponden y además se les aplica un descuento entre el 0 y el 20%.
		Programa con un menú con las siguientes opciones:
		
		1. Dar de alta libros en un ArrayList .
		2. Listar todos los libros mostrando la información de cada uno.
		3. Listar los libros que tienen un precio de salida menor que un precio introducido
		por teclado.*/

		Scanner sc=new Scanner(System.in);
		BufferedReader leer = null;
		Charset charset = Charset.forName("UTF-8");
		ArrayList<libro> libros = new ArrayList<libro>();
		int opc;
		
		
		/*****AUTOMATIZO EL AGREGAR LIBROS POR PROBAR FICHEROS********/
		try {
			leer = Files.newBufferedReader(Paths.get("libros"), charset);
			String line1 = null;
			while ((line1 = leer.readLine()) != null) {
				
				String[] partes = line1.split(",");
				libro libro1 = new libro(partes[0],partes[1],partes[2],Double.parseDouble(partes[3]));
	
				libros.add(libro1);

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("****************************Menu*******************************");
		System.out.println("1. Dar de alta libros en un ArrayList .");
		System.out.println("2. Listar todos los libros mostrando la información de cada uno.");
		System.out.println("3. Listar los libros que tienen un precio de salida menor que");
		opc=sc.nextInt();
		
		switch(opc) {
		
		case 1:
				System.out.println("Nombre libro");
				String nombre=sc.nextLine();
				System.out.println("Nombre autor");
				String autor=sc.nextLine();
				System.out.println("Nombre editorial");
				String editorial=sc.nextLine();
				System.out.println("Precio:");
				double precio=sc.nextDouble();
				
				System.out.println("es libro de texto?");
				String responder=sc.nextLine();
				
				if(responder.equalsIgnoreCase("si")) {
					System.out.println("Curso?");
					String Curso=sc.nextLine();
					
					System.out.println("Descuento");
					int descuento=sc.nextInt();
					
					if(descuento>0 || descuento<20)
						System.out.println();
					
				}else {
				
				libro a=new libro(nombre,autor,editorial,precio);
				
				libros.add(a);
				}
				
			break;
		case 2:
			System.out.println("************************Lista Libros*************************");
			for (int i = 0; i < libros.size(); i++) {
	            System.out.println(libros.get(i)); 
	        }
			break;
		case 3:
			
			break;
		
		}
		
		
	}
}
