package EmpresaInformatica;

public abstract class Empleado {
	
	protected int numeroId;
	protected String nombre,dni,direccion,telefono;
	

	public Empleado(int numeroId,String nombre, String dni, String direccion, String telefono) {
		super();
		this.numeroId=numeroId;
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
