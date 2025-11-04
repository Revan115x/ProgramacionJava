package radar;

import java.util.Scanner;

public class radar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int distancia,segundos,velocidad;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("DISTANCIA");
		distancia=sc.nextInt();
		
		System.out.println("TU VELOCIDAD MAXIMA");
		velocidad=sc.nextInt();
		
		System.out.println("SEGUNDOS RECORRIDOS DURANTE EL TRAMO");
		segundos=sc.nextInt();
		
		if(segundos<=300)
			System.out.println("multa has superado un tallecto de 500 min en"+segundos);
		if (velocidad>=110)
				System.out.println("multa has superado la velocidad de 110km por"+velocidad);
		else
				System.out.println("OK");
		
			
		
	}

}
