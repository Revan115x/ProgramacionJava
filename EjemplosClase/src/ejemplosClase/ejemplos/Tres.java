package ejemplosClase.ejemplos;

import java.util.Locale;
import java.util.Scanner;

public class Tres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dolares,euros,comision=0;
		final double cambio=0.9;
		
		Scanner entrada=new Scanner(System.in);
		entrada.useLocale(Locale.ENGLISH);
		System.out.println("Introduce importe en dolares:");
		dolares=entrada.nextDouble();
		if (dolares<100) {
			comision=dolares*0.002;
		}
		euros=(dolares-comision)*cambio;
		System.out.println("Vas a recibir "+euros+" euros");

	}

}
