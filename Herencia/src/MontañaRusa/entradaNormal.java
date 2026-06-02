package MontañaRusa;

public class entradaNormal extends Persona {

	public entradaNormal(int edad, double altura) {
		super(edad, altura);
		// TODO Auto-generated constructor stub
	}

	@Override
	//Calular pago por edad
	public double pagar() {
		if(edad>18)
			return 4;
		else
			return 3;
	}

}
