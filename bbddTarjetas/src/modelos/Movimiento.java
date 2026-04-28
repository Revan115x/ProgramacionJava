package modelos;

import java.time.LocalDate;

public class Movimiento {
	private int numero;
	private int numTarjeta;
	private boolean cargado;
	private double importe;
	private LocalDate fecha;

	public Movimiento(int numero, int numTarjeta, boolean cargado, double importe, LocalDate fecha) {
		super();
		this.numero = numero;
		this.numTarjeta = numTarjeta;
		this.cargado = cargado;
		this.importe = importe;
		this.fecha = fecha;
	}

	public Movimiento(int numTarjeta, double importe) {
		super();
		this.numTarjeta = numTarjeta;
		this.cargado = false;
		this.importe = importe;
		this.fecha = LocalDate.now();
	}

	public int getNumTarjeta() {
		return numTarjeta;
	}

	public boolean isCargado() {
		return cargado;
	}

	public double getImporte() {
		return importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	

}
