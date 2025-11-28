package PracticasBucles2;

import java.util.Scanner;

public class ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num,par=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce un numero");
		num=sc.nextInt();
		
		while(num<=2){
			System.out.println("incorrecto intantalo de nuevo");
			num=sc.nextInt();
		}
		System.out.println("numero leido correcto: "+num);
		
		while(par<=num) {
			System.out.println(par);
			par+=3;
		}
	}

}
