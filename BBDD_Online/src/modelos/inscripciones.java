package modelos;

import java.time.LocalDateTime;

public class inscripciones {
	
	private String codigoCurso;
	private String mailAlumno;
	private LocalDateTime fechaInscripcion;
	private double precioFinal;
	
	public inscripciones(String codigoCurso, String mailAlumno, double precioFinal) {
		super();
		this.codigoCurso = codigoCurso;
		this.mailAlumno = mailAlumno;
		this.fechaInscripcion = LocalDateTime.now();
		this.precioFinal = precioFinal;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public String getMailAlumno() {
		return mailAlumno;
	}

	public LocalDateTime getFechaInscripcion() {
		return fechaInscripcion;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	@Override
	public String toString() {
		return "inscripciones [codigoCurso=" + codigoCurso + ", mailAlumno=" + mailAlumno + ", fechaInscripcion="
				+ fechaInscripcion + ", precioFinal=" + precioFinal + "]";
	}
	

	
}
