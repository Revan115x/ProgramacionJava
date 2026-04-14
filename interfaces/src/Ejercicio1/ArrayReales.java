package Ejercicio1;

public class ArrayReales {
	private double[] array;

	public ArrayReales(double[] array) {
		this.array = array;
	}

	public double minimo() {
		if (array.length == 0) {
			return 0;
		}
		double minimo = array[0];
		for (int i = 0; i < array.length; i++) {
			if (i < minimo) {
				minimo = i;
			}
		}
		return minimo;
	}

	
	public double maximo() {
		if (array.length == 0) {
			return 0;
		}
		double maximo = array[0];
		for (int i = 0; i < array.length; i++) {
			if (i > maximo) {
				maximo = i;
			}
		}
		return maximo;
	}
	
	public double sumatorio() {
		double sumatorio = 0;
		for (int i = 0; i < array.length; i++) {
			sumatorio += array[i];
		}
		return sumatorio;
	}
}
