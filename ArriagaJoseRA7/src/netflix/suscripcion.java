package netflix;

import java.time.LocalDate;

public abstract class suscripcion implements metodos {
	
	private String mail;
	private int passwd;
	private LocalDate fechaAlta;
	protected int caducado;
	
	public suscripcion(String mail, int passwd) {
		super();
		this.mail = mail;
		this.passwd = passwd;
		this.fechaAlta = LocalDate.now();
		caducado=0;
	}

	public int verCaducado() {
		if(caducado==1) {
			caducado=1;
		}
		return caducado;
	}
	
	public String getMail() {
		return mail;
	}



	public int getPasswd() {
		return passwd;
	}



	public LocalDate getFechaAlta() {
		return fechaAlta;
	}



	@Override
	public String toString() {
		return "suscripcion [mail=" + mail + ", passwd=" + passwd + ", fechaAlta=" + fechaAlta + "]";
	}

	public abstract double verPelicula(int i);
	
	public abstract int conexiones();
	
	
	
}
