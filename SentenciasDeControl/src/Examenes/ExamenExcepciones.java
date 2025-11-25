package Examenes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Scanner;

public class ExamenExcepciones {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Se quiere calcular el precio de un abono teatro de un usuario. Se piden los
		 * siguientes datos del usuario mientras sean incorrectos.
		 * 
		 * - Fecha de nacimiento, leedla en un String con 4 dígitos para el año. Validad
		 * que es correcta utilizado excepciones. Mostrad la edad. (3 pto)
		 * 
		 * - Tipo de abono, un String que puede tomar los siguientes valores: “Normal”,
		 * “Familiar”, “VIP” ignorando mayúsculas y minúsculas. (1 pto).
		 * 
		 * - Nombre de usuario que tiene que empezar por letra (en mayúscula o
		 * minúscula) y contener dígitos y letras en mayúsculas o minúsculas. En total
		 * con una longitud de 5 a 8. Usad patrón (1 pto).
		 * 
		 * Si los datos son correctos llamad a una función que calcule el importe. Los
		 * abonos normales son 10 euros, los VIP 50, los familiares 30. Si el usuario es
		 * jubilado (65 años o más) tiene un descuento del 20% y si es menor de 18 del
		 * 10%. Si ha elegido abono familiar y tiene menos de 18 años devolver una
		 * excepción propia con vuestro nombre y apellido. (2 ptos) Introducir una
		 * aserción en la función anterior para comprobar que el tipo de abono es el
		 * correcto. Si el cálculo del importe es correcto, generar una contraseña de
		 * longitud 7 que tenga los dos primeros caracteres del tipo de abono en
		 * mayúsculas y a continuación 5 dígitos aleatorios. Mostrad la contraseña por
		 * pantalla (2 ptos)
		 */

		/* Declaro ahora la fecha actual */
		LocalDate ahora = LocalDate.now();

		/* leo la fecha con String para pasarla a localDate */
		String fecha;

		/* boolean para los bucles */
		boolean correcto = false;

		/* Declaro el scanner para poder leer */
		sc = new Scanner(System.in);

		/* Bucle para pedir fecha hasta que este correcto */
		do {
			System.out.println("Fecha nacimiento: 31/10/1999");
			fecha = sc.nextLine();
			try {
				/*llamo a la funcion que calcula la edad*/
				int edad = calcularEdad(fecha);
				System.out.println("edad es " + edad);
				/*le digo que correcto es true para que salga del bucle*/
				correcto = true;
			} catch (DateTimeParseException e) {
				System.out.println("Error con el formato de fecha");
			}
		} while (correcto == false);
		
		correcto=false;
		String bono;
		
		System.out.println("tipo de bono");
		bono=sc.nextLine();
		
		

	}

	public static int calcularEdad(String fech) {

		LocalDate nacimiento = null;
		int edad;

		/* Creo un patron para fecha dia/mes/año en numeros */
		DateTimeFormatter patron;
		patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		/* Declaro ahora la fecha actual */
		LocalDate ahora = LocalDate.now();

		/*Compruebo que la fecha se ha introduccido correctamente, en caso de error entrar el el catch y me devuelve al main*/
		try {
			nacimiento = LocalDate.parse(fech, patron);
		} catch (DateTimeParseException e) {
			throw e;
		}

		/*hago un cast a int para que me de edad bien y no de problemas en el return*/
		edad = (int) ChronoUnit.YEARS.between(nacimiento, ahora);

		/*retorno edad*/
		return edad;
	}

}
