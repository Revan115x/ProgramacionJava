package Empresa;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int numero,planta;
		double metros;
		double alquilado;
		
		Empresa alquiler[]=new Empresa[5];
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<alquiler.length;i++) {
			
			System.out.println("Numero");
			numero=sc.nextInt();
			
			System.out.println("Planta?");
			planta=sc.nextInt();
			
			System.out.println("Metros cuadrados del garaje:");
		    metros = sc.nextDouble();

		    alquiler[i] = new Empresa(numero, metros, planta);
			
		}
		
	}

}
