package modelos;

import java.time.LocalDate;

public class Movimiento {
	private int numTarjeta;
	private int cargado;
	private double importe;
	private LocalDate fecha;

	public Movimiento(int numTarjeta, int cargado, double importe, LocalDate fecha) {
		super();
		this.numTarjeta = numTarjeta;
		this.cargado = cargado;
		this.importe = importe;
		this.fecha = fecha;
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public int getCargado() {
		return cargado;
	}

	public double getImporte() {
		return importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "numTarjeta=" + numTarjeta + ", cargado=" + cargado + ", importe=" + importe + ", fecha="
				+ fecha + "";
	}

	
	

}
