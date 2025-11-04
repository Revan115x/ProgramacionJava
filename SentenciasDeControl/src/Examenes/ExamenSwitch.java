package Examenes;

import java.util.Scanner;

public class ExamenSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double precio = 0, litros = 0, precioLitro = 0;
		final double GAS = 1.52, DIE = 1.39, BIO = 1.71, pagar;
		char tipoCar;
		boolean correcto = true;
		int opc;

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce Tipo carburante (G,D,B)");
		tipoCar = sc.nextLine().charAt(0);

		switch (tipoCar) {
		case 'G':
		case 'g':
			precioLitro = GAS;
			break;
		case 'd':
		case 'D':
			precioLitro = DIE;
			break;
		case 'B':
		case 'b':
			precioLitro = BIO;
			break;
		default:
			System.out.println("incorrecto");
			correcto = false;
		}

		if (correcto) {
			System.out.println("Elige: 1 llenar deposito 2 importe ");
			opc = sc.nextInt();

			if (opc == 1) {
				System.out.println("Introduce litros a repositar:");
				litros = sc.nextDouble();

				if (litros > 100) {
					System.out.println("numero  de litros incorrectos");
					correcto = false;
				} else {
					precio = litros * precioLitro;
					System.out.println("precio" + precio);
				}

			} else if (opc == 2) {
				System.out.println("Introduce importe a repostar");
				precio = sc.nextDouble();

				if (precio % 5 == 0 && precio >= 10 && precio <= 150)
					;
				litros = precio / precioLitro;
			} else {
				System.out.println("importe incorrecto");
				correcto = false;
			}
		} else {
			System.out.println("Opcion Introduccida incorrecta");
			correcto = false;
		}

		if (correcto == true) {
			if (litros > 10 && litros <= 20) {
				if (tipoCar == 'B' || tipoCar == 'b' || tipoCar == 'D' || tipoCar == 'd')
					precio = precio * 0.9;
				else
					precio = precio = 0.95;
			} else if (litros > 20)
				precio = precio * 0.85;
			System.out.println("su precio final es" + precio);
			System.out.println("anota el importe que realizara el pago");
			pagar = sc.nextDouble();

			if (pagar < precio)
				System.out.println("insufuciete dinero para pagar");

			else {
				double vueltas = precio - pagar;
				int b20 = (int) (vueltas / 20);
				vueltas = vueltas % 20;
				int b10 = (int) (vueltas / 10);
				vueltas = vueltas % 10;
				int b5 = (int) (vueltas / 5);
				vueltas = vueltas % 5;
				System.out.println("Tus vueltas son:" + b20 + "bille de 20" + b10 + "billetes de 10" + b5
						+ "billetes de 5 " + vueltas);
			}
		}

	}

}
