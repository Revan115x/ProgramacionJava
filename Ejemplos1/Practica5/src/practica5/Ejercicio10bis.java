package practica5;

import java.util.Scanner;

public class Ejercicio10bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int notas, contAp = 0, contad_No = 0, contad_sob = 0, contSus = 0;

		System.out.println("introduzca una nota");
		notas = sc.nextInt();

		while (notas != -1) {

			if (notas >= 0 && notas <= 10) {
				if (notas >= 5)
					contAp++;
				else
					contSus++;

				if (notas == 7 || notas == 8) {
					contad_No++;
				} else {
					if (notas >= 9 && notas <= 10) {
						contad_sob++;
					}
				}
			} else {
				System.out.println("Nota incorrecta");
			}
			System.out.println("Introduzca otra nota:");
			notas= sc.nextInt();
		}
		System.out.println("hay " + contSus + " suspensos, hay " + contAp + " aprobados, hay " + contad_No
				+ " notables, y hay " + contad_sob + " sobresalientes");

	}

}
