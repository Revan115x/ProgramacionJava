package Fichero1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta;
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("RUTA DE TU ARCHIVO");
			ruta = sc.nextLine();
			System.out.println("RUTA DE TU ARCHIVO");
			String archivo = sc.nextLine();
			Path fich = Paths.get(ruta + "/" + archivo);
			if (!Files.exists(fich)) {
				
			}
				
		} while (ruta.equalsIgnoreCase("salir"));
			
		System.out.println("fin del programa");
		
	}

}
