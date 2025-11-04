package Practicas1if;

import java.util.Scanner;

public class fundamentos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 /*
		  * escribir "introduce un numero positivo"
		  * leer numero
		  * si numero es par
		  * 	si numero es multiplo de 3
		  * 		escribir "ñam ñam se lo comen el monstruo y el dragon"
		  * 	sino
		  * 		escribir "ñam ñam se lo como el monstruo"
		  *sino
		  *		si numero es multiplo 3
		  *			escribir "ñam ñam se lo como el dragan"
		  *		sino
		  *			escubir "el montruo lo escupe"
		  *
		  * 	 
	
		  */
		int numero;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce un numero positivo");
		numero=sc.nextInt();
		
		if(numero%2 ==0) {
			if(numero%3 ==0)
				System.out.println("ñam ñam se lo comen el monstruo y el dragon");
			}
			else if (numero%2 ==0)
				System.out.println("ñam ñam se lo como el monstruo");
		
			else if (numero%3==0)
					System.out.println("ñam ñam se lo como el dragon");
				else
					System.out.println("el montruo lo escupe");
		}	
	}

