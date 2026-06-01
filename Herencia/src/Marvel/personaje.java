package Marvel;

public abstract class personaje {

	protected String identificador;
	private String nombre;
	private String Universo;
	protected double nivelPoder;
	
	public personaje(String nombre, String universo, double nivelPoder) {
		super();
		this.nombre = nombre;
		Universo = universo;
		this.nivelPoder = nivelPoder;
	}
	
	public void incrementarPoder(double poder) {
		nivelPoder += poder;
	}
	
	public abstract double pagarRecompensa();

	public String getIdentificador() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUniverso() {
		return Universo;
	}

	public double getNivelPoder() {
		return nivelPoder;
	}

	@Override
	public String toString() {
		return "personaje [identificador=" + identificador + ", nombre=" + nombre + ", Universo=" + Universo
				+ ", nivelPoder=" + nivelPoder + "]";
	}
	
	
	
}
