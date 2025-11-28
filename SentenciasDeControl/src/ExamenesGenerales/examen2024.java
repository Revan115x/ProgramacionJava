package ExamenesGenerales;

import java.util.Scanner;

public class examen2024 {

	public static void main(String[] args) {

		
		char tipo;
		int a=450,b=400,c=350,edad;
		boolean beca=true;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Que tipo de vida nivel de vida tienes (a/b/c)");
		tipo=sc.nextLine().charAt(0);
		
		switch(tipo) {
		case 'A':
		case 'a':
			System.out.println("La beca es de "+a+" euros al mes.");
			break;
		case 'B':
		case 'b':
			System.out.println("La beca es de "+b+" euros al mes.");
			break;
		case 'C':
		case 'c':
			System.out.println("La beca es de "+c+" euros al mes.");
			break;
		default:
			System.out.println("no tienes beca");
		}
		
		System.out.println("Que edad tienes?");
		edad=sc.nextLine().charAt(0);
		
		System.out.println("tienes beca (true/false)?");
		beca=sc.nextBoolean();
		
		/*System.out.println("en que ciudad vives?");
		ciudad=sc.nextLine().charAt(0);*/
		
		if(edad<18)
			System.out.println("cobra 250 euros mas tu "+tipo);
		else if(beca=true || edad>18 )
			System.out.println("cobra 100 euros mas tu "+tipo);
	}
	
}
