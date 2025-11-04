package practica5;

import java.util.Scanner;

public class Ejercico4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, cont=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un número (negativo para terminar):");
		num=sc.nextInt();
		while(num>=0) {
			cont++;
			System.out.println("Introduce un número (negativo para terminar):");
			num=sc.nextInt();
		}
		cont++; //Si quiero contar el negativo
		
		System.out.println("Has anotado:"+cont+" numeros");

	}

}
