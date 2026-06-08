package ficheros;

import java.time.LocalDate;

public class nif {

	private String nif;
	private LocalDate fecha;
	private double importa;

	public nif(String nif, LocalDate fecha, double importa) {
		super();
		this.nif = nif;
		this.fecha = fecha;
		this.importa = importa;
	}

	public String getNif() {
		return nif;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getImporta() {
		return importa;
	}

	
}
