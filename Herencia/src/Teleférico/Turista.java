package Teleférico;

import java.time.LocalDate;

public class Turista extends Pasajero {
	
	private String temporada;

	public Turista(String nombre, String dni, String cod, LocalDate fechanacimiento) {
		super(nombre, dni, cod, fechanacimiento);
	}
	
	

}
