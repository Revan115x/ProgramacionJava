package PracticasBucles2;

import java.util.Scanner;

public class practica5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num=4,yo;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("di un numero");
		yo=sc.nextInt();
		
		while(yo!=num){
			if(num<yo)
				System.out.println("mayor");
			else if(num>yo)
				System.out.println("menor");
				yo=sc.nextInt();
		}
		
		System.out.println("ganaste");
		
	}

}
