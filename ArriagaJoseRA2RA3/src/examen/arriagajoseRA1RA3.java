package examen;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class arriagajoseRA1RA3 {

	// JOSE ARRIAGA

	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String codigopatron = "^[A-Za-z]{3}[0-9]{3,4}$";//patron para validar codigo empleado
		String empleado = null;//String para el codigo
		
		//String para guardar las horas que pasaremos a localtime
		String fichaje;
		String fichajesalida;
		
		
		boolean correcto = false;
		
		//Variables para guardar las horas del string
		LocalTime entrada = null;
		LocalTime salida = null;
		
		DayOfWeek primer=DayOfWeek.MONDAY;//Mostrar el dia de la semana,lo empezamos en lunes
		
		sc = new Scanner(System.in);//LLamamos al Scanner

		//Bucle para validar codigo empleado
		do {

			try {
				System.out.println("CODIGO DE EMPLEADO EJEM TU DEPART MKT,DES,RRH Y CODIGO ****");
				empleado = sc.nextLine();
				empleado = empleado.toUpperCase();

				/*
				 * if (empleado.substring(0,2) != "MKT" ) {
				 * System.out.println("COLOCA UN DEPARTAMENTO"); correcto=false; }
				 */

				//Si el codigo es correcto sale del bucle
				if (empleado.matches(codigopatron)) {
					System.out.println("codigo valido");
					correcto = true;
				}

			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("TE HAS PASADO");
			}

		} while (!correcto);

		
		//Inicializamos correcto otra vez
		correcto = false;

		
		//Bucle para ir leyendo el horario de entrada y salida de lunes a viernes
		for (int i = 0; i < 5; i++) {
			
		System.out.println("El dia "+primer.plus(i).getDisplayName(TextStyle.FULL,Locale.getDefault()));

			//Bucle para validar las horas
			do {

				try {

					System.out.println("hora de entrada? Ej:07:00");
					fichaje = sc.nextLine();

					System.out.println("hora de salida? Ej:18:00");
					fichajesalida = sc.nextLine();

					entrada = LocalTime.parse(fichaje);
					salida = LocalTime.parse(fichajesalida);
					correcto = true;

					//Si la entrada se pasa de salida no es valida la hora
					if (entrada.isAfter(salida)) {
						System.out.println("Error: la primera hora no puede ser despues de la segunda");
						correcto = false;
					}

				} catch (DateTimeParseException e) {
					System.out.println("Error: EL FORMATO DE TU FECHA ESTA MAL");
				}

			} while (!correcto);

			
			//Cuando ya tenemos las horas bien ya comparamos el departemento y las horas trabajadas
			try {

				int tiempo = calcularhoras(entrada, salida, empleado);

			} catch (retrasoException e) {
				System.out.println(e.getMessage());
			} catch (salidaantes e) {
				System.out.println(e.getMessage());
			}

		}
		
		System.out.println("FIN DEL PROGRAMA");

	}

	public static int calcularhoras(LocalTime entrada, LocalTime salida, String usuario)
			throws retrasoException, salidaantes {

		//Creamos las variables que compararemos con nuestras horas
		LocalTime horaentrada = null;
		LocalTime horasalida = null;

		//Sacamos el subtring del empleado para validar el departamento 
		String cod = usuario.substring(0, 3);

		//Segun el departamento que este tendra las siguientes horas
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
		
		//Hacemos un long para calcular el tiempo que hay entre mis horas trabajas
		long horas = (int) Math.abs(ChronoUnit.HOURS.between(entrada, salida));
		long MM = (int) (Math.abs(ChronoUnit.MINUTES.between(entrada, salida)));
		System.out.println("HORAS TRABAJADAS " + MM / 60 + "HORAS Y " + MM % 60 + "MINUTOS");

		
		//si mi hora de llegada o salida se pasa de mi horario saltan los siguientes mensajes
		if (entrada.isAfter(horaentrada)) {
			throw new retrasoException(" JOSE ARRIAGA HAS LLEGADO TARDE, HORAS TRABAJAS");
		}
		if (salida.isBefore(horasalida)) {
			throw new salidaantes(" JOSE ARRIAGA HAS SALIDO ANTES DE TU HORA, HORAS TRABAJADAS");
		}

		//retorno las horas trabajas
		return (int) MM;

	}

}
