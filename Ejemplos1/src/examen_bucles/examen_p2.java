package examen_bucles;

import java.util.Scanner;

public class examen_p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1,num2,menor=0,mayor=0,suma=0;
		
		Scanner sc=new Scanner (System.in);
		System.out.println("introude primer numero:");
		num1=sc.nextInt();
		System.out.println("introduce segundo numero");
		num2=sc.nextInt();
		
		if(num1==num2)
			System.out.println("son iguales");
		else
			if(num1<num2) {
				menor=num1;
				mayor=num2;
			}
			else {
				menor=num2;
				mayor=num1;
			}
		for(int i=menor+1;i<mayor;i++) {
			if(i%2==0)
				suma=suma+1;
			
		}
		
		System.out.println(suma);
		
	}

}
