package Debbuger;

public class EjercicioDebugger3 {

	 public static void generarPatron(int tamano) {
	    	 for (int i = 1; i < tamano; i++) { // Bucle externo (Filas)
		          
		            for (int j = 1; j <= tamano; j++) { // Bucle interno (Columnas)
		                if (j < i) {
		                   System.out.print("*");
		                } else {
		                    System.out.print(" "); // Pone un espacio para completar la forma
		                }
		            }
		            System.out.println();
	    	 }
	    }
	    
	    public static void main(String[] args) {
	        generarPatron(5);
	    }
	
	

}
