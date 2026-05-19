package modelos;

import java.time.LocalDate;

public class prestamos {
	
	private int codigousuario;
	private String isbnlibro;
	private LocalDate fechadevolucion;
	
	public prestamos(int codigousuario, String isbnlibro, LocalDate fechadevolucion) {
		super();
		this.codigousuario = codigousuario;
		this.isbnlibro = isbnlibro;
		this.fechadevolucion = fechadevolucion;
	}
	
	public prestamos(int codigousuario, String isbnlibro) {
		super();
		this.codigousuario = codigousuario;
		this.isbnlibro = isbnlibro;
		this.fechadevolucion = LocalDate.now().plusDays(15);
	}

	public int getCodigousuario() {
		return codigousuario;
	}

	public String getIsbnlibro() {
		return isbnlibro;
	}

	public LocalDate getFechadevolucion() {
		return fechadevolucion;
	}

	@Override
	public String toString() {
		return "prestamos [codigousuario=" + codigousuario + ", isbnlibro=" + isbnlibro + ", fechadevolucion="
				+ fechadevolucion + "]";
	}
	
	
	

}
