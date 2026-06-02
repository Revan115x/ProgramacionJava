package MontañaRusa;

public abstract class Persona implements Comparable<Persona> {

	protected int edad;
	protected double altura;

	public Persona(int edad, double altura) {
		super();
		this.edad = edad;
		this.altura = altura;
	}

	public int getEdad() {
		return edad;
	}

	public double getAltura() {
		return altura;
	}
	
	public void comprobarAltura() throws error {
	    if (altura < 100 || altura > 190) {
	        throw new error("No apto por altura");
	    }
	}

	@Override
	public int compareTo(Persona otra) {
		if (this.edad != otra.edad) {
			return this.edad - otra.edad;
		}

		return (int) (this.altura - otra.altura);
	}

	@Override
	public String toString() {
		return "Persona [edad=" + edad + ", altura=" + altura + "]";
	}

	public abstract double pagar();

}
