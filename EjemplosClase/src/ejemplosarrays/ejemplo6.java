package ejemplosarrays;

import java.util.Arrays;
import java.util.Scanner;

public class ejemplo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[]=new int[10];
		
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<numeros.length;i++) {
			System.out.println("Anota número:");
			numeros[i]=sc.nextInt();
		}
		
		System.out.println("El array antes de ordenar:");
		for(int i=0;i<numeros.length;i++) {
			System.out.println(numeros[i]);
		}
		
		Arrays.sort(numeros);
		
		System.out.println("El array ordenado queda así:");
		for(int i=0;i<numeros.length;i++) {
			System.out.println(numeros[i]);
		}
		
		System.out.println("Anota número que quieres buscar:");
		int num=sc.nextInt();
		int pos=Arrays.binarySearch(numeros, num); //Solo funciona si el array está ordenado
		if (pos<0)
			System.out.println("El número buscado no existe");
		else
			System.out.println("Está en la posición:"+pos);
		
	}

}
