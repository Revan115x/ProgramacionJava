package Practicas3if;

import java.util.Locale;
import java.util.Scanner;

public class practica5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double precio=0.05,distancia,dias,descuento,precioTotal;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Tu distancia de viaje es?");
		sc.useLocale(Locale.ENGLISH);
		distancia=sc.nextInt();
		
		System.out.println("cuantos dias??");
		sc.useLocale(Locale.ENGLISH);
		dias=sc.nextInt();
		
		
		precioTotal=distancia*precio;
		
		
		
		if(distancia>1000 && dias>7) {
			precioTotal=precioTotal*0.7; //precioTotal - precioTotal*0.3
			System.out.println("se te aplica un descuento del 30% y se queda en"+(precioTotal)+" €");
		}
		else
			System.out.println("tu viaje cuenta "+precioTotal+" €");
	}

}
