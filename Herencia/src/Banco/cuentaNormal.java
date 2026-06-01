package Banco;

import java.util.HashSet;

public class cuentaNormal extends Cuenta {

	private double interes=0.03;
	
	public cuentaNormal(HashSet<String> titulares, double capital) {
		super(titulares, capital);
	}

	@Override
	public String toString() {
		return super.toString()+"cuentaNormal []";
	}

	@Override
	public double calcularGanancia(int dias) {
		 return (capital * interes * dias) / 365;
	}

	
	
}
