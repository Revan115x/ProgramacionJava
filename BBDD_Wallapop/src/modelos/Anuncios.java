package modelos;

public class Anuncios {
	
	private String codigo;
	private String categoria;
	private double precioVenta;
	private String mail;
	private double peso;
	
	public Anuncios(String codigo, String categoria, double precioVenta, String mail, double peso) {
		super();
		this.codigo = codigo;
		this.categoria = categoria;
		this.precioVenta = precioVenta;
		this.mail = mail;
		this.peso = peso;
	}

	
	
	public String getCodigo() {
		return codigo;
	}



	public String getCategoria() {
		return categoria;
	}



	public double getPrecioVenta() {
		return precioVenta;
	}



	public String getMail() {
		return mail;
	}



	public double getPeso() {
		return peso;
	}



	@Override
	public String toString() {
		return "Anuncios codigo=" + codigo + ", categoria=" + categoria + ", precioVenta=" + precioVenta + ", mail="
				+ mail + ", peso=" + peso + "";
	}

}
