package CochesElectricos;

public class CocheARR {
	
	private String matricula;
	private static double ganancias;
	private static double precio;
	private boolean alquilado=false;
	private boolean reservado=false;
	
	public CocheARR(String matricula, boolean alquilado, boolean reservado) {
		super();
		this.matricula = matricula;
		this.alquilado = alquilado;
		this.reservado = reservado;
	}

	public int alquilado() {
	
		if(this.reservado==true)/*RESERVADO*/
			return 1;
		if(this.alquilado==true)/*ALQUILADO*/
			return 2;
		
		return 0;/*LIBRE*/
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void getMatricula(String matricula) {
		this.matricula;
	}

	
	
	@Override
	public String toString() {
		return " [\nmatricula=" + matricula + "\n alquilado=" + alquilado + "\n reservado=" + reservado + "]";
	}

}