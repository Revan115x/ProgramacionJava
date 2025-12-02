package EjemplosLocalDate;

import java.time.LocalDate;

public class Ejemplo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate hoy=LocalDate.now();
		System.out.println("Estamos en el año:"+ hoy.getYear());
		System.out.println("Estamos en el mes:"+ hoy.getMonthValue());
		System.out.println("Estamos en el dia:"+ hoy.getDayOfMonth());
		LocalDate fecha1=LocalDate.of(2024, 11, 25);
		//hoy < fecha1
		if (hoy.isBefore(fecha1)) {
			System.out.println("La fecha es posterior a la de hoy");
		}
		else
			System.out.println("La fecha es anterior a hoy");

	}
	
	/*• y, nos permite acceder al año en formato de cuatro o dos dígitos (2014 o 14).
	• D, nos permite obtener el número de día del año (225).
	• d, nos devuelve el número del día del mes (27).
	• L, el mes del año en forma numérica
	• M nos da el mes en texto.
	• H, nos da la hora.
	• s, nos da los segundos.
	• m, nos permite obtener los minutos.
	• a, nos da el am o pm de la hora.
	• z, nos permite acceder al nombre de la zona horaria.
	El formato por defecto de una fecha es: yyyy-LL-dd*/

}
