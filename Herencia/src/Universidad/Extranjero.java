package Universidad;

public class Extranjero extends Alumno {
	
	private String PaisOrigen;

	public Extranjero(String nombre, String apellido, String curso, double importMatricula, String PaisOrigen) {
		super(nombre, apellido, curso, importMatricula);
		this.PaisOrigen=PaisOrigen;
	}
	
	public double calcularTasa() {
		
		return importMatricula * 0.15;
	}

	@Override
	public String toString() {
		return "Alumno Extranjero"+super.toString()+" [PaisOrigen=" + PaisOrigen + "]";
	}

}
