package modelos;

public class reservas {
	private int precio;
	private int entradas;
	private int sala;
	private int telefono;
	
	
	
	
	public reservas( int precio, int entradas, int sala, int telefono) {
		super();
		this.precio = precio;
		this.entradas = entradas;
		this.sala = sala;
		this.telefono = telefono;
	}

	public int calcular(int entrad) {
		
		precio=10;
		
		int resultado=precio*entrad;
		
		return resultado;
		
	}

	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getEntradas() {
		return entradas;
	}


	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}


	public int getSala() {
		return sala;
	}


	public void setSala(int sala) {
		this.sala = sala;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	

}
