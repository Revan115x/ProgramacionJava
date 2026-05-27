package EmpresaInformatica;

public class Externos extends Empleado  {

	private String marca;
	
	public Externos(int numeroId,String nombre, String dni, String direccion, String telefono,String marca) {
		super(numeroId, nombre, dni, direccion, telefono);
		this.marca=marca;
	}
	
	
	
}
