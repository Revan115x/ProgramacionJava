package claseDate;

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

}
