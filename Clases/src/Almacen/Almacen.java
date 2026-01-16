package Almacen;

public class Almacen {

	private String nombre;
	private String procendencia;
	private double kilos;
	private double precioV;
	private double costo;

	public Almacen(String nombre, String procendencia, double kilos, double precioV, double costo) {
		super();
		this.nombre = nombre;
		this.procendencia = procendencia;
		this.kilos = kilos;
		this.precioV = precioV;
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Almacen [nombre=" + nombre + ", procendencia=" + procendencia + "]";
	}

}


