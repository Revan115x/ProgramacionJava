package MontañaRusa;

public class entradaCodigo extends Persona {

	private String codigo;
	
	public entradaCodigo(int edad, double altura,String codigo) {
		super(edad, altura);
		
		//SI VALIDA CODIGO ESTA BIEN NOS ASIGNA EL CODIGO
		if(validarCod(codigo))
			this.codigo=codigo;
	}
	
	public boolean validarCod(String codigo) {
		//patron para el codigo
		String patron="[A-Z]{1,3}[0-9]{2}";
		
		//si esta bien devuelve true
		if(codigo.matches(patron))
			return true;
		//sino false
		return false;
	}

	@Override
	//Calular pago por edad
	public double pagar() {
		String numero = codigo.substring(codigo.length() - 2);

	    return Integer.parseInt(numero);
	}

}
