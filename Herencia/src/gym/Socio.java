package gym;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Socio {

	protected String cod;
	private String nombre;
	private String apellido;
	private String telefono;
	private LocalDate fechaNacimiento;
	protected LocalDateTime salida,entrada;
	protected int Estado;
	protected int visitas=0;
	
	
	public Socio(String nombre, String apellido, String telefono, LocalDate fechaNacimiento) {
		super();
		this.cod=null;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.Estado=0;
		this.salida=null;
		this.entrada=null;
		this.visitas=0;
	}

	public int getEdad() {
	    return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	
	public void entrarGimnasio() {
		if(Estado==1) {
			System.out.println("El socio ya esta dentro");
			return;
		}
		entrada=LocalDateTime.now();
		Estado = 1;
		visitas++;
	}
	
	public void salidaGimnasio() {
		if(Estado==0) {
			System.out.println("El socio no esta dentro");
			return;
		}
		salida=LocalDateTime.now();
		Estado = 0;
	}
	
	public abstract double pagar();

	public String getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDateTime getSalida() {
		return salida;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public int getEstado() {
		return Estado;
	}

	public int getVisitas() {
		return visitas;
	}

	@Override
	public String toString() {
		return "Socio [cod=" + cod + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + ", salida=" + salida + ", entrada="
				+ entrada + ", Estado=" + Estado + ", visitas=" + visitas + "]";
	}
	
	
	
}
