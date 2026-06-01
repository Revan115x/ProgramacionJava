package Marvel;

public class Heroe extends personaje {

	private int numMisiones;
	private double recompensa=0;
	private static int contadorH=0;
	
	public Heroe(String nombre, String universo, double nivelPoder) {
		super(nombre, universo, nivelPoder);
		this.numMisiones=0;
		contadorH++;
		identificador="V"+contadorH;
	}
	
	public void misionCompleta() {
		numMisiones++;
		recompensa+=500;
	}

	@Override
	public double pagarRecompensa() {
		double pago= recompensa + (nivelPoder * 10);
		recompensa=0;
		return pago;
	}	

}
