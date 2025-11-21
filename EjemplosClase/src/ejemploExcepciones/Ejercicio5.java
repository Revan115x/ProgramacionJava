package ejerciciosExcepciones;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char distintivo;
		double kms, emisiones = 0, emisionesTotales = 0;

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		System.out.println("Anota distintivo vehiculo:");
		distintivo = sc.nextLine().charAt(0);

		while (distintivo != 'F') {
			System.out.println("Anota kms:");
			kms = sc.nextDouble();
			try {
				emisiones = calcularEmisiones(kms, distintivo);
				System.out.println("El vehiculo ha producido:" + emisiones + " emisiones");
				emisionesTotales += emisiones;
			} catch (DistintivoErroneoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

			System.out.println("Anota distintivo vehiculo:");
			sc.nextLine(); // Limpiar buffer
			distintivo = sc.nextLine().charAt(0);
		}
		System.out.println("Emisiones totales:" + emisionesTotales);

	}

	public static double calcularEmisiones(double kms, char distintivo) throws DistintivoErroneoException {
		double emisiones = 0;
		switch (distintivo) {
		case '0':
			emisiones = 0;
			break;
		case 'E':
			emisiones = 0.01;
			break;
		case 'C':
			emisiones = 0.02;
			break;
		case 'B':
			emisiones = 0.05;
			break;
		default:
			throw new DistintivoErroneoException("Distintivo incorrecto");
		}

		return emisiones * kms;
	}

}
