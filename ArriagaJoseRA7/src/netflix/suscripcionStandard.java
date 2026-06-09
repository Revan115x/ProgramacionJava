package netflix;

import java.time.LocalDate;

public class suscripcionStandard extends suscripcion {

	private double mensualidad = 8;
	private int dispositivos;
	private int contpeliculapago;

	public suscripcionStandard(String mail, int passwd) {
		super(mail, passwd);
		dispositivos = 0;
		contpeliculapago = 0;
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
	public void verPelicula(int i) {

		if(i == 1) {
			contpeliculapago++;
			peliculasPago++;
		}
		else {
			peliculasGratis++;
		}
	}

	@Override
	public double cobrarmensualidad() {
		double pagos = contpeliculapago * 1.5;
		totalRecaudado += pagos + mensualidad;
		return pagos + mensualidad;
	}

}
