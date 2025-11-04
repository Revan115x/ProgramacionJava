package ejerciciosString;

import java.util.Scanner;

public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		String palabra="casa";
		String palabra1="CASA";
		String nombre="";
		
		System.out.println("nombre");
		nombre=sc.nextLine();
		nombre=nombre.toUpperCase();
		
		System.out.println("EL CHAR AHORA DEBERIA PASAR A MINISCULAS "+nombre);
		
		boolean si= Palabras(palabra,palabra1);
		
		System.out.println("la palabra es "+si);
		
		
	}
	
	public static boolean Palabras(String texto1,String Texto2) {
		
		if(texto1.equalsIgnoreCase(Texto2))
			return true;
		else 
			return false;
		
	}

}
