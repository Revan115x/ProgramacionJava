package ejercicio1Libro;

public class texto extends libro{

	private String curso;
	private double descuento;
	
	public texto(String titulo, String autor, String editorial, double precio,String curso, double descuento) {
		super(titulo,autor,editorial,precio);
		this.curso = curso;
		this.descuento = descuento;
		this.precio=precio-precio*descuento/100;
	}

	@Override
	public String toString() {
		return curso + "," + descuento + "," + super.toString();
	}

	public String getCurso() {
		return curso;
	}
	
}
