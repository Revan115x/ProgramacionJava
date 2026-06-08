package ficheros;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		Path errores = Paths.get("log.txt");
		DirectoryStream<Path> LeerDirectorio;
		LinkedList<suscripcion> sub = new LinkedList<suscripcion>();
		LinkedList<nombre> correos = new LinkedList<nombre>();
		LinkedList<nif> nifs = new LinkedList<nif>();
		BufferedReader leer = null;
		BufferedWriter escribir = null;
		Charset charset = Charset.forName("UTF-8");
		Path suscripcion = Paths.get("suscripciones.txt");
		Path ruta = Paths.get("jose");
		BufferedReader leerf = null;
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		try {
			String line = null;
			leer = Files.newBufferedReader(suscripcion);
			while ((line = leer.readLine()) != null) {
				String separacion[] = line.split(",");

				String nif = separacion[0];
				LocalDate fecha = LocalDate.parse(separacion[1], d);
				double importe = Double.parseDouble(separacion[2]);

				nifs.add(new nif(nif, fecha, importe));

			}

			LeerDirectorio = Files.newDirectoryStream(ruta);
			// BufferedWriter Escribir = Files.newBufferedWriter(Paths.get("LOG.txt"),
			// charset, CREATE, APPEND);

			for (Path path : LeerDirectorio) {
				leerf = Files.newBufferedReader(path);
				
				while ((line = leerf.readLine()) != null) {

					String resultados[] = line.split(",");
					String nombre = resultados[0];
					String apellido = resultados[1];
					String Mail = resultados[2];

					correos.add(new nombre(nombre, apellido, Mail));
				}

			}
			
			for (suscripcion s: sub) {
				
				// NO YA LA VERDAD
				sub.add(new suscripcion(nifs.get(0).getNif(),correos.get(0).getNombre(),correos.get(0).getApellido(),correos.get(0).getMail(),nifs.get(0).getFecha(),nifs.get(0).getImporta()));
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/* CERRAMOS TODOS LOS BUFFERS */
			try {
				if (leer != null)
					leer.close();
				if (escribir != null)
					escribir.close();
				if (leerf != null)
					leerf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("");
		for (suscripcion s : sub) {
			System.out.println(s.toString());
		}

	}

}
