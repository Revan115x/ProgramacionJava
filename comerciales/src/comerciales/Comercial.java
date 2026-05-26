package comerciales;

public abstract class Comercial {
	
	private String nombre;
	private int numero;
	protected int nA, nB, nC;
	private static int numerototal=0;
	
	public Comercial(String nombre) {
		super();
		this.nombre = nombre;
		numerototal++;
		numero=numerototal;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumero() {
		return numero;
	}

	public int getnA() {
		return nA;
	}

	public int getnB() {
		return nB;
	}

	public int getnC() {
		return nC;
	}

	public static int getNumerototal() {
		return numerototal;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", numero=" + numero + ", nA=" + nA + ", nB=" + nB + ", nC=" + nC + "]";
	}
	
	abstract double pagar();
	
	public void vender(String marca,int unid) {
		
		switch(marca) {
		case "A":
			nA+=unid;
			break;
		case "B":
			nB+=unid;
			break;
		case "C":
			nC+=unid;
			break;
		default:
			System.out.println("Marca no valida");
		}
		
	}
	
	

}
