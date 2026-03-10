package Examen_pt1;

import java.time.LocalDate;

public class auto {

	private String matricula;
	private LocalDate fechaCompra;
	private double precio;
	private String dniPropietario;
	
	public auto(String matricula, LocalDate fechaCompra, double precio, String dniPropietario) {
		super();
		this.matricula = matricula;
		this.fechaCompra = fechaCompra;
		this.precio = precio;
		this.dniPropietario = dniPropietario;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "\n auto matricula=" + matricula + ", fechaCompra=" + fechaCompra + ", precio=" + precio
				+ ", dniPropietario=" + dniPropietario + "";
	}
	
}
