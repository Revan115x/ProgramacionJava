package Debbuger;

public class EjercicioDebugger2 {


	    public static void calcularInteres(double capital, double tasa) {
	        int anios = 0;
	        while (capital < 1000.0) { // Condición de salida
	            capital = capital * (1 + tasa);
	            anios++;
	        }
	        System.out.println("Se necesitaron " + anios + " años para superar $1000. Capital final: " + capital);
	    }
	    
	    public static void main(String[] args) {
	        calcularInteres(500.0, 0.05); // Tarda muchas iteraciones
	    }
	}


