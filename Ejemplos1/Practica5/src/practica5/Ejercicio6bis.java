package practica5;

import java.util.Scanner;

public class Ejercicio6bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int cont=0; //Variable de tipo contador
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce número:");
		num=sc.nextInt();
		while (num>=0) {
			cont++;
			System.out.println("Introduce número:");
			num=sc.nextInt();
		}
		System.out.println("Han anotado "+cont+" números");
		
	}

}
