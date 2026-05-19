package modelos;

public class libros {
	
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private int numejemplares;
	private int prestados;
	
	public libros(String isbn, String titulo, String autor, String editorial, int numejemplares, int prestados) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numejemplares = numejemplares;
		this.prestados = prestados;
	}
	
	

	public libros(String isbn, int numejemplares) {
		super();
		this.isbn = isbn;
		this.numejemplares = numejemplares;
	}



	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public int getNumejemplares() {
		return numejemplares;
	}

	public int getPrestados() {
		return prestados;
	}

	@Override
	public String toString() {
		return "libros [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", numejemplares=" + numejemplares + ", prestados=" + prestados + "]";
	}
	
	
	

}
