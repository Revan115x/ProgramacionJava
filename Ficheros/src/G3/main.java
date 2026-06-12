package G3;

import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leer clientes.txt y almacenar la información en una colección adecuada.
		 * Recorrer pedidos.txt y crear un fichero: facturas.txt con el formato:
		 * 111A,Juan,120 333C,Pedro,50 222B,Ana,80 Si un DNI de pedidos.txt no existe en
		 * clientes, registrar el error en: log.txt sin borrar los errores anteriores.
		 * Mostrar por pantalla el cliente que ha realizado el pedido de mayor importe.
		 */

		Path clientes = Paths.get("clientes.txt");
		Path pedidos = Paths.get("pedidos.txt");
		BufferedReader clientesLeer = null;
		BufferedReader pedidosLeer = null;
		BufferedWriter EscribirLog = null;
		BufferedWriter EscribirFactura = null;
		HashMap<String, String> cl = new HashMap<String, String>();

		try {

			String line = null;
			EscribirFactura=Files.newBufferedWriter(Paths.get("facturas.txt"),CREATE,TRUNCATE_EXISTING);
			EscribirLog=Files.newBufferedWriter(Paths.get("log.txt"), CREATE,TRUNCATE_EXISTING);
			clientesLeer = Files.newBufferedReader(clientes);
			System.out.println("leyendo clientesLeer");
					
			while ((line = clientesLeer.readLine()) != null) {
				String resultados[] = line.split(",");
				String dni = resultados[0];
				String nombre = resultados[1];

				cl.put(dni, nombre);

			}
			
			System.out.println("leyendo pedidosLeer");
			pedidosLeer = Files.newBufferedReader(pedidos);
			while ((line = pedidosLeer.readLine()) != null) {
				String resultados[] = line.split(",");
				String dni2 = resultados[0];
				Double precio = Double.parseDouble(resultados[1]);
				
				if(cl.containsKey(dni2)) {
					EscribirFactura.write(
							dni2+","
							+cl.get(dni2)+","
							+precio
							);
					EscribirFactura.newLine();
					System.out.println("Escribiendo en facturas.txt");
					
				}else {
					EscribirLog.write("DNI NO TIENE PEDIDO : "+dni2);
					EscribirLog.newLine();
					System.out.println("Escribiendo en EscribirLog");

				}
			}

		} catch (IOException e) {
			System.out.println("ERROR");
		} finally {
			/* CERRAMOS LOS BUFFER PARA QUE FUNCIONE TODO CORRECTAMENTE */
			try {
				if (clientesLeer != null)
					clientesLeer.close();
				if (pedidosLeer != null)
					pedidosLeer.close();
				if (EscribirLog != null)
					EscribirLog.close();
				if (EscribirFactura != null)
					EscribirFactura.close();
			} catch (IOException e) {
				System.out.println("ERROR");
			}
		}
		
		System.out.println("FIN DEL PROGRAMA");
		
	}

}
