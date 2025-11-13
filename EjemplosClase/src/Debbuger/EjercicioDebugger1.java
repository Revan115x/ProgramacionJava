package Debbuger;

public class EjercicioDebugger1 {

	    public static void evaluarNumero(int numero) {
	        String resultado = "Indeterminado";

	        if (numero > 0) {
	            if (numero % 2 == 0) {
	                resultado = "Positivo y Par";
	            } else {
	                resultado = "Positivo e Impar";
	            }
	        } else if (numero < 0) {
	            // Lógica con una rama "oculta" para -1 a -9
	            if (numero > -10 && numero < 0) { 
	                resultado = "Negativo Pequeño";
	            } else {
	                resultado = "Negativo Grande";
	            }
	        } else {
	            resultado = "Es Cero";
	        }
	        System.out.println("El número " + numero + " es: " + resultado);
	    }
	    
	    public static void main(String[] args) {
	        evaluarNumero(7);
	        evaluarNumero(-15);
	        evaluarNumero(-3); // Clave para la rama "oculta"
	        evaluarNumero(0);
	    }
}


