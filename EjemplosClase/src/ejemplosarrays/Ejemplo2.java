package ejemplosarrays;

import java.util.Locale;
import java.util.Scanner;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[10];
		int num, cont=0;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce 10 números:");

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("numeros " + i + ":");
			numeros[i] = sc.nextInt();
		}

		System.out.println("Ahora anota otro número:");
		num=sc.nextInt();
		
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i]==num)
				cont++;
		}
		
		System.out.println("El número "+num+" aparece "+cont+" veces");
		
	}

}
