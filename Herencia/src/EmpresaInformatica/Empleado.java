package EmpresaInformatica;

public abstract class Empleado {
	
	private String nombre,dni,direccion,telefono;

	public Empleado(String nombre, String dni, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	

}
