package ExamenesGenerales;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		double positivos[] = new double[10];
		double negativos[] = new double[10];
		double temp;
		int contpositivos = 0;
		int contnegativos = 0;
		int encontrado = 0;
		double buscar;

		for (int i = 0; i < 10; i++) {

			System.out.println("temperatura");
			temp = sc.nextDouble();

			if (temp > 0) {
				positivos[contpositivos]=temp;
				contpositivos++;
			} else {
				negativos[contnegativos]=temp;
				contnegativos++;
			}
		}
		
		Arrays.sort(positivos, 0, contpositivos);
		Arrays.sort(negativos, 0, contnegativos);

		System.out.println("Temperaturas positivas");
		for (int i = 0; i < contpositivos; i++) {
			System.out.println(positivos[i]);
		}
		
		System.out.println("Temperaturas negativas");
		for (int i = 0; i < contnegativos; i++) {
			System.out.println(negativos[i]);
		}
		

		//System.out.println("Buscar temp");
		buscar = sc.nextDouble();

		for (int i = 0; i < contpositivos; i++) {

			if (buscar == positivos[i]) {
				encontrado++;
				System.out.println("encontrado en positivos");
				break;
			}
		}
		for (int i = 0; i < contnegativos; i++) {
			if (buscar == negativos[i]) {
				encontrado++;
				System.out.println("encontrado en negativos");
				break;
			}
		}

		if (encontrado == 0) {
			System.out.println("no esta en ningun array tu temperatura");
		}//

	}

}
