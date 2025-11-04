package practica5;

import java.util.Scanner;
//Cuento los números pares hasta que me anoten un número negativo
public class Ejercico4Nuevo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, cont=0,contPares=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce un número (negativo para terminar):");
		num=sc.nextInt();
		while(num>=0) {
			cont++;
			if (num%2==0)
				contPares++;
			System.out.println("Introduce un número (negativo para terminar):");
			num=sc.nextInt();
		}
		/*cont++; Si quiero contar el negativo*/
		
		System.out.println("Has anotado:"+cont+" numeros, de los cuales:"+contPares+" son pares");

	}

}
