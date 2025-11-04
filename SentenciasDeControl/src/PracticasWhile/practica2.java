package PracticasWhile;

import java.util.Scanner;

public class practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Dime un numero");
		num=sc.nextInt();
		
		while(num != 0) {
			if(num>0)
				System.out.println("positivo");
			else if (num<0) 
				System.out.println("negativo");
				num=sc.nextInt();
		}
		System.out.println("fin");
	}

}
