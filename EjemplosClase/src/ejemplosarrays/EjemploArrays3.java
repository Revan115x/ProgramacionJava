package ejemplosarrays;

import java.util.Scanner;

public class EjemploArrays3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadenas[]= new String[4];
		String otra[];
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<cadenas.length;i++) {
			System.out.println("Introduce cadena en la posición "+i+":");
			cadenas[i]=sc.nextLine();
		}
		
		System.out.println("Cadenas leidas:");

		for(int i=0;i<cadenas.length;i++) {
			System.out.println(cadenas[i]);
		}
		otra=cadenas;
		
		otra[2]="mañana";

		for(int i=0;i<cadenas.length;i++) {
			System.out.println(cadenas[i]);
		}
	}

}
