package modelos;

public class ClienteConCarnet extends Cliente {

	private int carnet;

	public ClienteConCarnet(String dni, String nombre, String telefono, String direccion, int visitas, int carnet) {

		super(dni, nombre, telefono, direccion, visitas);
		this.carnet = carnet;
	}

	@Override
	public double calcularPago(double importe) {

		// ejemplo: 10% descuento
		return importe * 0.90;
	}

	// getters y setters
}