package Examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Double presupuesto, precioUnidad,totalcomprausuario = 0;
		String codigo;
		int unidades;
		Random r = new Random();

		Scanner sc = new Scanner(System.in);

		System.out.println("Anota tu presupuesto");
		presupuesto = sc.nextDouble();

		System.out.println("Introduce codigo articulo");
		codigo = sc.nextLine();

		/* Bucle para validar codigo */

		while(codigo.equalsIgnoreCase("fin") == false){

			while (!validarCodigo(codigo)) {
				System.out.println("Introduce codigo articulo");
				codigo = sc.nextLine();
			}

			unidades = r.nextInt(4) + 1;

			do {
				System.out.println("Anota precio unidad");
				precioUnidad = sc.nextDouble();
				if (precioUnidad <= 0);

			} while(precioUnidad <= 0);
			
			double precioproducto=CalcularPrecioTotal(codigo,unidades,precioUnidad);
			if(totalcomprausuario+precioproducto>presupuesto)
				System.out.println("Presupuesto superado retira articulo");
			else
				totalcomprausuario+=precioproducto;
				
		}
	}


	public static boolean validarCodigo(String codigo) {
		return true;
	}

	public static double CalcularPrecioTotal(String codigo,int unidades,double precioUnidad) {
		double importe=0;
		
		if(codigo.charAt(1)==L)
		
		
	}

}
