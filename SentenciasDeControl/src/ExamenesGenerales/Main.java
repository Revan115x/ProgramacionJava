package ExamenesGenerales;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate fecha;
		String tipo, usuario;
		double importe;
		
		// Leer y validar los datos
		
		fecha=LocalDate.now();
		tipo="Familiar";
		usuario="A234bB";
		
		try {
			importe=calcularImporte(fecha,tipo,usuario);
			System.out.println("El importe a pagar es de:"+importe+" euros");
		} catch (EdadIncorrectaException e) {
			// TODO Auto-generated catch block
			System.out.println("Se ha producido un error al calcular el importe");
			System.out.println(e.getMessage());
		}
		

	}
	
	public static double calcularImporte(LocalDate fecha, String tipo,String usuario) throws EdadIncorrectaException {
		double imp=0;
		long edad;
		if (tipo.equalsIgnoreCase("normal"))
			imp=10;
		else
			if (tipo.equalsIgnoreCase("VIP"))
				imp=50;
			else
				imp=30;
		
		edad=ChronoUnit.YEARS.between(LocalDate.now(), fecha);
		if (edad>65)
			imp=imp*0.8;
		else
			if (edad<18)
				imp=imp*0.9;
		
		if (edad<18 && tipo.equalsIgnoreCase("Familiar"))
			throw new EdadIncorrectaException("No se permite tipo familiar a menores");
		
		return imp;
	}

}
