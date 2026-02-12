package ejemplo;

/**
@autor DAW1
@version 1.0
**/
/**
 * La clase Cargamento representa cargamentos de fruta, de distintas procedencias, para su venta.
 *
 */
public class Cargamento {
	private String nombre,procedencia;
	private int nKilos;
	private double precioCoste,precioVenta;
	private static double totalGanancias;
	
	
	public static double getTotalGanancias() {
		return totalGanancias;
	}


	/**
	 * 
	 * @param nombre  fruta 
	 * @param procedencia  lugar del que procede el cargamento
	 * @param nKilos  kilos que tiene el cargamento
	 * @param precioCoste  precio de compra del kilo de fruta
	 * @param precioVenta  precio de venta de la fruta
	 */
	public Cargamento(String nombre, String procedencia, int nKilos, double precioCoste, double precioVenta) {
	
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.nKilos = nKilos;
		this.precioCoste = precioCoste;
		this.precioVenta = precioVenta;
	}

/**
 * @return cadena que contiene todos los datos del cargamento
 */
	@Override
	public String toString() {
		return "Cargamento [nombre=" + nombre + ", procedencia=" + procedencia + ", nKilos=" + nKilos + ", precioCoste="
				+ precioCoste + ", precioVenta=" + precioVenta + "]";
	}
	
	
	
	 
	/**
	 * Rebajar el precio de venta de un cargamento sólo si es mayor que el precio de compra del mismo
	 * @param rebaja  cantidad a rebajar del precio inicial
	 * @return true si la rebaja puede realizarse, false si no puede realizarse
	 */
	public boolean rebajar(double rebaja) {
		if (precioVenta-rebaja<=precioCoste)
			return false;
		
		precioVenta-=rebaja;
		return true;
	}
	
	/**
	 * Registrar la venta de un número de kilos del cargamento sólo si hay suficiente stock
	 * 
	 * @param kilos  cantidad de kilos a vender
	 * @return el importe de la venta si es posible realizarla o 0 si no lo es
	 */
	public double vender(int kilos) {
		double beneficio;
		if (nKilos<kilos)
			return 0;
		
		beneficio=(precioVenta-precioCoste)*kilos;
		totalGanancias+=beneficio;
		
		nKilos-=kilos;
		return kilos*precioVenta;
		
		
	}
	
	/**
	 * Comprobar si dos cargamentos tienen la misma procedencia
	 * @param a  cargamento a comparar
	 * @param b   cargamento a comparar
	 * @return true si los cargamentos son iguales, false en caso contrario
	 */
	public static boolean mismoCargamento(Cargamento a,Cargamento b) {
		if (a.procedencia.equalsIgnoreCase(b.procedencia))
			return true;
		return false;
	}
	
	public boolean mismoCargamento2(Cargamento c) {
		if (procedencia.equalsIgnoreCase(c.procedencia))
			return true;
		return false;
	}
	
	
}
