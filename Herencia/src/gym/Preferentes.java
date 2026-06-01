package gym;

import java.time.LocalDate;

public class Preferentes extends Socio {

	private static int contadorN = 0;
	private double pagar;
	private static final double mensualidad = 10;
	private double importe;

	public Preferentes(String nombre, String apellido, String telefono, LocalDate fechaNacimiento) {
		super(nombre, apellido, telefono, fechaNacimiento);
		contadorN++;
		this.cod = "P" + contadorN;
		this.pagar = 0;
		importe = 0;
	}

	@Override
	public double pagar() {

	    double cobro = mensualidad + (visitas * 2);

	    if(getEdad() >= 60) {
	        cobro *= 0.8;
	    }

	    visitas = 0;

	    return cobro;
	}
}
