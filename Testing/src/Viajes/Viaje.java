package Viajes;

public class Viaje {
	private String origen;
	private String destino;
	private String codigo;
	private int nPlazas;
	private double importePers;
	private int nReservas;
	private static int numero; // Numero para calcular codigo de cada viaje, se calcula con contador en el constructor
	private static double recaudacion; // Acomulador suma las ganancias en el Metodo reservar
	
	public Viaje(String origen, String destino, int nPlazas, double importePers) {
		numero++;
		this.origen = origen;
		this.destino = destino;
		this.codigo = origen.toUpperCase().substring(0,2)+destino.toUpperCase().substring(0,2)+numero;
		this.nPlazas = nPlazas;
		this.importePers = importePers;
		
		
	}
	
	public double reservar(int nAdultos,int nNiños) {
		double precio;
	
		if (nPlazas < nAdultos+nNiños)
			return 0;
		
		precio=importePers*nAdultos+importePers*nNiños*0.8;
		nReservas+=nAdultos+nNiños; 
		recaudacion=precio;
		
		return precio;
	
	}
	
	public boolean modPlazas(int modificacion) {
			if (nReservas<modificacion) {
				nPlazas=modificacion;
				return true;}
			return false;
				
	}
	
	

	@Override
	public String toString() {
		return "Viaje [origen=" + origen + ", destino=" + destino + ", codigo=" + codigo + ", nPlazas=" + nPlazas
				+ ", importePers=" + importePers + "]";
	}

	
	
	public static double getRecaudacion() {
		return recaudacion;
	}

	

	public String getCodigo() {
		return codigo;
	}

	

	public int getnReservas() {
		return nReservas;
	}



	public int getnPlazas() {
		return nPlazas;
	}

	public double getImportePers() {
		return importePers;
	}
	

	

	
	
	
	
	
}