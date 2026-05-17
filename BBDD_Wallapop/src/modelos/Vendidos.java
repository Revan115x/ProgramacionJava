package modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vendidos {
	
	private String codigo;
	private String mailComprador;
	private double precioVenta;
	private LocalDateTime fecha;
	
	
	
	public Vendidos(String codigo, String mailComprador, double precioVenta, LocalDateTime fecha) {
		super();
		this.codigo = codigo;
		this.mailComprador = mailComprador;
		this.precioVenta = precioVenta;
		this.fecha = fecha;
	}
	
	public Vendidos(String codigo, String mailComprador, double precioVenta) {
		super();
		this.codigo = codigo;
		this.mailComprador = mailComprador;
		this.precioVenta = precioVenta;
		this.fecha = LocalDateTime.now();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getMailComprador() {
		return mailComprador;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	@Override
	public String toString() {
		return "Vendidos [codigo=" + codigo + ", mailComprador=" + mailComprador + ", precioVenta=" + precioVenta
				+ ", fecha=" + fecha + "]";
	}

	
}
