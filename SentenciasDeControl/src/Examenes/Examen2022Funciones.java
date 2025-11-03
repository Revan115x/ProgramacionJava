package Examenes;

import java.util.Scanner;

public class Examen2022Funciones {

	/*
	 * Un restaurante quiere gestionar las reservas para una cena con espectáculo
	 * mediante un programa. El restaurante puede dar de cenar a 80 comensales. Por
	 * cada cliente que llama para reservar se toma nota de lo siguiente: • Número
	 * de personas para cenar. Controlar que sea un número positivo y que no supere
	 * las plazas que queden disponibles. Si no hay plazas suficientes no se
	 * continúa con la reserva. (0,5 puntos) • Se ofrece una lista de 3 menús para
	 * que elija entre ellos: o Menú económico (25€) o Menú degustación (35€) o Menú
	 * estrella (50€). Validar mediante una función, que el tipo seleccionado sea
	 * correcto. No continuar el proceso hasta introducir correctamente el dato (0,5
	 * puntos) • Tras la cena, durante el espectáculo, habrá la posibilidad de
	 * contratar 2 copas por el precio de 9€ o barra libre por 30€. Pedir cuantas
	 * personas se apuntan a cada una de las dos opciones, teniendo en cuenta que la
	 * suma de ambas no supere el número de personas de la reserva. (0,5 ptos) •
	 * Calcular el precio total mediante una función calcular_precio que reciba
	 * número de comensales, tipo de menú, número de personas que contratan 2 copas
	 * y personas que contratan barra libre. (1 pto). Si el cliente además tiene un
	 * carnet de socio correcto, (validad que tiene longitud 4 ó 5, y que empieza
	 * por letra en mayúsculas y el resto son dígitos) se le hace un 20% de
	 * descuento. (0,75 puntos) • Una vez recibido el precio, mostrarlo y pedir
	 * confirmación de la reserva. (0, 5 puntos) • El proceso acaba si se acaban las
	 * plazas o se teclea -1 al pedir el número de personas para cenar. (0,5 ptos) •
	 * Al acabar el proceso mostrad el total de ganancias y reservas y el porcentaje
	 * de personas que se han apuntado a la barra libre(0,75 ptos). • Haced que el
	 * programa pueda repetir el proceso anterior para varias noches mientras lo
	 * desee el usuario, mostrando al finalizar el programa lo que se ha recaudado
	 * la noche de menor recaudación y el total de personas que no han contratado
	 * bebida en todas las noches.(1,25 pto)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int personas1, personasc, personasl, ProximaP, mesas = 80, carta = 0, opcion = 0;
		boolean carnet, ProximaR = true;

		/* Preguntar nombre dentro de las funciones */

		Scanner sc = new Scanner(System.in);

		while (ProximaR && mesas > 0) {

			System.out.println("Cuantas personas reservaran?");
			personas1 = sc.nextInt();
			mesas = Reservas(mesas, personas1);

			if (personas1 > 0) {
				if (mesas <= 0)
					System.out.println("Reservas acabadas");
			} else {
				System.out.println("NO HAY RESERVAS SUFICIENTES");
				System.exit(0);
			}

			mesas -= personas1;

			System.out.println("Que menu desea 1/2/3");
			carta = sc.nextInt();
			int Carta1 = menus(carta);

			do {
				System.out.println("cuantas personas quieren barra libre?");
				personasl = sc.nextInt();

				System.out.println("cuantas personas quieren copas?");
				personasc = sc.nextInt();

				if (personasl + personasc > personas1) {
					System.out.println("hay un error,son mas personas");
				}

			} while (personasl + personasc > personas1);

			int totalBarra = cuentabarra(personasl); /* Si lo pongo arriba no funciona total */
			int totalCopas = cuentacopas(personasc);

			int Totalcopas = totalBarra + totalCopas;
			int totalmenu = Carta1 * personas1;

			System.out.println("su cuenta total es de " + totalmenu);

			System.out.println("Tienes Carnet? True/False");
			carnet = sc.nextBoolean();

			if (carnet) {
				int CuentaDes = 0;
				CuentaDes = (int) (totalmenu * 0.8);
				System.out.println("Se ha aplicado un descuento de 20% tu total ahora es de" + CuentaDes);
			} else {
				System.out.println("no tienes descuento bro" + totalmenu);
			}

			if (mesas > 0) {
				System.out.println("Quieres volvere a reservar?");
				ProximaR = sc.nextBoolean();
			} else {
				System.out.println("no hay reservas disponibles");
			}
		}
		
		sc.close();

	}

	public static int cuentabarra(int personasl) {

		int barra = 30;
		int resultado;

		resultado = personasl * barra;

		return resultado;

	}

	public static int cuentacopas(int personasc) {

		int copas = 9;
		int resultado;

		resultado = personasc * copas;

		return resultado;

	}

	public static int Reservas(int mesas, int personas1) {

		return mesas - personas1;

	}

	public static int menus(int carta) {

		int cuenta1 = 0;

		switch (carta) {
		case 1:
			cuenta1 = 25;
			break;
		case 2:
			cuenta1 = 35;
			break;
		case 3:
			cuenta1 = 50;
			break;
		default:
			System.out.println("Invalido");
			cuenta1 = 0;
			break;
		}

		return cuenta1;

	}

}
