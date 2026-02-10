package Alumnos;

import java.util.Objects;

public class Alumno {
	
	private String nombre;
	private double nota;
	
	public Alumno(String nombre, double nota) {
		this.nombre = nombre;
		this.nota = nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
	
}
