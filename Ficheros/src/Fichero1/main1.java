package Fichero1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta;
		Path fich;
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("RUTA DE TU ARCHIVO");
			ruta = sc.nextLine();
			System.out.println("NOMBRE DE TU ARCHIVO");
			String archivo = sc.nextLine();
			fich = Paths.get(ruta + "/" + archivo);
			int n = fich.getNameCount();
			if (Files.isDirectory(fich)) {
				System.out.println("ERROR: No existe el fichero");
			}else {
				for(int i=0;i<n;i++) {
					System.out.println(fich.getName(i));
				}
			}
			
		} while (!Files.exists(fich));
		
		System.out.println("******************");
		System.out.println(" FIN DEL PROGRAMA ");
		System.out.println("******************");
	}

}
