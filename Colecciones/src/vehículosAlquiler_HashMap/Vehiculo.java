package vehículosAlquiler_HashMap;

public class Vehiculo {

	private String matricula, modelo, marca;
	private int año, categoria;
	private boolean alquilado;
	private double ganancias;
	private static int totalAlquilados;
	private static double totalGanancias;
	
	public Vehiculo(String matricula, String modelo, String marca, int año, int categoria) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.año = año;
		this.categoria = categoria;
	}
	
	public double alquilar(int dias) {
		double precioDia=0;
		double precioAlquiler;
		
		if (this.alquilado)
			return 0;
		if (this.categoria==1)
			if (dias<=2)
				precioDia=45;
			else
				precioDia=30;
		else
			if (dias<=2)
				precioDia=50;
			else
				precioDia=40;
		
		precioAlquiler=precioDia*dias;
		this.alquilado=true;
		this.ganancias+=precioAlquiler;
		totalGanancias+=precioAlquiler;
		totalAlquilados++;
		return precioAlquiler;
					
	}
	
	
	public String getMatricula() {
		return matricula;
	}

	public boolean devolver() {
		if (!alquilado)
			return false;
		alquilado=false;
		totalAlquilados--;
		return true;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public double getGanancias() {
		return ganancias;
	}

	public static double getTotalGanancias() {
		return totalGanancias;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", año=" + año
				+ ", categoria=" + categoria + ", alquilado=" + alquilado + ", ganancias=" + ganancias + "]";
	}


	

}
