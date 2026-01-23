package Empresa;

public class Empresa {

	/*
	 * Una empresa se dedica al alquiler de plazas de garaje. De cada uno de ellos
	 * guarda el número que lo identifica, los metros cuadrados, la planta en la que
	 * está y el precio de alquiler. El alquiler es de 18€ más • 3€ si está en la 1a
	 * planta • 1,50€ si está en la 2a • 1 si está en una planta inferior
	 * 
	 * Tema IV: P.O.O Módulo: Programación
	 * 
	 * D.A.W. Página - 2 Si el garaje tiene más de 4m2 pagará 1,5€ más sobre el
	 * precio anterior y si tiene menos de 3m2 el precio disminuirá en 1€. Programa
	 * que crea un array con 5 garajes, con un menú en el que aparezcan las
	 * siguientes opciones: - Alquilar un garaje: se pide el número y se busca en el
	 * array. Si no existe se indica, si está alquilado se indica. Si está libre se
	 * procede a alquilarlo. Todos los garajes se alquilan por un período de un año.
	 * - Mostrar el precio de alquiler de un garaje: se pide su número - Mostrar la
	 * información de los garajes que estén libres - Subir el precio de un garaje:
	 * se pide por teclado un porcentaje y se aumenta el precio de un garaje, sólo
	 * si está libre. - Mostrar los beneficios de la empresa.
	 */

	private int num;
	private double metros;
	private int planta;
	private static final double baseprecio=18;
	private double finalprecio,beneficios;
	private boolean alquilado;

	public Empresa(int num, double metros, int planta ,int periodo) {
		super();
		this.num = num;
		this.planta = planta;
		this.metros = metros;
		finalprecio=baseprecio;

		/* Precio por planta */
		if (planta == 1)
			finalprecio += 3;
		if (planta == 2)
			finalprecio += 1.5;
		if (planta <= 0)
			finalprecio += 1;

		/* Precio por MetroCuadrado */

		if (metros > 4)
			finalprecio += 1.5;
		if (metros < 3)
			finalprecio -= 1;
		
		
	}

	public double alquiler() {
		if(alquilado==true)
			return 0;
		alquilado=true;
		beneficios+=finalprecio;
		return finalprecio;
	}
	
	public boolean subirPrecio(double porcentaje) {
		if(alquilado)
			return false;
	
		finalprecio += finalprecio * porcentaje / 100;
	    return true;		
		
	}

	@Override
	public String toString() {
		return "Empresa [num=" + num + ", metros=" + metros + ", planta=" + planta + ", finalprecio=" + finalprecio
				+ ", alquilado=" + alquilado + "]";
	}

}
