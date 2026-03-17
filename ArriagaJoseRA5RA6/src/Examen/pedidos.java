package Examen;

public class pedidos {

	private int numPedido;
	private double precio;
	private String CodUsusario;
	private String Destino;
	
	
	public pedidos(int numPedido, double precio, String codUsusario, String destino) {
		super();
		this.numPedido = numPedido;
		this.precio = precio;
		CodUsusario = codUsusario;
		Destino = destino;
	}


	public int getNumPedido() {
		return numPedido;
	}


	public double getPrecio() {
		return precio;
	}


	public String getCodUsusario() {
		return CodUsusario;
	}


	public String getDestino() {
		return Destino;
	}


	@Override
	public String toString() {
		return "pedidos [numPedido=" + numPedido + ", precio=" + precio + ", CodUsusario=" + CodUsusario + ", Destino="
				+ Destino + "]";
	}
	
	
	
}
