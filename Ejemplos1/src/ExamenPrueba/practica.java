package ExamenPrueba;

import java.util.Scanner;

public class practica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int noGaraje = 75, siGaraje = 100, planta,dias;
		double supl1 = 5, supl2 = 7, supl3 = 10;
		double total = 0;
		boolean garaje;
		char puerta;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("tienes garaje(true/false)?");
		garaje = sc.nextBoolean();
		if (garaje == true)
			System.out.println("Te cobramos" + (total += siGaraje));
		else
			System.out.println("te cobramos" + (total += noGaraje));

		System.out.println("en que planta vives?");
		planta = sc.nextInt();

		switch (planta) {
		case 3:
		case 4:
		case 5:
			System.out.println(total += supl1);
			break;
		case 6:
		case 7:
		case 8:
		case 9:
			System.out.println(total += supl2);
			break;
		case 10:
			System.out.println(total += supl3);
		default:
			System.out.println("mal");
		}

		if (planta == 6) {
			sc.nextLine();
			System.out.println("En que puerta? (A/B/C/D)");
			puerta = sc.nextLine().charAt(0);
			switch (puerta) {
			case 'A': 
			case 'a':
			case 'B':
			case 'b':
				System.out.println(total += 5);
				break;
			case 'C':
			case 'c':
			case 'D':
			case 'd':
				System.out.println("no pagas nada mas");
				break;
			default:
				System.out.println("Error intentalo de nuevo");
			}
		}
		
		System.out.println("cuanto dias tienes pensado quedarte?");
		dias = sc.nextInt();
		
		if (dias >= 14)
			System.out.println(
					"tienes un descuento del 25% que te da un total de " + (total = total - (double) 25 / 100 * total));
		else if (dias > 7 && garaje == true) {
			System.out.println(
					"tienes un descuento del 20% que te da un total de " + (total = total - (double) 20 / 100 * total));
		}else {
			System.out.println(
					"tienes un descuento del 15% que te da un total de " + (total = total - (double) 15 / 100 * total));
		}
		
		/*int dias;*/
		int dialetra,dianum=0;
		char diaInicio,diaSalida=0;
		
		System.out.println("que dia empiezas (L/M/X/J/V/S/D)");
		sc.nextLine();
		diaInicio = sc.nextLine().charAt(0);
		
		switch(diaInicio){
			case 'L':
			case 'l':
				dianum=0;
				break;
			case 'M':
			case 'm':
				dianum=1;
				break;
			case 'X':
			case 'x':
				dianum=2;
				break;
			case 'J':
			case 'j':
				dianum=3;
				break;
			case 'V':
			case 'v':
				dianum=4;
				break;
			case 'S':
			case 's':
				dianum=5;
				break;
			case 'D':
			case 'd':
				dianum=6;
				break;
			default:
				System.out.println("error");
				break;
		}

		dialetra=(dianum+dias)%7;
		switch(dialetra) {
		case 0:
			diaSalida='L';
			break;
		case 1:
			diaSalida='M';
			break;
		case 2:
			diaSalida='X';
			break;
		case 3:
			diaSalida='J';
			break;
		case 4:
			diaSalida='V';
			break;
		case 5:
			diaSalida='S';
			break;
		case 6:
			diaSalida='D';
			break;
	
		}
		System.out.println("dia de salida "+diaSalida+dialetra);
		
	}

}
