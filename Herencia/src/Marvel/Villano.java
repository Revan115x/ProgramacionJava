package Marvel;

public class Villano extends personaje {

	private int conquistaCiudades;
	private static int contadorV=0;
	
	public Villano(String nombre, String universo, double nivelPoder) {
		super(nombre, universo, nivelPoder);
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
	
	

}
