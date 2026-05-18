package modelos;

public class alumnos {

	private String mail;
	private String nombre;
	private int premium;
	private int puntos;
	
	public alumnos(String mail, String nombre, int premium, int puntos) {
		super();
		this.mail = mail;
		this.nombre = nombre;
		this.premium = premium;
		this.puntos = puntos;
	}

	public String getMail() {
		return mail;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPremium() {
		return premium;
	}

	public int getPuntos() {
		return puntos;
	}

	@Override
	public String toString() {
		return "alumnos [mail=" + mail + ", nombre=" + nombre + ", premium=" + premium + ", puntos=" + puntos + "]";
	}
	
	
	
}
