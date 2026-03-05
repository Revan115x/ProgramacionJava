package Fichero13;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee de teclado un fichero de texto con la información de varios
		 * alumnos. En cada línea separada por comas, aparece el nombre, primer
		 * apellido, nota (double) y fecha de nacimiento de cada alumno. Con los alumnos
		 * leídos crea un ArrayList, luego lo ordena por nota de mayor a menor.
		 */

		Scanner sc = new Scanner(System.in);

		/* Declaro el tipo de codificacion */
		Charset charset = Charset.forName("UTF-8");

		/* Declaro la direccion del fichero */
		Path AlumFich = Paths.get("Alumno.txt");

		/* Declaro buffer para poder leer el fichero */
		BufferedReader leer = null;

		/* Declaro arraylist para guardar los datos del fichero */
		LinkedList<Alumno> Alumnos = new LinkedList<Alumno>();

		/* preguntamos si es un fichero */
		if (!Files.isRegularFile(AlumFich)) {
			System.out.println("Debe de ser un fichero!");
		} else {
			try {
				/* Leer es fichero y la codificacion */
				leer = Files.newBufferedReader(AlumFich, charset);
				String line = null;

				while ((line = leer.readLine()) != null) {

					/* Creamos un array de String */
					/* separamos los datos del fichero con split */
					String separacion[] = line.split(",");

					/* guardamos los datos en string */
					String nombre = separacion[0];
					String apellido = separacion[1];
					Double nota = Double.parseDouble(separacion[2]);
					String fecha = separacion[3];

					/**/
					String datos = "" + nombre + " " + apellido + " " + nota + " " + fecha;

					Alumno a = new Alumno(nombre, apellido, nota, fecha);
					int posicion=pos(Alumnos,a);
					
					Alumnos.add(posicion,a);

				}
				
				for (Alumno al : Alumnos) {
				    System.out.println(al);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static int pos(LinkedList<Alumno> alum, Alumno a) {
		
		for (int i=0;i<alum.size();i++) {
			if(a.getNota()>alum.get(i).getNota())
				return i;
		}
		return alum.size();
	}

}
