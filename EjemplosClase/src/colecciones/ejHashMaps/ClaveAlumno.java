package colecciones.ejHashMaps;

import java.util.Objects;

public class ClaveAlumno {

	private String dni;
	private String asignatura;
	
	public ClaveAlumno(String nombre, String asignatura) {
		this.dni = dni;
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaveAlumno other = (ClaveAlumno) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(dni, other.dni);
	}
	
}
