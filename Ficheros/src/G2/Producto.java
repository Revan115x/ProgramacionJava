package G2;

public class Producto {
	
	private String codigo,nombre;
	private Double Precio;
	
	public Producto(String codigo, String nombre, Double precio2) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		Precio = precio2;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getnombre() {
		return nombre;
	}

	public Double getPrecio() {
		return Precio;
	}

	@Override
	public String toString() {
		return "productos [codigo=" + codigo + ", precio=" + nombre + ", Precio=" + Precio + "]";
	}
	
	

}
