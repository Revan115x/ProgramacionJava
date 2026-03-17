package Sintaxis;

public class Excepciones {

	public static void main(String[] args) {

        /***********************************EXCEPCIONES*****************************************/

        /*
         * ¿Qué es una excepción?
         * - Es un error que ocurre en tiempo de ejecución.
         * - Rompe el flujo normal del programa.
         * - Se pueden controlar con try-catch.
         */

        /***********************************RUNTIME (Unchecked)*********************************/

        /* NullPointerException */
        String texto = null;
        try {
            System.out.println(texto.length()); // error: objeto null
        } catch (NullPointerException e) {
            System.out.println("Error: objeto null");
        }

        /* ArithmeticException */
        try {
            int x = 10 / 0; // dividir entre 0
        } catch (ArithmeticException e) {
            System.out.println("Error: división por cero");
        }

        /* ArrayIndexOutOfBoundsException */
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]); // índice inválido
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: índice fuera de rango en array");
        }

        /* NumberFormatException */
        try {
            int num = Integer.parseInt("abc"); // no es número
        } catch (NumberFormatException e) {
            System.out.println("Error: formato de número inválido");
        }

        /* IllegalArgumentException */
        try {
            Thread.sleep(-100); // argumento inválido
        } catch (IllegalArgumentException e) {
            System.out.println("Error: argumento inválido");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /***********************************CHECKED*****************************************/

        /* IOException y FileNotFoundException */
        try {
            java.io.FileReader archivo = new java.io.FileReader("archivo.txt");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado");
        }

        /* InterruptedException */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: hilo interrumpido");
        }

        /***********************************FINALLY*****************************************/

        try {
            int y = 5 / 1;
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.println("Esto siempre se ejecuta");
        }

        /***********************************CONSEJOS*****************************************/

        /*
         * - Usa excepciones específicas.
         * - No uses Exception para todo.
         * - Maneja errores solo si sabes qué hacer.
         * - Usa finally o try-with-resources para cerrar recursos.
         */
		
		
		
		/***********************************MÁS EXCEPCIONES*****************************************/
		
		/* ClassCastException */
		try {
		    Object obj = "Hola";
		    Integer num = (Integer) obj; // casting incorrecto
		} catch (ClassCastException e) {
		    System.out.println("Error: conversión de tipo inválida");
		}
		
		/* IndexOutOfBoundsException (listas) */
		try {
		    java.util.ArrayList<Integer> lista = new java.util.ArrayList<>();
		    lista.add(1);
		    System.out.println(lista.get(5)); // índice inválido
		} catch (IndexOutOfBoundsException e) {
		    System.out.println("Error: índice fuera de rango en lista");
		}
		
		/* NegativeArraySizeException */
		try {
		    int[] arr = new int[-5]; // tamaño negativo
		} catch (NegativeArraySizeException e) {
		    System.out.println("Error: tamaño negativo en array");
		}
		
		/* UnsupportedOperationException */
		try {
		    java.util.List<Integer> lista = java.util.List.of(1, 2, 3);
		    lista.add(4); // lista inmutable
		} catch (UnsupportedOperationException e) {
		    System.out.println("Error: operación no soportada");
		}
		
		/* NoSuchElementException */
		try {
		    java.util.Iterator<Integer> it = java.util.List.of(1,2,3).iterator();
		    while(true) {
		        System.out.println(it.next()); // cuando no hay más elementos
		    }
		} catch (java.util.NoSuchElementException e) {
		    System.out.println("Error: no hay más elementos");
		}
		
		/* IllegalStateException */
		try {
		    java.util.Scanner sc = new java.util.Scanner(System.in);
		    sc.close();
		    sc.nextLine(); // usar scanner cerrado
		} catch (IllegalStateException e) {
		    System.out.println("Error: estado ilegal del objeto");
		}
		
		/* SecurityException */
		try {
		    System.setSecurityManager(new SecurityManager());
		} catch (SecurityException e) {
		    System.out.println("Error: acción no permitida por seguridad");
		}
		
		/* ParseException (fechas) */
		try {
		    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		    sdf.parse("fecha_invalida");
		} catch (java.text.ParseException e) {
		    System.out.println("Error: formato de fecha inválido");
		}
		
	}
}
		/***********************************RESUMEN EXTRA*****************************************/
		
		/*
		 * MÁS IMPORTANTES PARA EXAMEN:
		 * - NullPointerException
		 * - ArrayIndexOutOfBoundsException
		 * - ArithmeticException
		 * - NumberFormatException
		 * - ClassCastException
		 * - IllegalArgumentException
		 * - IOException / FileNotFoundException
		 * - InterruptedException
		 * 
		 * 
		 * 
		 * Imposible convertir una cadena a un tipo de dato concreto:
			NumberFormatException, DateTimeParseException.
			➢ No poder crear una fecha o una hora porque los datos son incorrectos (
			método of): DateTimeException
			➢ Que al leer un número el formato no sea correcto:
			InputMistMachException.
			➢ Salirnos de los límites de un String: StringIndexOutOfBoundsException.
			➢ Dividir por cero: ArithMeticException.
			➢ Intentar acceder a un objeto que está sin instanciar:
			NullPointerException
			Creadas por el usuario.
			➢ IOException.
			➢ IllegalAccessException. (crear instancias, accede a campos o métodos
			sin tener acceso a la definición de la clase)
		 */
