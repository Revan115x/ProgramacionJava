package G2;

import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leer todos los ficheros de la carpeta. Crear una colección adecuada que evite
		 * almacenar productos repetidos. Generar un fichero llamado:
		 * productos_validos.txt con los productos cuyo precio sea superior a 20€.
		 * Mostrar por pantalla el número total de productos distintos encontrados.
		 */

		String codigo, nombre;
		Double Precio;
		int cont=0;
		DirectoryStream<Path> LeerDirectorio = null;
		Path Ruta = Paths.get("Carpeta productos");
		BufferedReader leer = null;
		BufferedWriter escribir = null;
		HashSet<String> productos = new HashSet<String>();

		try {
			LeerDirectorio = Files.newDirectoryStream(Ruta);
			escribir = Files.newBufferedWriter(Paths.get("productos_validos.txt"), CREATE, TRUNCATE_EXISTING);
			String line = null;

			for (Path path : LeerDirectorio) {

				System.out.println("LEYENDO FICHERO");

				leer = Files.newBufferedReader(path);

				while ((line = leer.readLine()) != null) {

					String resultados[] = line.split(",");
					codigo = resultados[0];
					nombre = resultados[1];
					Precio = Double.parseDouble(resultados[2]);

					Producto a = new Producto(codigo, nombre, Precio);

					if (!productos.contains(a.getnombre())) {
						productos.add(nombre);

						if (a.getPrecio() > 20) {

							cont++;
							escribir.write(codigo + "," + nombre + "," + Precio);

							escribir.newLine();
							System.out.println("Escribiendo");
						}

					} else
						System.out.println("REPETIDO");
				}

			}

		} catch (IOException e) {
			System.out.println("ERROR");
		} finally {
			try {
				if (escribir != null)
					escribir.close();
				if (leer != null)
					leer.close();
				if (LeerDirectorio != null)
					LeerDirectorio.close();
			} catch (IOException e) {
				System.out.println("ERROR");
			}

		}

		System.out.println("número total de productos distintos encontrados "+cont);
		System.out.println("FIN DEL PROGRAMA");

	}

}
