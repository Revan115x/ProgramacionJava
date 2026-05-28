package Mesa;

public class Mesa {
	protected int numcomida,numbebida,numpedidos;
	private int numComensales;
	
	

	public Mesa(int numComensales) {

		this.numComensales = numComensales;
		this.numbebida=0;
		this.numcomida=0;
		this.numpedidos=0;
		
	}
	
	
	
	public boolean realizar_pedido(int nbebida,int ncomida) {
		if (nbebida>0 && ncomida>=0){
			numbebida+=nbebida;
			numcomida+=ncomida;
			numpedidos++;
			return true;	
		}
		else
			return false;
	}
	
	public double pagar() {
		double precio = 0 ,restar=0;
		precio = (numbebida * 2) + (numcomida * 15);
		if (numbebida < numComensales) 
			restar = numbebida * 2;
		else
			restar = (numComensales * 2);
		precio-=restar;

		return precio;
	}
	

	
	
	public void juntar(Mesa m2) {
		this.numbebida+=m2.numbebida;
		this.numcomida+=m2.numbebida;
		this.numpedidos+=m2.numpedidos;
		if(numpedidos>3) {
			numpedidos=3;
		}
	}
	
	
	

	
}