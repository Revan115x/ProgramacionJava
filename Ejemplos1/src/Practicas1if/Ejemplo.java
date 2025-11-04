package Practicas1if;

import java.util.Scanner;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un numero");
		numero=sc.nextInt();
		
		if(numero>0){
			System.out.println("el numero es positivo");
				if(numero>100)
					System.out.println("es mayor a 100");}
		else{
			if(numero < 0)
				System.out.println("El numero es negativo");
			else
				System.out.println("El numero es 0");
		}
		
		/*if(numero==0)
			System.out.println("es cero");
		System.out.println("Fin del programa");*/
	}

}
