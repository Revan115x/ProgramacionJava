package Marvel;

public class Heroe extends personaje {

	private int numMisiones;
	private double recompensa = 0;
	private static int contadorH = 0;

	public Heroe(String nombre, int nivelPoder) {
		super(nombre, nivelPoder);
		this.numMisiones = 0;
		contadorH++;
		identificador = "V" + contadorH;
	}

	public void misionCompleta() {
		numMisiones++;
		recompensa += 500;
	}

	@Override
	public double pagarRecompensa() {
		double pago = recompensa + (nivelPoder * 10);
		recompensa = 0;
		return pago;
	}

	@Override
	public int ataqueNormal() {
		int ataque = 2;

		return nivelPoder/ataque;
	}

	@Override
	public int ataqueEspecial() {
		int ataque = 1;

		return nivelPoder/ataque;
	}

}
