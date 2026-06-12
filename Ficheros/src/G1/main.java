package G1;
import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leer el fichero alumnos2.txt y almacenar la información en una colección
		 * adecuada. Recorrer el fichero notas2.txt y crear un nuevo fichero llamado
		 * resultado.txt que contenga la siguiente información: 111A,Juan,7.5 222B,Ana,9
		 * Si aparece un DNI en notas.txt que no existe en la colección creada en el
		 * apartado anterior, registrar el error en un fichero llamado log.txt,
		 * conservando la información que ya tuviera dicho fichero. Mostrar por pantalla
		 * el contenido generado en resultado.txt.
		 */

		Scanner sc = new Scanner(System.in);

		Path alum = Paths.get("alumnos2.txt");
		Path not = Paths.get("notas2.txt");
		HashMap<String, String> Alumnos = new HashMap<String, String>();
		BufferedReader leerFicheros1 = null;
		BufferedReader leerFicheros2 = null;
		BufferedReader leerFicheros3 = null;
		BufferedWriter EscribirBien = null;
		BufferedWriter EscribirMal = null;
		Charset charset = Charset.forName("UTF-8");

		try {
			leerFicheros1 = Files.newBufferedReader(alum);
			EscribirBien = Files.newBufferedWriter(Paths.get("RESULTADOS.TXT"), charset, CREATE);
			EscribirMal = Files.newBufferedWriter(Paths.get("LOG2.TXT"), charset, APPEND, CREATE);
			String line = null;

			while ((line = leerFicheros1.readLine()) != null) {

				String resultados[] = line.split(",");

				String dni = resultados[0];
				String nombre = resultados[1];

				Alumnos.put(dni, nombre);

			}

			leerFicheros2 = Files.newBufferedReader(not);

			while ((line = leerFicheros2.readLine()) != null) {

				String resultados[] = line.split(",");

				String dni1 = resultados[0];
				Double nota = Double.parseDouble(resultados[1]);

				if (Alumnos.containsKey(dni1)) {

					EscribirBien.write(dni1 + "," + Alumnos.get(dni1) + "," + nota);
					EscribirBien.newLine();

				} else {
					EscribirMal.write("NO ENCONTRADO"+dni1);
					EscribirMal.newLine();
				}
				
			}
			
			EscribirBien.close();
			
			leerFicheros3 = Files.newBufferedReader(Paths.get("RESULTADOS.TXT"));
			
			while ((line = leerFicheros3.readLine()) != null) {

				String resultados[] = line.split(",");
				
				String dni = resultados[0];
				String nombre = resultados[1];
				Double nota = Double.parseDouble(resultados[2]);
				
				System.out.println(dni+nombre+nota);
				
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			/* CERRAMOS LOS BUFFER PARA QUE FUNCIONE TODO CORRECTAMENTE */
			try {
				if (leerFicheros1 != null)
					leerFicheros1.close();
				if (leerFicheros2 != null)
					leerFicheros2.close();
				if (leerFicheros3 != null)
					leerFicheros3.close();
				if (EscribirBien != null)
					EscribirBien.close();
				if (EscribirMal != null)
					EscribirMal.close();
			} catch (IOException e) {
				System.out.println("ERROR");
			}

		}

		System.out.println("FIN DEL PROGRAMA");

	}

}
