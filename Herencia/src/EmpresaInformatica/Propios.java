package EmpresaInformatica;

public class Propios extends Empleado {

	private double beneficios;
	private double salario;
	private static final double EXTRA_HORA=15;
	
	public Propios(String nombre, String dni, String direccion, String telefono,double salario) {
		super(nombre, dni, direccion, telefono);
		this.salario=salario;
		this.beneficios=0;
	}

	@Override
    public double pagarEmpl() {

        double pago = salario + beneficios + (horasTrabajadas * EXTRA_HORA);

        horasTrabajadas = 0;
        beneficios = 0;

        return pago;
    }
	
	public void añadirBeneficio(double dinero) {
		this.beneficios += dinero;
	}

	@Override
	public String toString() {
		return "Propios "+super.toString()+"[beneficios=" + beneficios + ", salario=" + salario + "]";
	}
	
	

}
