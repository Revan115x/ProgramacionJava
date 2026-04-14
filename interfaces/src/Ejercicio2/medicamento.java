package Ejercicio2;

public class medicamento implements Caducable {
	
	private String nombre;
	private String fechaCaducidad;
	
	public medicamento(String nombre, String fechaCaducidad) {
		super();
		this.nombre = nombre;
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public boolean haCaducado() {
		return false;
		
	}

	@Override
	public int diasParaCaducar() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
