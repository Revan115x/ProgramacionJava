package Examen;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, pedidos> DestinosN = new HashMap<>();
		LinkedList<pedidos> amazon = new LinkedList<pedidos>();
		HashMap<String, pedidos> Usuario = new HashMap<>();
		Path ruta=Paths.get("Jose");
		DirectoryStream<Path>LeerDirectorio=null;
		BufferedReader leer=null;
		BufferedWriter escribir=null;
		Charset charset = Charset.forName("UTF-8");
		
		if(!Files.exists(ruta))
			System.out.println("La ruta no existe");
		if(!Files.isDirectory(ruta))
			System.out.println("No es un directorio");
		
		
		
		try {
			LeerDirectorio=Files.newDirectoryStream(ruta);
			//escribir=Files.newBufferedWriter(Paths.get("Jose\txt"),charset,CREATE, WRITE);
			for(Path path : LeerDirectorio ) {
				if(Files.isRegularFile(path)) {
					if(!path.getFileName().toString().startsWith("pedidos.txt")) {
						System.out.println("Eliminado archivos...");
						
						/*FUNCIONA PERO AL PRINCIO NO COMPILA,BORRA LOS ARCHIVOS MENOS EL DE PEDIDOS*/
						/*LO DEMAS COMPILA SIN PROBLEMAS*/
						
						Files.delete(path);
					}
				}
				
				leer=Files.newBufferedReader(path);
				String line=null;
				
				while ((line = leer.readLine()) != null) {
				
					try {
						String resultados[] = line.split(",");
						int num=Integer.parseInt(resultados[0].trim());
						double precio = Double.parseDouble(resultados[1].trim());
						String cod = resultados[2].trim();
						String Destino = resultados[3].trim();
						
						
						String formato="^[a-zA-Z]{5,6}[0-9]{1,2}$";
						
						if(formato.matches(cod))
							System.out.println("error en formato");						
							
						pedidos a=new pedidos(num,precio,cod,Destino);
						
						DestinosN.put(Destino, a);
						
						Usuario.put(cod, a);
						
						int posicion = pos(amazon, a);

						amazon.add(posicion,a);
						
						
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
			
			System.out.println("\n**********MOSTRAMOS LA INFORMACION DEL LINKEDLIST**********\n");
			for(pedidos al : amazon) {
				System.out.println(al.toString());
			}
			
			
			System.out.println("\n**********DATOS DESTINOS NO REPETIDOS**********\n");
			 for (String clave : DestinosN.keySet()) {
		            System.out.println("Destino :"+ clave);
		            System.out.println(DestinosN.toString());
		        }
			 
			 System.out.println("\n**********DATOS OEDIDOS CLIENTE**********\n");
			 for (String clave : Usuario.keySet()) {
		            System.out.println("Usuario :"+ clave);
		            System.out.println(DestinosN.toString());
		           // escribir.write(clave);
		        }
			
			 //escribir.close();
			 LeerDirectorio.close();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin del programa");
		
	}
	
	public static int pos(LinkedList<pedidos> amazon, pedidos datos) {

		/* leermos la clase */
		for (int i = 0; i < amazon.size(); i++) {
			
			if(datos.getNumPedido()<=amazon.get(i).getNumPedido())
				return i;

		}
		return amazon.size();
	}

}
