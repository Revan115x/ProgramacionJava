package Fichero11.copy;

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

		InputStream istream1 = null,istream2=null;
		OutputStream ostream = null;

		try {
			
			istream1 = Files.newInputStream(salida1);
			istream2 = Files.newInputStream(salida2);
			ostream = Files.newOutputStream(entrada);

			/*while ((c = (byte) istream1.read()) != -1) {
				c=(byte)istream1.read();
				if(c!=-1) {
					ostream.write(c);
					c=(byte)istream2.read();
					if(c!=-1) {
						ostream.write(c);
					}
				}
			}*/
			
			byte c1,c2;
			while((c1=(byte)istream1.read())!=-1 && (c2=(byte)istream2.read())!=-1){
				ostream.write(c1);
				ostream.write(c2);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (istream1 != null)
					istream1.close();
				if (istream2 != null )
					istream2.close();
				if(ostream != null)
					ostream.close();
			} catch (IOException e) {
				System.out.println("ERROR CERRANDO FICHERO");
			}
		}
		
		System.out.println("Fin del programa.");

	}

}
