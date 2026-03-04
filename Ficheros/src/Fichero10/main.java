package Fichero10;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @descrition Clase que nos permite leer un archivo byte a byte de forma
 *             secuencial sin buffer
 */
public class main {

	public static void main(String[] args) {
		Path entrada = Paths.get("/home/inf1/Desktop/Programacion/ProgramacionJava/Ficheros/texto");
		Path salida = Paths.get("/home/inf1/Desktop/Programacion/ProgramacionJava/Ficheros/texto2");
		// Array de bytes para leer todos los bytes del archivo
		InputStream istream = null;
		OutputStream ostream = null;
		int c;
		/*Expresion que contiene las vocales*/
		String vocales = "[aeiouAEIOU]";
		try {
			// InputStream y OutputStream de java.io nos permiten trabajar byte a byte y abre el fichero
			// Los generamos de forma eficiente utilizando java.nio
			istream = Files.newInputStream(entrada);
			ostream = Files.newOutputStream(salida);
			while ((c = istream.read()) != -1) {
				// Escribimos todos los bytes en el archivo salida
				// Despu�s de ejecutar comprobar que es igual a entrada
				
				/*paso int c a char para luego pasar char a string */
				char pars = (char) c;
				String letra = "" + pars;

				/*ya teniendo pasado a string comparamos con vocales si*/
				if (!letra.matches(vocales)) {
					/*si no coinciden las vocales escribe en ostream*/
					ostream.write(c);
				}

			}

			/*cerramos fichero*/
			istream.close();
			ostream.close();

		} catch (IOException io) {
			System.err.println(io);
		}

		System.out.println("Fin del programa");

	}
}
