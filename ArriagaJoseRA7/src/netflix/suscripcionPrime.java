package netflix;

import java.time.LocalDate;

public class suscripcionPrime extends suscripcion {
	
	private int dispositivos;
	private double mensualidad=25;

	public suscripcionPrime(String mail, int passwd) {
		super(mail, passwd);
		dispositivos=0;
	}
	
	public int conexiones() {
		if(dispositivos>3) {
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
		// TODO Auto-generated method stub
		System.out.println("desconectado...");
		dispositivos--;
	}

	@Override
	public double verPelicula(int i) {
		
		return mensualidad;
		
	}

}
