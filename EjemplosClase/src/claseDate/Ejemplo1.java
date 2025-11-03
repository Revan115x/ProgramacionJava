package claseDate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate fechaNacimiento=null;
		LocalDate fechaActual = LocalDate.now();
		System.out.println(fechaActual);
		LocalTime horaActual = LocalTime.now();
		System.out.println(horaActual);
		LocalDateTime ahora = LocalDateTime.now();
		System.out.println(ahora);
		try {
		   fechaNacimiento=LocalDate.of(2025, 2, 29);
		}catch(DateTimeException e) {
			System.out.println("Fecha errónea");
		}
		System.out.println(fechaNacimiento);
		LocalTime horaRecreo=LocalTime.of(11, 25);
		System.out.println("Salimos al recreo a las " + horaRecreo);
		LocalDateTime heNacido=LocalDateTime.of(1999, 3, 28,20, 40);
		System.out.println("Momento exacto de mi nacimiento: "+ heNacido);
	}

}
