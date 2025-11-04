package Practicas2if;

import java.util.Scanner;

public class practica11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

int n1,n2;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce primer numero");
		n1=sc.nextInt();
		System.out.println("introduce segundo numero");
		n2=sc.nextInt();
		
		if (n1>0 && n2>0) {
			System.out.println("la resta es"+ (n1-n2));
		}
		if(n1<0 &&n2<0) { 
			System.out.println("la resta es"+ (n1-n2));
		}	
		if(n1==0 || n2==0)
			System.out.println("Al menos uno es nulo");
	}
}
