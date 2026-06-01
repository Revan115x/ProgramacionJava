package Universidad;

import java.lang.reflect.Array;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Una universidad tiene los siguientes tipos de alumnos: los extranjeros, los
		 * de curso puente, y el resto. Para todos los alumnos guardamos: nombre,
		 * apellidos, curso, e importe de la matricula. los extranjeros pagan el 15% más
		 * de tasas y nos interesa saber su país de origen, también nos interesa saber
		 * la carrera de procedencia de los alumnos de curso puente. Codificar una
		 * jerarquía de clases adecuada. Crear un array con alumnos de distintos tipos y
		 * luego mostrar la información de cada uno de ellos llamando al método
		 * toString.
		 */

		Scanner sc = new Scanner(System.in);

		Alumno a1 = new Alumno("Juan", "Castillo", "ESO3", 50);
		Alumno a2 = new Extranjero("Sebastian", "Perez", "DAW", 70, "Haiti");
		Alumno a3 = new alumPuente("Maria", "Poste", "DAW", 70, "Desarrolo sistemas");

		Alumno[] alumnos = new Alumno[3];

		alumnos[0] = a1;
		alumnos[1] = a2;
		alumnos[2] = a3;

		for (int i = 0; i < alumnos.length; i++) {

			System.out.println(alumnos[i]);

		}

	}

}
