package ejemplosfechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.DateTimeException;

public class EjemploFechas2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Obtengo la fecha del sistema
		LocalDate fechaActual = LocalDate.now();
		System.out.println("Fecha actual:"+fechaActual); 
		//Extraigo dia, mes y a√±o
		System.out.println("Fecha actual con otro formato:"+fechaActual.getDayOfMonth()+"/"+fechaActual.getMonthValue()+"/"+fechaActual.getYear());
		//Resto tres dÌas a la fecha
		fechaActual=fechaActual.minusDays(3);
		System.out.println("Fecha tres d√≠as antes:"+fechaActual); 
		//Sumo 4 meses a la fecha
		fechaActual=fechaActual.plusMonths(4);
		System.out.println("Fecha cuatro meses despu√©s:"+ fechaActual); 
		// Obtengo la hora del sistema
		LocalTime horaActual = LocalTime.now(); 
		System.out.println("Hora actual:"+horaActual); 
		if (horaActual.isBefore(LocalTime.of(11, 25)))
			System.out.println("TodavÌa no hemos ido al recreo");
		else
			System.out.println("Ya hemos subido del recreo");
		// Extraigo horas, minutos y segundos
		System.out.println("Hora obteniendo los datos:"+horaActual.getHour()+":"+horaActual.getMinute()+":"+horaActual.getSecond());
	
		
	}

}
