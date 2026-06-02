package MontañaRusa;

public class entradaBono extends Persona {

	private int viajes;
	private boolean pagado;

	public entradaBono(int edad, double altura) {
		super(edad, altura);
		viajes = 3;
		pagado = false;
	}

	@Override
	//Calular pago por edad
	public double pagar() {

		if (pagado == false) {
			if (edad >= 18) {
				pagado = true;
				return 10;
			} else {
				pagado = true;
				return 4;
			}
		}
		return 0;
	}

	public int getViajes() {
		return viajes;
	}

	public boolean isPagado() {
		return pagado;
	}
	

}
