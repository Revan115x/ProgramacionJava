package Practicas1if;

import java.util.Scanner;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		double nota;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("dime tu nota");
		nota=sc.nextInt();
		
			if(nota>5) {
				System.out.println("estas aprobado");
			}
			else {
				System.out.println("estas suspenso");
			}
	}

}
