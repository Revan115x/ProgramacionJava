package ejercicio_1;


public class CalculadoraFinanciera {

		
	    public static double aplicarDescuento(double precio, double porcentaje) {
	        return precio - (precio * porcentaje / 100);
	    }

	    public static double convertirDolaresAEuros(double dolares, double tasaCambio) {
	        return (int) (dolares * tasaCambio);
	    }


	 
	    public static String categorizarInversion(double monto) {
	        if (monto < 1000) {
	            return "Baja";
	        } else if (monto > 1000) {
	            return "Alta";
	        }
	        return null; 
	    }
	
}
 	