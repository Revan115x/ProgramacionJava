package Repartos;

public class Repartidor {
	
	private int codigo;
	private int numPedidos;
	private double ganancias;
	private static int totalPedidos;
	private static int totalRepartidores;
	
	
	public Repartidor() {
		totalRepartidores++;
		this.codigo=totalRepartidores;
		//NO ES NECESARIO INICIAR LOS ATRIUTOS NUMERICOS A 0
		this.numPedidos=0;
		this.ganancias=0;
		
	}


	@Override
	public String toString() {
		return "Repartidor [codigo=" + codigo + ", numPedidos=" + numPedidos + ", ganancias=" + ganancias + "]";
	}
	
	public double hacerpedido(double importe,double propina) {
		totalPedidos++;
		double gan;
		numPedidos++;
		gan=importe*0.20+propina;
		ganancias+=gan;
		
		return gan;
	}

	public static int getTotalPedidos() {
		return totalPedidos;
	}

	
}
