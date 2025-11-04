package PracticasWhile;

import java.util.Locale;
import java.util.Scanner;

public class practica_3 {

	public static void main(String[] args) {
		
	double calibre;
	int contA=0,contB=0,contC=0;
	
	Scanner sc=new Scanner(System.in);
	sc.useLocale(Locale.ENGLISH);
	
	System.out.println("Introduce calibre fresa:");
	calibre=sc.nextDouble();
	
	while(calibre!=0) {
	
		if(calibre>=1 && calibre<=5)
			contB++;
		else
			if(calibre>5)
				contC++;
			else
				System.out.println("calibre no partence a ningun categoria");
			System.out.println("introduce calibre fresa");
			calibre=sc.nextDouble();
	}
	 System.out.println("Categoria A:"+contA+", Categoria B"+contB+" Categoria C:" +contC);
	 if(contA==0 || contB==0 || contC==0)
		 System.out.println("no ha habido fresas de todas las categorias");
	 else
		 System.out.println("Ha habido fresas de todas las categorias");
	}
	
}
