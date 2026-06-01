package Universidad;

public class alumPuente extends Alumno {
	
	private String carrera;

	public alumPuente(String nombre, String apellido, String curso, double importMatricula, String carrera) {
		super(nombre, apellido, curso, importMatricula);
		this.carrera=carrera;
	}

	@Override
	public String toString() {
		return "Alumno alumPuente"+super.toString()+" [carrera=" + carrera + "]";
	}
	
	

}
