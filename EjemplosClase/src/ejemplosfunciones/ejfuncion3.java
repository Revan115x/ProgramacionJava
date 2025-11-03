package ejemplosfunciones;

import java.util.Scanner;

public class ejfuncion3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int año;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Anota año:");
			año = sc.nextInt();
			if (año < 1000 || año >= 10000)
				System.out.println("Año incorrecto");
		} while (año < 1000 || año >= 10000);

		if (esBisiesto(año))
			System.out.println("Es bisiesto");
		else
			System.out.println("No es bisiesto");
	}

	public static boolean esBisiesto(int a) {
		/*
		 * if (a%4==0 && a%100!=0 || a%400==0) return true;
		 * 
		 * return false;
		 */
		return a % 4 == 0 && a % 100 != 0 || a % 400 == 0;

	}

}
