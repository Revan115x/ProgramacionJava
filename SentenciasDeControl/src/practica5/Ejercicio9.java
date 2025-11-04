package practica5;

import java.util.Locale;
import java.util.Scanner;

//TODO Auto-generated method stub
		//Dadas las edades y alturas de 5 alumnos, mostrar la edad y la estatura media, la
		//cantidad de alumnos mayores de 18 años, y la cantidad de alumnos que miden más
		//de 1.75.
public class Ejercicio9 {

	public static void main(String[] args) {
		int edad, sumaEdad=0, contMay=0, contMasAltos=0;
		double altura, sumaAltura=0;
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		
		for(int i=1;i<=5;i++) {
			System.out.println("Introduce edad:");
			edad=sc.nextInt();
			sumaEdad=sumaEdad+edad;
			System.out.println("Introduce altura:");
			altura=sc.nextDouble();
			sumaAltura=sumaAltura+altura;
			if (edad>18)
				contMay++;
			if (altura>1.75)
				contMasAltos++;
		}
		
		System.out.println("Hay "+contMay+" personas mayores de 18 años");
		System.out.println("Hay "+contMasAltos+" personas de más de 1.75");
		System.out.println("La media de edad es:"+ (double)sumaEdad/5);
		System.out.println("La media de altura es:"+ sumaAltura/5);
		
	}

}
