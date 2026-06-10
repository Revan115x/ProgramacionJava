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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		//guardar errores
		Path errores = Paths.get("log.txt");
		//guardar los resultados buenos
		Path salidabien = Paths.get("NuevasSuscripciones.txt");
		//le indicamos la direccion del fichero que queremos leer
		Path suscripcion = Paths.get("suscripciones.txt");
		//le indamos toda la carpeta que vamos a leer
		Path carpeta = Paths.get("jose");
		//le pasamos la codificacion
		Charset charset = Charset.forName("UTF-8");
		//Hashmap para guardar el nif y el objeto
		HashMap<String, suscripcion> usuarios = new HashMap<String, suscripcion>();
		//leer lo de la carpeta
		DirectoryStream<Path> LeerDirectorio;
		//leer ficheros
		BufferedReader leer = null;
		BufferedWriter escribir = null;
		//escribir ficheros
		BufferedWriter escribirlog = null;
		BufferedReader leerf = null;
		//patron de la fecha
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/LL/yyyy");

		try {
			
			//le decimos que lea la carpeta
			LeerDirectorio = Files.newDirectoryStream(carpeta);
			String line = null;

			//for para leer los ficheros que tiene la carpeta
			for (Path path : LeerDirectorio) {
				//le decimos que lea dentro de los ficheros
				leerf = Files.newBufferedReader(path);

				//cada fichero tiene de titilo el nif haci que tenemos que sacarlo limpio
				String nombrefichero = path.getFileName().toString();
				String nif = nombrefichero.substring(2, nombrefichero.length() - 4);

				//bucle para leer los ficheros
				while ((line = leerf.readLine()) != null) {

					//sacamos un array y lo separamos por ","
					String resultados[] = line.split(",");
					String nombre = resultados[0];
					String apellido = resultados[1];
					String Mail = resultados[2];

					//creamos el objeto
					suscripcion s1 = new suscripcion(nombre, apellido, Mail);

					//y añadimos al hashmap el nif que sacamos y el objeto creado
					usuarios.put(nif, s1);
				}
			}

			//leemos el fichero suscripcion 
			leer = Files.newBufferedReader(suscripcion);

			//creamos los ficheros donde vamos a escribir dandole permisos
			escribir = Files.newBufferedWriter(salidabien, APPEND, CREATE);
			escribirlog = Files.newBufferedWriter(errores,charset, APPEND, CREATE);

			//bucle para leer los ficheros
			while ((line = leer.readLine()) != null) {
				//sacamos un array y lo separamos por ","
				String resultados[] = line.split(",");

				String nif = resultados[0];
				LocalDate fecha = LocalDate.parse(resultados[1], d);
				double importe = Double.parseDouble(resultados[2]);

				//ahora vamos a preguntarle si el nif que sacamos coincide con el del hashmap
				if (usuarios.containsKey(nif)) {

					//si coincide creamos un objeto con el mismo nif
					suscripcion s2 = usuarios.get(nif);

					//ahora creamos uno nuevo pero con los datos todos los datos anteriores
					suscripcion nueva = new suscripcion(nif, s2.getNombre(), s2.getApellido(), s2.getMail(), fecha,
							importe);

					//escribimos los datos en el fichero de resultados buenos
					escribir.write(
							nueva.getNif()+","
							+nueva.getNombre()+","
							+nueva.getApellido()+","
							+nueva.getMail()+","
							+nueva.getFecha()+","
							+nueva.getImporta()
							);

					escribir.newLine();

				} else {
					//si no coincide con el nif se escribe en los el nif 
					escribirlog.write("No encontrado nif " + nif);
					escribirlog.newLine();
				}

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
				if (escribirlog != null)
					escribirlog.close();
				if (leerf != null)
					leerf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("fin del programa");
		
	}

}
