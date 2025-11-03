package ejemplosClase.ejemplos;

import java.util.Scanner;

public class ejswitch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int posicion;
		Scanner entrada=new Scanner(System.in);
		System.out.println("Escribe el puesto en el que has quedado:");
		posicion=entrada.nextInt();
		/*
		if (posicion==1)
			System.out.println("ORO");
		else
			if (posicion==2)
				System.out.println("PLATA");
			else
				if (posicion==3)
					System.out.println("BRONCE");
				else
					System.out.println("Sin premio");
		*/
		switch(posicion) {
			case 1:
				System.out.println("ORO");
				break;
			case 2:
				System.out.println("PLATA");
				break;
			case 3:
				System.out.println("BRONCE");
				break;
			case 4:
			case 5:
				System.out.println("Te llevas una camiseta");
				break;
			default:
				System.out.println("Sin premio");
		}
		System.out.println("Adios");
		

	}

}
