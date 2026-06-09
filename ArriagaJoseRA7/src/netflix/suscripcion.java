package netflix;

import java.time.LocalDate;

public abstract class suscripcion implements metodos {

	private String mail;
	private int passwd;
	private LocalDate fechaAlta;
	private LocalDate fechaFin;
	protected int caducado;
	protected static int peliculasGratis = 0;
	protected static int peliculasPago = 0;
	protected static double totalRecaudado = 0;

	public suscripcion(String mail, int passwd) {
		super();
		this.mail = mail;
		this.passwd = passwd;
		this.fechaAlta = LocalDate.now();
		caducado = 0;
		//this.fechaFin = LocalDate.now().plusDays(30);
		this.fechaFin = LocalDate.now().minusDays(1);
	}
	
	public int verCaducado() {

		if(LocalDate.now().isAfter(fechaFin)) {
			return 1;
		}

		return 0;
	}
	
	public void renovar() {
		fechaFin = LocalDate.now().plusDays(30);
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

	public abstract void verPelicula(int i);

	public abstract double cobrarmensualidad();

	public abstract int conexiones();

	@Override
	public String toString() {
		return "suscripcion [mail=" + mail + ", passwd=" + passwd + ", fechaAlta=" + fechaAlta + "]";
	}

}
