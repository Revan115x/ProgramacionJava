package Marvel;

public class Villano extends personaje {

	private int conquistaCiudades;
	private static int contadorV=0;
	
	public Villano(String nombre, int nivelPoder) {
		super(nombre, nivelPoder);
		conquistaCiudades=0;
		contadorV++;
		identificador="X"+contadorV;
	}
	
	public void conquistarCiudad() {
		conquistaCiudades++;
	}

	@Override
	public double pagarRecompensa() {
		double pago = (conquistaCiudades * 100 ) + (nivelPoder * 5);
		conquistaCiudades = 0;
		return pago;
	}

	@Override
	public int ataqueNormal() {
		int ataque = 2 ;
		
		return nivelPoder/ataque;
	}

	@Override
	public int ataqueEspecial() {
		
		int ataque = 1;
		
		return nivelPoder/ataque;
	}
	
	

}
