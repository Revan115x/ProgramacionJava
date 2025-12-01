package PracticapaqueteyExcepciones;

import java.util.Scanner;

public class ejercicio2 {
	static Scanner sc;
	public static void main(String[] args) throws rellenar {
		// TODO Auto-generated method stub

		/*
		 * 2. Lee dos cadenas. Haz una función que devuelva el número de veces que la
		 * primera está incluida en la segunda. Devuelve una excepción propia si
		 * cualquiera de las dos está vacía.
		 */

		String cadena1;
		String cadena2;
		int veces;
		
		sc=new Scanner(System.in);
		
		try {
			System.out.println("Primera cadena");
			cadena1=sc.nextLine();
			System.out.println("segunda cadena");
			cadena2=sc.nextLine();
			
			veces=cadenarepite(cadena1,cadena2);
			System.out.println(+veces);
			
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int cadenarepite(String uno,String dos) throws rellenar {
		
		int cont=0,pos=0;
		if(uno.length()==0 || dos.length()==0) {
			throw new rellenar ("Rellena el campo");
		}
		
		pos=uno.indexOf(dos,pos);
		
		while(pos!=-1) {
			cont++;
			pos=uno.indexOf(dos,pos+dos.length());
		}
		
		return cont;
	}

}
