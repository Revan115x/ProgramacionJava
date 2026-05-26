package comerciales;

public class Fijo  extends Comercial {
	
	private final double comision=5;
	private static double fijo;
	
	public Fijo(String nombre) {
		super(nombre);
	}

	public static void setFijo(double fijo) {
		Fijo.fijo = fijo;
	}

	@Override
	public String toString() {
		return "Fijo [comision=" + comision + "]";
	}

	@Override
	double pagar() {
		
		return 0;
	}
	
	

}
