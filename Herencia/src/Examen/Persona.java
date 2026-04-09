package Examen;

public abstract class Persona {
	
	private int edad;
	private double altura;
	private double importe;

	public Persona(int edad, double altura) {
		this.edad = edad;
		this.altura = altura;
	}
	
	abstract public double pagar();

}
