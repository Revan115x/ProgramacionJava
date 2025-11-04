package PracticasWhile;

import java.util.Locale;
import java.util.Scanner;

public class practica_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int niños,adulto,contgrupo=0,entradas,grupo;
		 final double adultoN=3,adultoR=2,niñosN=2,niñosR=1.2;
		 double importeF=0,importeA=0,importeN=0;
		 
		 Scanner sc = new Scanner(System.in);
		 sc.useLocale(Locale.ENGLISH);
		 
		 do {
			 System.out.println("Cantidad de personas");
			 grupo=sc.nextInt();
			 
			 System.out.println("Cantidad de personas");
			 adulto=sc.nextInt();
			 
			 System.out.println("Hay algun menor?");
			 niños=sc.nextInt();
			 
			 
			 
				 
		 }while(importeF>100);
		
	}

}
