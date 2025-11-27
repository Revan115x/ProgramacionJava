package Excepciones;

<<<<<<< HEAD
import java.util.Scanner;

public class ejercicio6 {
	static Scanner sc;
	public static void main(String[] args) throws rellenar {
=======
public class ejercicio6 {

	public static void main(String[] args) {
>>>>>>> f8041008b82d5457a2cdafb50ce48a1bcb2b1e17
		// TODO Auto-generated method stub

		/*
		 * 2. Lee dos cadenas. Haz una función que devuelva el número de veces que la
		 * primera está incluida en la segunda. Devuelve una excepción propia si
		 * cualquiera de las dos está vacía.
		 */
<<<<<<< HEAD
		
		
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
			
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int cadenarepite(String uno,String dos) throws rellenar {
		
		int cont=0;
		if(uno.equalsIgnoreCase(null)|| dos.equalsIgnoreCase(null)) {
			throw new rellenar ("Rellena el campo");
		}
		else if(uno.equals(dos))
			cont++;
		
		return cont;
=======

>>>>>>> f8041008b82d5457a2cdafb50ce48a1bcb2b1e17
	}

}
