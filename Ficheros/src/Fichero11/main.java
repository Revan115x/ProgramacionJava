package Fichero11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 11. Una pequeña empresa ha ideado un método para que sus archivos viajen por
		 * la red sin que nadie pueda acceder a sus datos. Para ello cada vez que va a
		 * enviar uno de ellos lo transforma en dos archivos, que son los que envía, de
		 * la siguiente manera:
		 * 
		 * Tema 11: Ficheros Módulo: Programación
		 * 
		 * Página - 2
		 * 
		 * Fichero: Estimado señor ....... F1: Etmd eo F2: siaosñr Implementar dos
		 * procesos, uno para pasar del fichero original a los dos transformados y otro
		 * para construir el original a partir de esos dos.
		 */

		int cont = 0;
		byte c;
		Path entrada = Paths.get("entrada.txt");
		Path salida1 = Paths.get("salida1.txt");
		Path salida2 = Paths.get("salida2.txt");

		InputStream istream = null;
		OutputStream ostream1 = null, ostream2 = null;

		try {
			
			istream = Files.newInputStream(entrada);
			ostream1 = Files.newOutputStream(salida1);
			ostream2 = Files.newOutputStream(salida2);

			while ((c = (byte) istream.read()) != -1) {
				if (cont % 2 == 1)
					ostream1.write(c);
				else
					ostream2.write(c);
				cont++;
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (istream != null)
					istream.close();
				if (ostream1 != null )
					ostream1.close();
				if(ostream2 != null)
					ostream2.close();
			} catch (IOException e) {
				System.out.println("ERROR CERRANDO FICHERO");
			}
		}
		
		System.out.println("Fin del programa.");

	}

}
