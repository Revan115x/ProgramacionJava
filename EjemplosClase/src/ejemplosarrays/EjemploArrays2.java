package ejemplosarrays;

import java.util.Scanner;

public class EjemploArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]= new int[5];
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<numeros.length;i++) {
			System.out.println("Introduce número en la posición "+i+":");
			numeros[i]=sc.nextInt();
		}
		
		System.out.println("Números leidos:");

		for(int i=0;i<numeros.length;i++) {
			System.out.println(numeros[i]);
		}

	}

}
