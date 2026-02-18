package Cine.linkedList.copy;


public class Usuario {

	private String nombre;
	private int entradas;
	private static int entradasGeneral=10;
	
	public Usuario(String nombre, int entradas) {
		super();
		this.nombre = nombre;
		this.entradas = entradas;
	}
	
	public String getNombre() {
		return nombre;
	}

	public  String datosNombre(){
		return " Nombre: "+nombre+
			   "\n entradas: "+entradas;
	}
	
	public int comprar() {
	
		if(entradas>entradasGeneral)
			return 0;
		entradasGeneral=entradasGeneral-entradas;
		return 1;
		
	}

	public static int getEntradasGeneral() {
		return entradasGeneral;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + "],[entradas=" + entradas + "]";
	}
	
}
