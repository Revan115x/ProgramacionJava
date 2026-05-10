package modelos;

public class Usuarios {

	private String mail;
	private String nombre;
	private String ciudad;
	private double valoracion;
	
	public Usuarios(String mail, String nombre, String ciudad, double valoracion) {
		super();
		this.mail = mail;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.valoracion = valoracion;
	}

	public String getMail() {
		return mail;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public double getValoracion() {
		return valoracion;
	}

	@Override
	public String toString() {
		return "Usuarios [mail=" + mail + ", nombre=" + nombre + ", ciudad=" + ciudad + ", valoracion=" + valoracion
				+ "]";
	}
	
}
