package Ejercicio2;

public class carnet implements Caducable {
	
	private String nombre;
	private String apellidos;
	private String dni;
	private String fechaCaducidad;
	
	
	public carnet(String nombre, String apellidos, String dni, String fechaCaducidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaCaducidad = fechaCaducidad;
	}
	
	public boolean haCaducado() {
		return false;
		
	}

	@Override
	public int diasParaCaducar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
