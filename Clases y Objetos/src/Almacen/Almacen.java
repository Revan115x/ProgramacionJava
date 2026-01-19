package Almacen;

public class Almacen {

	private String nombre;
	private String procendencia;
	private double kilos;
	private double precioV;
	private double precioC;
	private double beneficio;

	public Almacen(String nombre, String procendencia, double kilos, double precioV, double costo) {
		super();
		this.nombre = nombre;
		this.procendencia = procendencia;
		this.kilos = kilos;
		this.precioV = precioV;
		this.precioC = costo;
	}
	
	public Double descuento(Double descuesto) {
		if(precioV-descuesto<precioC) 
			return false;
			precioV-=descuesto;
			return true;
	}
	
	public double vender (double cantidad) {
		double importe=0;
		if(kilos>=cantidad) {
			kilos-=cantidad;
			importe=cantidad*precioV;
			beneficio+=cantidad*(precioV-precioC);
		}
		return false;
	}
	
	public static

	public String getNombre() {
		return nombre;
	}
	
	
	@Override
	public String toString() {
		return "Almacen [nombre=" + nombre + ", procendencia=" + procendencia + "]";
	}

}


