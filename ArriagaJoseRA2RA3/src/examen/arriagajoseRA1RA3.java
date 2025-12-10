package examen;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class arriagajoseRA1RA3 {

	//JOSE ARRIAGA
	
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String codigopatron = "^[A-Za-z]{3}[0-9]{3,4}$";
		String empleado = null;
		String fichaje;
		String fichajesalida;
		boolean correcto = false;
		LocalTime entrada = null;
		LocalTime salida = null;
		LocalTime patron = LocalTime.of(0, 0);

		sc = new Scanner(System.in);

		do {

			try {
				System.out.println("CODIGO DE EMPLEADO EJEM TU DEPART MKT,DES,RRH Y CODIGO ****");
				empleado = sc.nextLine();
				empleado=empleado.toUpperCase();

				/*
				 * if (empleado.substring(0,2) != "MKT" ) {
				 * System.out.println("COLOCA UN DEPARTAMENTO"); correcto=false; }
				 */

				if (empleado.matches(codigopatron)) {
					System.out.println("codigo valido");
					correcto = true;
				}

			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("TE HAS PASADO");
			}

		} while (!correcto);

		correcto = false;

		do {

			try {

				System.out.println("hora de entrada?");
				fichaje = sc.nextLine();

				System.out.println("hora de salida?");
				fichajesalida = sc.nextLine();

				entrada = LocalTime.parse(fichaje);
				salida = LocalTime.parse(fichajesalida);
				System.out.println("todo bien");
				correcto = true;


				if (entrada.isAfter(salida)) {
					System.out.println("Error: la primera hora no puede ser despues de la segunda");
					correcto = false;
				}

			
			} catch (DateTimeParseException e) {
				System.out.println("Error: EL FORMATO DE TU FECHA ESTA MAL");
			}

		} while (!correcto);

		try {

			int tiempo = calcularhoras(entrada, salida, empleado);

		} catch (retrasoException e) {
			System.out.println(e.getMessage());
		} catch (salidaantes e) {
			System.out.println(e.getMessage());
		}

	}

	public static int calcularhoras(LocalTime entrada, LocalTime salida, String usuario)throws retrasoException, salidaantes {

		LocalTime horaentrada = null;
		LocalTime horasalida = null;
		long horario;

		String cod = usuario.substring(0, 3);

		switch (cod) {

		case "MKT":
			horaentrada = LocalTime.of(10, 00);
			horasalida = LocalTime.of(18, 00);
			break;
		case "DES":
			horaentrada = LocalTime.of(8, 30);
			horasalida = LocalTime.of(16, 00);
			break;
		case "RRH":
			horaentrada = LocalTime.of(9, 00);
			horasalida = LocalTime.of(16, 30);
			break;
		default:
			System.out.println("no estas en ningun departemento");
			break;
		}

		long horas =(int) Math.abs(ChronoUnit.HOURS.between(entrada, salida));
		long MM = (int)(Math.abs(ChronoUnit.MINUTES.between(entrada, salida)));
		System.out.println("HORAS TRABAJADAS " +MM/60 + "HORAS Y " + MM%60 + "MINUTOS");
		
		if (entrada.isAfter(horaentrada)) {
			throw new retrasoException(" JOSE ARRIAGA HAS LLEGADO TARDE, HORAS TRABAJAS"+horas);
		}
		if (salida.isBefore(horasalida)) {
			throw new salidaantes(" JOSE ARRIAGA HAS SALIDO ANTES DE TU HORA, HORAS TRABAJADAS"+horas);
		}


		return (int) MM;

	}

}
