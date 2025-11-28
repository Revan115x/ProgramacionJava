package EjemplosClaseVariados;

import java.util.Scanner;

public class Cuatro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2;
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce un número:");
		num1=entrada.nextInt();
		System.out.println("Introduce otro número:");
		num2=entrada.nextInt();
		/*
		if (num1==num2)
			System.out.println("Son iguales");
		else
			System.out.println("Son distintos");
		*/
		
		if (num1!=num2)
			System.out.println("Son distintos");
		else
			System.out.println("Son iguales");
	}

}
