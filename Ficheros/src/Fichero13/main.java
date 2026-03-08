package Fichero13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee de teclado un fichero de texto con la información de varios
		 * alumnos. En cada línea separada por comas, aparece el nombre, primer
		 * apellido, nota (double) y fecha de nacimiento de cada alumno. Con los alumnos
		 * leídos crea un ArrayList, luego lo ordena por nota de mayor a menor.controlar
		 * excepciones los errores de nota y fechas y guardarlos en un fichero log,
		 * corregir el fichero y mostrar los errores log por pantalla.
		 */

		Scanner sc = new Scanner(System.in);

		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		/* Declaro el tipo de codificacion */
		Charset charset = Charset.forName("UTF-8");

		/* Declaro la direccion del fichero */
		Path AlumFich = Paths.get("Alumno.txt");

		/* Declaro en fichero para guardar errores */
		Path errores = Paths.get("log.txt");

		/* Declaro buffer para poder leer el fichero */
		BufferedReader leer = null;

		/* Declaro buffer para escribir los errores el fichero log.txt */
		BufferedWriter escribir = null;

		/* Declaro arraylist para guardar los datos del fichero */
		LinkedList<Alumno> Alumnos = new LinkedList<Alumno>();

		/* preguntamos si es un fichero */
		if (!Files.isRegularFile(AlumFich)) {
			System.out.println("Debe de ser un fichero!");
		} else {
			try {
				/* Leer es fichero y la codificacion */
				leer = Files.newBufferedReader(AlumFich, charset);
				escribir = Files.newBufferedWriter(errores, charset);

				String line = null;

				while ((line = leer.readLine()) != null) {
					
					try {
						/* Creamos un array de String */
						/* separamos los datos del fichero con split */
						String separacion[] = line.split(",");

						/* guardamos los datos en string */
						String nombre = separacion[0];
						String apellido = separacion[1];
						Alumno a;
						
						Double nota = Double.parseDouble(separacion[2]);
						LocalDate fecha = LocalDate.parse(separacion[3], d);
						/* guardo el objeto en la clase */
						a = new Alumno(nombre, apellido, nota, fecha);
						/* llamo mi funcion pos para ordenar */
						int posicion = pos(Alumnos, a);

						Alumnos.add(posicion, a);
					}catch (DateTimeParseException e) {
						escribir.write("ERROR EN : "+line);
					}catch (NumberFormatException e) {
						escribir.write("ERROR EN : "+line);
					}

				}

				for (Alumno al : Alumnos) {
					System.out.println(al);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Fin del programa");

		}

	}

	/* Funcion que devuelve la posicion */
	public static int pos(LinkedList<Alumno> alum, Alumno a) {

		/* Version con iterator */
		/*
		 * int cont=0;
		 * 
		 * Iterator<Alumno> it=alum.iterator(); while(it.hasNext()) {
		 * if(it.next().getNota()<a.getNota()) return cont; cont++; }
		 */

		/* leermos la clase */
		for (int i = 0; i < alum.size(); i++) {
			/* si nota es mayor que el alumno i devuelve la posicion i */
			if (a.getNota() > alum.get(i).getNota())
				return i;
		}
		return alum.size();
	}

}
