package PracticaArray;

import java.util.Arrays;
import java.util.Scanner;

public class ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Queremos llevar las ventas de 6 comerciales. Primero anota el nombre de los
		 * comerciales. Después, mientras lo desee el usuario lee el nombre de comercial
		 * y las unidades vendidas por éste y acumúlalas. Al finalizar muestra por cada
		 * comercial el número de ventas realizadas.
		 */

		Scanner sc = new Scanner(System.in);

		String nombre[] = new String[5];
		int ventas[] = new int[5];
		String buscar = null;

		// For para leer los nombres

		for (int i = 0; i < nombre.length; i++) {

			System.out.println("Nombres empleado");
			nombre[i] = sc.nextLine();

		}

		Arrays.sort(nombre);
		
		// for para leer las ventas

		for (int j = 0; j < ventas.length; j++) {

			System.out.println("ventas");
			ventas[j] = sc.nextInt();

		}

		//limpiar buffer despues de leer int
		
		sc.nextLine();
	
		// boolean para seguir en el bucle en caso de no encontrar al usuario
		boolean encontrado = false;

		//bucle para validar nombre
		do {

			System.out.println("nombre empleado");
			buscar = sc.nextLine();

			//for para pasar por cada usuario y leerlo
			
			for (int i = 0; i < nombre.length; i++) {

				if (buscar.equals(nombre[i])) {
					System.out.println("Ventas del usuario :" + ventas[i]);
					encontrado=true;
					break;
				}

			}
		} while (encontrado == false);
		
	}

}
