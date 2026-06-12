package Marvel;

public abstract class personaje implements Atacable {

	protected String identificador;
	private String nombre;
	protected int nivelPoder;
	protected int nivelVida;

	public personaje(String nombre, int nivelPoder) {
		super();
		this.nombre = nombre;
		if (añadirNivelpoder(nivelPoder)==true)
			this.nivelPoder = nivelPoder;
		else
			this.nivelPoder = 20;
		nivelVida = 100;
	}

	public void incrementarPoder(double poder) {
		nivelPoder += poder;
	}
	
	public int actualizarVida(int ataque) {
		return nivelVida = nivelVida-ataque;
	}

	public abstract double pagarRecompensa();

	public String getIdentificador() {
		return identificador;
	}

	public boolean añadirNivelpoder(int poder) {
		if (poder < 100)
			return true;
		if (poder > 0)
			return true;

		return false;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNivelPoder() {
		return nivelPoder;
	}

	public int getNivelVida() {
		return nivelVida;
	}

	@Override
	public String toString() {
		return "personaje [identificador=" + identificador + ", nombre=" + nombre + ", nivelPoder=" + nivelPoder
				+ ", nivelVida=" + nivelVida + "]";
	}

}
