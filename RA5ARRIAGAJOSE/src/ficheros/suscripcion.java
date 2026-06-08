package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class suscripcion {
	
	private String nif;
	private LocalDate fecha;
	private double importa;
	private String nombre;
	private String Apellido;
	private String Mail;
	
	public suscripcion(String nif,String nombre,String Apellido,String Mail, LocalDate fecha,double importa) {
		super();
		this.nif = nif;
		this.fecha = LocalDate.now().plusYears(1);
		this.importa = importa*0.20;
		this.nombre = nombre;
		this.Apellido = Apellido;
		this.Mail = Mail;
	}
	
	

	public suscripcion(String nif, LocalDate fecha, double importa) {
		super();
		this.nif = nif;
		this.fecha = fecha;
		this.importa = importa;
	}

	


	public suscripcion(String nombre, String apellido, String mail) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		Mail = mail;
	}



	@Override
	public String toString() {
		return "suscripcion [nif=" + nif + ", fecha=" + fecha + ", importa=" + importa + ", nombre=" + nombre
				+ ", Apellido=" + Apellido + ", Mail=" + Mail + "]";
	}



	


	
	
	
}
