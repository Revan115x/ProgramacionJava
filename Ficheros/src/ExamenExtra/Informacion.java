package ExamenExtra;

public class Informacion {

	private String titulo;
	private String autor;
	private double precio;
	
	public Informacion(String titulo, String autor, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return titulo + "," + autor;
	}
	
	
	
}
