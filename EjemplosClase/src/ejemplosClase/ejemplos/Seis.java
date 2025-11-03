package ejemplosClase.ejemplos;

import java.util.Scanner;

public class Seis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marcas,programacion;
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce nota marcas:");
		marcas=entrada.nextInt();
		System.out.println("Introduce nota programacion:");
		programacion=entrada.nextInt();
		/*
		if (marcas>=5 && programacion>=5)
			System.out.println("Has aprobado las dos");
		else
			if (marcas<5 && programacion<5)
				System.out.println("Has suspendido las dos");
			else
				System.out.println("Sólo has aprobado una");
		*/
		/*
		if (marcas>=5) {
			if (programacion>=5)
				System.out.println("Has aprobado las dos");
			else
				System.out.println("Sólo has aprobado una");
		}
		else {
			if (programacion>=5)
				System.out.println("Sólo has aprobado una");
			else
				System.out.println("Has suspendido las dos");
				
		}
		*/
		if (marcas>=5 && programacion>=5)
			System.out.println("Has aprobado las dos");
		if (marcas<5 && programacion<5)
			System.out.println("Has suspendido las dos");
		if ((marcas>=5 && programacion<5) || (marcas<5 && programacion>=5))
			System.out.println("Sólo has aprobado una");
		
	}

}
