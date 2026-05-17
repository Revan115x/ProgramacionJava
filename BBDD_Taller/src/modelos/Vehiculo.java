package modelos;

public class Vehiculo {

	private String matricula;
	private String modelo;
	private int anyoMatriculacion;

	// relación con cliente
	private Cliente propietario;

	public Vehiculo(String matricula, String modelo, int anyoMatriculacion, Cliente propietario) {

		this.matricula = matricula;
		this.modelo = modelo;
		this.anyoMatriculacion = anyoMatriculacion;
		this.propietario = propietario;
	}
}