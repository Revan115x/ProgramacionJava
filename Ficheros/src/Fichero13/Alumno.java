package Fichero13;

import java.time.LocalDate;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private double nota;
	private LocalDate fechaNacimiento;
	
	public Alumno(String nombre, String apellido, double nota, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", nota=" + nota + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	

}
