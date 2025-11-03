package ejemplosClase.ejemplos;

import java.util.Scanner;

public class ejFuncion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2,resultado;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un número:");
		num1=sc.nextInt();
		System.out.println("Introduce otro número:");
		num2=sc.nextInt();
		resultado=(int)suma(num1,num2);
		System.out.println("La suma es:"+resultado);
	}
	
	public static double suma(double a,double b) {
		double r;
		r=a+b;
		return r;
	}

}
