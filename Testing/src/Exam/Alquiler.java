package Exam;

public class Alquiler {

	private String matricula;
	private String modelo;
	private String marca;
	private static int categoria = 0;
	private static boolean alquilado;
	private static double gananciasVeh = 0;

	

	public Alquiler(String matricula, String modelo, String marca,  int categoria) {

		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.categoria = categoria;
		this.alquilado = false;
	}

	public static double alquiler(int dias) {
		double precio = 0;

		if (alquilado == true) 
			return 0;
		
		if (dias < 0)
			return -1;
		switch (categoria) {
		case 1:
			if (dias >= 2) 
				precio = dias * 30;

		   else 
				precio = dias * 45;
		   break;
		case 2:
			if (dias > 2) 
				precio = dias * 40;
			 else 
				precio = dias + 50;				
			break;		

		}
		gananciasVeh = precio;
		return precio;
	}

	public static void devolver() {
		alquilado=false;
	}

	public double getGananciasVeh() {
		return gananciasVeh;
	}


}