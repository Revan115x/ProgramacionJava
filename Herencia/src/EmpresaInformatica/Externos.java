package EmpresaInformatica;

public class Externos extends Empleado  {

	private String empresa;
	
	public Externos(String nombre, String dni, String direccion, String telefono,String empresa) {
		super(nombre, dni, direccion, telefono);
		this.empresa=empresa;
	}

	@Override
	public double pagarEmpl() {

		double pago= horasTrabajadas * 22;
		
		horasTrabajadas = 0;
		
		return pago;
		
	}

	@Override
	public String toString() {
		return "Externos "+super.toString()+" [empresa=" + empresa + "]";
	}
	
	


	
	
	
	
}
