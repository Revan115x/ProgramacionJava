package Almacen.ArrayList;

public class Almacen {

	private String nombre;
	private String procedencia;
	private double kilos;
	private double precioV;
	private double precioC;
	private static double beneficio;

	public Almacen(String nombre, String procendencia, double kilos, double precioV, double costo) {
		super();
		this.nombre = nombre;
		this.procedencia = procendencia;
		this.kilos = kilos;
		this.precioV = precioV;
		this.precioC = costo;
	}
	
	/*información de cadacargamento de fruta*/
	
	public String Infocargemento(){
		
		String info= "| Nombre: " + nombre +
					 "| Procedenica: " + procedencia +
					 "| Kilos: " + kilos +
					 "| Precio Venta : " +precioV;
				
		return info;
		
	}
	
	public void rebajar(double cantidad) {
		
	    double nuevoPrecio = precioV - cantidad;

	    /*asegurarnos de que no sea menor que el coste*/
	    if (nuevoPrecio < precioC) {
	        nuevoPrecio = precioC;
	    }

	    // asignar al atributo
	    precioV = nuevoPrecio;
	}
	
	public double vender(double kg) {
	    if (kg > kilos) {
	        System.out.println("Error: no hay suficientes kilos disponibles.");
	        return 0;
	    }

	    kilos -= kg; // actualizamos kilos disponibles
	    beneficio += (precioV - precioC) * kg; // actualizamos beneficio

	    return precioV * kg; // importe de la venta
	}
	
	public boolean mismaProcedencia(Almacen otro) {
	    return this.procedencia.equalsIgnoreCase(otro.procedencia);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procendencia) {
		this.procedencia = procendencia;
	}

	public double getKilos() {
		return kilos;
	}

	public void setKilos(double kilos) {
		this.kilos = kilos;
	}

	public double getPrecioV() {
		return precioV;
	}

	public void setPrecioV(double precioV) {
		this.precioV = precioV;
	}

	public double getPrecioC() {
		return precioC;
	}

	public void setPrecioC(double precioC) {
		this.precioC = precioC;
	}

	public static double getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(double beneficio) {
		this.beneficio = beneficio;
	}

	public static Almacen get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
 

}


