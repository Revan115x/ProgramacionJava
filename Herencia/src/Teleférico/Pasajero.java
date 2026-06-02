package Teleférico;

import java.time.LocalDate;

public class Pasajero {
	

	/*Nombre, DNI (validar: 8 dígitos y 1 letra), Fecha de Nacimiento, Altura (en cm) y Código de Ticket generado automáticamente.
El código de ticket se autogenera según el tipo de pasajero:*/

	private String nombre,Dni,Cod;
	private LocalDate fechanacimiento;
	
	public Pasajero(String nombre, String dni, String cod, LocalDate fechanacimiento) {
		super();
		this.nombre = nombre;
		Dni = dni;
		Cod = cod;
		this.fechanacimiento = fechanacimiento;
	}

	@Override
	public String toString() {
		return "Pasajero [nombre=" + nombre + ", Dni=" + Dni + ", Cod=" + Cod + ", fechanacimiento=" + fechanacimiento
				+ "]";
	}	
	
}
