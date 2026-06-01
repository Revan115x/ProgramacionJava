package Banco;

import java.util.HashSet;

public class cuentaCuenton extends Cuenta {
	
	private double interes=0.04;

	public cuentaCuenton(HashSet<String> titulares, double capital) {
		super(titulares, capital);
	}

	@Override
	public String toString() {
		return super.toString()+"cuentaCuenton []";
	}

	@Override
	public double calcularGanancia(int dias) {
		return (capital *interes* dias) / 365;
	}
	
	

}
