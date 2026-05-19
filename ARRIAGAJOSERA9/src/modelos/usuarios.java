package modelos;

public class usuarios {

	private int numero;
	private String nombre;
	private String Apellido;
	private String tipo;
	private int penalizado;
	


	public usuarios(int numero, String nombre, String apellido, String tipo, int penalizado) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		Apellido = apellido;
		this.tipo = tipo;
		this.penalizado = penalizado;
	}



	public int getNumero() {
		return numero;
	}



	public String getNombre() {
		return nombre;
	}



	public String getApellido() {
		return Apellido;
	}



	public String getTipo() {
		return tipo;
	}



	public int getPenalizado() {
		return penalizado;
	}



	@Override
	public String toString() {
		return "usuarios [numero=" + numero + ", nombre=" + nombre + ", Apellido=" + Apellido + ", tipo=" + tipo
				+ ", penalizado=" + penalizado + "]";
	}

	
	
}
