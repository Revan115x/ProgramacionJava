package EjemplosFunciones;

import java.util.Locale;
import java.util.Scanner;

public class ejfuncion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double precioInicial,precioFinal,descuento;
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		System.out.println("Anota precio inicial:");
		precioInicial=sc.nextDouble();
		System.out.println("Anota precio final:");
		precioFinal=sc.nextDouble();
		descuento=calcularDescuento(precioInicial,precioFinal);
		System.out.println("Te han aplicado:"+descuento+"% de descuento");
	}
	
	public static double calcularDescuento(double pInicial,double pFinal) {
		double r=(pInicial-pFinal)*100/pInicial;
		return r;
	}

}
