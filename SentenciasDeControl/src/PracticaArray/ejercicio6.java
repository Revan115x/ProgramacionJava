package PracticaArray;

import java.util.Scanner;

public class ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Leed números de teclado del 0 al 9 hasta que lo desee el usuario. Mostrad al
		 * finalizar cuántos números se han leído de cada uno. Usad un array de
		 * frecuencias.
		 */
		
		Scanner sc=new Scanner(System.in);
		
		int frecuencia[]=new int[10];
		int cont=1,num;
		boolean seguir=false;
		
		do {
			
			System.out.println("que numero");
			num=sc.nextInt();
			
			for(int i=0;i<frecuencia.length;i++) {
				
				if(num==i) {
					frecuencia[i]=frecuencia[i]+cont;
				}
				
			}
			
			sc.nextLine();
			
			System.out.println("quieres seguir");
			seguir=sc.nextBoolean();
			
			if(seguir==false) {
				System.out.println("FIN DEL PROGRAMA");
				break;
			}
			
		}while(seguir);
		
		for(int i=0;i<frecuencia.length;i++) {
			
			System.out.println(frecuencia[i]);
			
		}
	
	}

}
