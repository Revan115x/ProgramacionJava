package netflix;

import java.time.LocalDate;

public class suscripcionPrime extends suscripcion {

	private int dispositivos;
	private double mensualidad = 25;

	public suscripcionPrime(String mail, int passwd) {
		super(mail, passwd);
		dispositivos = 0;
	}

	public int conexiones() {
		if (dispositivos >= 3) {
			System.out.println("HAY VARIOS DISPOSITIVO CONECTADO");
			return 1;
		}
		return 0;
	}

	@Override
	public void conectar() {
		System.out.println("conectado...");
		dispositivos++;
	}

	@Override
	public void desconectar() {
		// TODO Auto-generated method stub
		System.out.println("desconectado...");
		dispositivos--;
	}

	@Override
	public void verPelicula(int i) {

		if(i == 1)
			peliculasPago++;
		else
			peliculasGratis++;

		peliculasGratis++;
	}

	@Override
	public double cobrarmensualidad() {
		totalRecaudado += mensualidad;
		return mensualidad;
	}

}
