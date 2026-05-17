package modelos;

import java.time.LocalDate;

public class Arreglo {

	private int idFactura;
	private Mecanico mecanico;
	private Vehiculo vehiculo;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private double importe;

	public Arreglo(int idFactura, Mecanico mecanico, Vehiculo vehiculo, LocalDate fechaEntrada, LocalDate fechaSalida,
			double importe) {

		this.idFactura = idFactura;
		this.mecanico = mecanico;
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.importe = importe;
	}

}