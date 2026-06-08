package netflix;

import java.time.LocalDate;

public class suscripcionStandard extends suscripcion {

	private double mensualidad = 15;
	private int dispositivos;
	private int contpelicula;

	public suscripcionStandard(String mail, int passwd) {
		super(mail, passwd);
		dispositivos = 0;
		contpelicula = 0;
	}

	public int conexiones() {
		if (dispositivos == 1) {
			System.out.println("HAY UN DISPOSITIVO CONECTADO");
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
		System.out.println("desconectado...");
		dispositivos--;

	}

	@Override
	public double verPelicula(int i) {
		double pago = 0;
		if (i == 1) {
			contpelicula++;
			return pago = mensualidad + (contpelicula * 2);

		}
		return pago;

	}

}
