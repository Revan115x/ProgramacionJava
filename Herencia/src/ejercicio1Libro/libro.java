package ejercicio1Libro;

public class libro {
	
	private String titulo,autor,editorial;
	protected double precio;
	
	public double getPrecio() {
		return precio;
	}

	public libro(String titulo, String autor, String editorial, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return titulo + "," + autor + "," + editorial + "," + precio;
	}

}
