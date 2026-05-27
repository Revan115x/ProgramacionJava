package EmpresaInformatica;

public class Externos extends Empleado  {

	private String marca;
	
	public Externos(String nombre, String dni, String direccion, String telefono,String marca) {
		super(nombre, dni, direccion, telefono);
		this.marca=marca;
		
	}
	
	
	
}
