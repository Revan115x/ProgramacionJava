package Ejercicio1;

public class ArrayReales {
	private double[] array;
	
	public ArrayReales(double[] array) {
		this.array = array;
	}

	public double minimo() {
		if (array.length==0) {
			return 0;
		}
		double minimo=array[0];
		for (int i=0; i<array.length; i++) {
			if (i< minimo) {
				minimo=i;
			}
		}
		return minimo;
		
	}
	

}
