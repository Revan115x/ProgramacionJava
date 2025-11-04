package Practicas3if;

import java.util.Locale;
import java.util.Scanner;

public class practica6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int precio,descuento2,descuento1,precioTotal;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Tu distancia de viaje es?");
		precio=sc.nextInt();
		
		if(precio<6)
			System.out.println("no tienes descuento");
		else
			if(precio<=6 && precio<60) {
				p
				System.out.println("tienes descuento del 5%"+(precio));
			}
	}

}
