package ejemplosarrays;

import java.util.Scanner;

/**
 * Programa que lee cadenas hasta anotar fin y las guarda en un array.
 * Máximo 10 cadenas.
 * Luego las muestra.
 */
public class Ejemplo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadenas[]=new String[10];
		String cadena;
		int cont=0;
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<cadenas.length;i++) {
			System.out.println("Introduce cadena:");
			cadena=sc.nextLine();
			if (cadena.equalsIgnoreCase("fin"))
				break;
			cadenas[i]=cadena;
			cont++;
		}
	
		System.out.println("Cadenas leidas:");

		for(int i=0;i<cont;i++) {
			System.out.println(cadenas[i]);
		}
	}

}
