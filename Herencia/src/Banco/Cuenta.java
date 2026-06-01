package Banco;

import java.util.HashSet;

public abstract class  Cuenta {
	
	private static int numIdent=0;
	private HashSet<String> titulares = new HashSet<>();
	protected double capital;
	
	public Cuenta(HashSet<String> titulares, double capital) {
		super();
		numIdent++;
		this.numIdent = numIdent;
		this.titulares = titulares;
		this.capital = capital;
	}
	
	public abstract double calcularGanancia(int dias);
	
	public int getNumIdent() {
		return numIdent;
	}



	public HashSet<String> getTitulares() {
		return titulares;
	}



	public double getCapital() {
		return capital;
	}



	@Override
	public String toString() {
		return "Cuenta [numIdent=" + numIdent + ", titulares=" + titulares + ", Capital=" + capital + "]";
	}

	
	
}
