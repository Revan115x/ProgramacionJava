package Practicas1if;

import java.util.Scanner;

public class practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double dolar, euro, cambio = 0.97, comision, total;

		Scanner sc = new Scanner(System.in);
		System.out.println("dime tu cantidad de dolares: ");
		dolar = sc.nextDouble();

		euro = dolar * cambio;

		System.out.println("tu cambio de dolar a euro es de:" + euro + "€");
		if (euro > 100) {
			comision = euro * 0.002;
			total = euro - comision;
			System.out.println("tu comision es de= " + comision + "€ tu total sera de= " + total + "€");
		}

		else {
			System.out.println("no te cobramos comision"+euro);
		}
	}

}
