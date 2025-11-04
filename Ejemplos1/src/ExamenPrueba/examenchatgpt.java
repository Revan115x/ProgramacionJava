package ExamenPrueba;

import java.util.Scanner;

public class examenchatgpt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pasajeros, edad;
		boolean ok = true;a
		char tipo;
		double precio = 0,descuento=0,precioTotal=0;

		Scanner sc = new Scanner(System.in);
		System.out.println("cuantas personas viajan?");
		pasajeros = sc.nextInt();

		System.out.println("cuantos años tienes?");
		edad = sc.nextInt();

		sc.nextLine();

		System.out.println("que tipo de viaje eliges?(T/N/E)");
		tipo = sc.nextLine().charAt(0);

		switch (tipo) {
		case 'T':
		case 't':
			precio = 50;
			break;
		case 'N':
		case 'n':
			precio = 40;
			break;
		case 'E':
		case 'e':
			precio = 30;
			break;aaaaaa
			System.out.println("Error");
			ok = false;
		}

		if (ok == true) {

			if (edad < 18) {
				descuento = 20 / (double) 100 * precio;
				precioTotal=descuento-precio;
				System.out.println("descuento del 20% por menor de edad, total =" + precioTotal);
			} else if (pasajeros >= 4) {
				descuento = 15 / (double) 100 * precio;
				precioTotal=descuento-precio;
				System.out.println("tienes un descuento de 15%, tu total es = " + precioTotal);
			} else {
				System.out.println("no tienes descuento");
			}
		}
		
		if(precioTotal %1 !=0) {
			System.out.println("el importe tiene decimales");
		}else {
			System.out.println("el importe no tiene decimales");
		}

	}

}
