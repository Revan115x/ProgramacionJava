package ExamenesGenerales;

import java.util.Scanner;

public class examen_p1bucles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*lee una letra y despues lee letras hasta que tecleen
 * la anotada inicialmente y hay que decir cuantas letras
 * has leido distintas de la inicial*/		
		
		char letraI,letra;
		int cont=0;
		
		Scanner sc=new Scanner (System.in);
		System.out.println("introduccion letra");
		letra=sc.nextLine().charAt(0);
		
		System.out.println("introduccion otra letra");
		letraI=sc.nextLine().charAt(0);
		
		
		while(letra!=letraI) {
			
			cont++;
			System.out.println("introduce otra letra");
			letraI=sc.nextLine().charAt(0);
		}
		
		System.out.println("he leido:"+cont+"letras distintas a"+letra);
		
	}

}
