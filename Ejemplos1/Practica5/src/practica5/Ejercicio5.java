package practica5;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aleatorio,num,cont=1;
		Scanner sc=new Scanner(System.in);
		
		// Declaro la clase Random
		Random r=new Random();
		aleatorio=r.nextInt(10); //Me devuelve un número al azar entre 0 (incluido) y 10 (excluido)

		//System.out.println(aleatorio);
		
		System.out.println("Introduce número:");
		num=sc.nextInt();
		
		while(num!=aleatorio) {
			cont++;
			if (num<aleatorio)
				System.out.println("El número a adivinar es mayor que este");
			else
				System.out.println("el número a adivinar es menor que este");
			System.out.println("Introduce otro número:");
			num=sc.nextInt();
		}
		// Salgo porque num==aleatorio
		System.out.println("Enhorabuena has acertado en "+cont+" intentos");
		
		
	}

}
