package PracticaArray;

import java.util.Arrays;
import java.util.Scanner;

public class ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Programa que lee 5 nombres de personas. Introducirlos en un array y
		 * ordenarlos alfabéticamente (usar método sort de la clase Arrays). Llevad otro
		 * array con el número de ventas de cada uno de ellos, inicialmente cero.
		 * Comprobar si otro nombre introducido después se encuentra entre esos 5.
		 */
		
		Scanner sc=new Scanner(System.in);
		
		char nombre=new char[5];
		
		for(int i=0;i<nombre();i++) {
		
		System.out.println("nombres empleado?");
		nombre=sc.nextLine.charAT(0);
		
		}
		
		Arrays.sort(nombre);

		for(int i=0;i<nombre.length();i++){
			
			System.out.println(nombre);
			
		}
		
	}

}
