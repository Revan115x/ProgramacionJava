package ejemplosClase.ejemplos;

import java.util.Scanner;

public class ejMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y;
		long r;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota x:");
		x=sc.nextInt();
		System.out.println("Anota y:");
		y=sc.nextInt();
		r=(int)Math.pow(x, y);
		System.out.println("La potencia es:"+r);
		r=Math.round(5.4);
		System.out.println("El número redondeado es:"+r);

	}

}
