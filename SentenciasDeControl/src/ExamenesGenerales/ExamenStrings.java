package ExamenesGenerales;

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
				codigo.toUpperCase();
				
				System.out.println(codigo);
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
			
			System.out.println("Introduce codigo articulo");
			codigo = sc.nextLine();
		}
		
		/*Gestionar pedido*/
		
		System.out.println("Quieres hacer pedido a domicilio?");
		boolean pedido=sc.nextBoolean();
		if(pedido) {
			//preguntar si es jubilado y la zona
			//incrementar la compra total del usuario con lo que vale hacer el envio
		}
		
	}

	public static boolean validarCodigo(String codigo) {
		
		/*if(codigo.length()<=5 && codigo.length()<=4 ) {
		
		}else
			return false;*/
		
		return true;
	}

	public static double CalcularPrecioTotal(String codigo,int unidades,double precioUnidad) {
		double importe=0;
		/*
		if (codigo.charAt(1)=='L')
			
		else if (codigo.charAt(1)=='P')
			
		else
		*/
			
		return importe;
		
	}

}
