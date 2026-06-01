package gym;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class socioN extends Socio {
	private static int contadorN=0;
	private double pagar;
	private double importe;

	public socioN(String nombre, String apellido, String telefono, LocalDate fechaNacimiento) {
		super(nombre, apellido, telefono, fechaNacimiento);
		// TODO Auto-generated constructor stub
		contadorN++;
		this.cod = "N"+contadorN;
		this.pagar=0;
	}

	@Override
	public double pagar() {

	    long segundos = ChronoUnit.SECONDS.between(entrada, salida);

	    if(segundos < 30)
	        pagar += 6;
	    else if(segundos < 60)
	        pagar += 9;
	    else
	        pagar += 12;

	    double cobro = pagar;

	    pagar = 0;

	    return cobro;
	}
	
}
