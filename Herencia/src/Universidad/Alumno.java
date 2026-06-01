package Universidad;

public class Alumno {
	
	private String nombre,apellido,curso;
	protected double importMatricula;
	
	public Alumno(String nombre, String apellido, String curso, double importMatricula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
		this.importMatricula = importMatricula;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso + ", importMatricula="
				+ importMatricula + "]";
	}

}
