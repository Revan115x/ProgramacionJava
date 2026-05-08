package ejemploInterface1;

public class Vehiculo implements Machine{
	private String matr;
	private int cuentaKms;
	public Vehiculo(String matracula) {
		this.matr = matracula;
		this.cuentaKms = 0;
	}
	
	public void recorrer(int kms){
		cuentaKms+=kms;
	}
	@Override
	public String suena() {
		// TODO Auto-generated method stub
		return "Piiiii";
	}
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		cuentaKms=0;
		
	}

	@Override
	public String toString() {
		return "Vehiculo [matr�cula=" + matr + ", cuentaKms=" + cuentaKms + "]";
	}
	
	
}
