package Cosas;

/**
 * @author jose
 */
/**
 * La clase Producto representa nombre, precio y stock de un producto para su
 * venta.
 */
public class Producto {

	private String nombre;
	private double precio;
	private int stock;

	/**
	 * Constructor por defecto que inicializa el producto con valores
	 * predeterminados.
	 */
	public Producto() {
		this.nombre = "Producto desconocido";
		this.precio = 0.0;
		this.stock = 0;
	}

	/**
	 * Constructor que permite inicializar el producto con valores específicos.
	 * 
	 * @param nombre nombre del producto
	 * @param precio precio del producto
	 * @param stock  cantidad de producto disponible
	 */
	public Producto(String nombre, double precio, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	/**
	 * @return el nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre del producto a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio el precio del producto a establecer
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return la cantidad de producto disponible en stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 *  @param cantidad cantidad a agregar al stock
	 * @throws IllegalArgumentException si la cantidad es negativa
	 */
	public void agregarStock(int cantidad) {
		if (cantidad < 0) {
			throw new IllegalArgumentException("No se puede agregar una cantidad negativa.");
		}
		this.stock += cantidad;
	}

	/**
	 * Registrar la venta de una cantidad del producto sólo si hay suficiente stock.
	 * 
	 * @param cantidad cantidad a vender
	 * @return true si la venta se realizó con éxito, false si no se pudo realizar
	 */
	public boolean vender(int cantidad) {
		if (cantidad < 0) {
			return false;
		}
		if (cantidad > stock) {
			return false;
		}
		this.stock -= cantidad;
		return true;
	}

	/**
	 * @return cadena que contiene todos los datos del producto
	 */
	@Override
	public String toString() {
		return "Producto: " + nombre + " | Precio: $" + precio + " | Stock: " + stock;
	}

}
