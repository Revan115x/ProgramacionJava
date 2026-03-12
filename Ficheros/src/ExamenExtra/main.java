package ExamenExtra;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Tenemos una carpeta con vuestro apellido dentro de la carpeta de vuestra aplicación.
		Esa carpeta contiene varios ficheros de texto con la información de varios libros (un
		libro en cada línea) separada por comas (titulo, autor, precio ):
		Ejemplo:
		El fichero ventas_enero.txt podría tener el siguiente contenido:
		
		La Odisea, Homero,24.5
		Geisha, Arthur Golden,15.25
		
		El fichero ventas_febrero.txt podría tener el siguiente contenido:
		
		Carrie,Stephen King,12
		Ulises, James Joyce, 21
		
		Leed todos los ficheros de esta carpeta que empiecen por “ventas” y generad un único
		fichero con vuestro nombre ( a la misma altura que la carpeta de vuestro apellido)
		que contenga todos los libros cuyo precio sea superior a 20 euros. Cada línea del
		nuevo fichero tendrá el siguiente formato:
		Título:’La Odisea’ autor:Homero
		Titulo:’Ulises’ autor:James Joyce
		
		Esta prueba evalúa los siguientes criterios:*/
		
		Scanner sc=new Scanner(System.in);
		DirectoryStream<Path>Leer;

	}

}
