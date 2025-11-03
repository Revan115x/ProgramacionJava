package ejemplosfunciones;

import java.util.Scanner;

public class ejfuncion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int resultado;
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota número:");
		num=sc.nextInt();
		escribir(num);
	}
	
	public static void escribir(int num) {
		for(int i=1;i<=num;i++)
			System.out.println("Módulo ejecutándose");
		return;
	}

}
