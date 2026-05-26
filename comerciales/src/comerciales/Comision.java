package comerciales;

public class Comision extends Comercial {
	
	private static final double comision=10;
	private String marca;

	public Comision(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public Comision(String nombre, String marca) {
		super(nombre);
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Comision "+super.toString()+" marca=" + marca + "]";
	}

	@Override
	double pagar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
