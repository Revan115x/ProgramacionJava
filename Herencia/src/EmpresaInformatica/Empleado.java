package EmpresaInformatica;

public abstract class Empleado {
	
	protected static int contador = 0;
	private int numeroId;
	protected String nombre,dni,direccion,telefono;
	protected int horasTrabajadas;
	
	public Empleado(String nombre, String dni, String direccion, String telefono) {
		super();
		contador++;
		this.numeroId = contador;
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horasTrabajadas = 0;
	}
	
	public abstract double pagarEmpl();
	
	public void sumarHoras(int horas) {
		horasTrabajadas+=horas;
	}
	
	

	public static int getContador() {
		return contador;
	}

	public int getNumeroId() {
		return numeroId;
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

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	@Override
	public String toString() {
		return "[numeroId=" + numeroId + ", nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", horasTrabajadas=" + horasTrabajadas + "]";
	}
	
	

}
