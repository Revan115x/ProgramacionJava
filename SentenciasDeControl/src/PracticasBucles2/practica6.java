package PracticasBucles2;

import java.util.Scanner;

public class practica6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num, contador = 0, acumulador = 0;
		double media = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("di numero");
		num = sc.nextInt();
		while (num > 0) {
			contador += 1;
			acumulador = acumulador + num;
			media = acumulador / contador;
			System.out.println("introduce numeros");
			num = sc.nextInt();
		}
		System.out.println("el resultado de la media es" + media + +contador);

	}

}
