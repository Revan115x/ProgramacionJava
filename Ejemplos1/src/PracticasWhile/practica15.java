package PracticasWhile;

import java.util.Scanner;

public class practica15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("introduce numero:");
			num = sc.nextInt();
		} while (num < 0 || num > 10);
		{
			System.out.println("numero incorrecto");
			System.out.println("introduce numero (0-10):");
			num = sc.nextInt();
		}
		for (int i = 0; i <= 10; i++)
			System.out.println(num + " * " + i + " = " + num * 1);
	}

}
