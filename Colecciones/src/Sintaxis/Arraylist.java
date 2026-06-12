package Sintaxis;

import java.util.ArrayList;
import java.util.ListIterator;

public class Arraylist {

    public static void main(String[] args) {

        /*********************************** ArrayList ***********************************/

        /*
         * ArrayList<E>
         *
         * E = Tipo de objeto que almacena.
         *
         * Características:
         *
         * - Mantiene el orden de inserción.
         * - Permite elementos repetidos.
         * - Permite acceder rápidamente a una posición concreta.
         * - Muy utilizado cuando necesitamos guardar muchos objetos.
         *
         * Ejemplo:
         *
         * Posición 0 -> Ana
         * Posición 1 -> Luis
         * Posición 2 -> Pedro
         */

        ArrayList<String> alumnos = new ArrayList<>();


        /**************************************************************************
         * 1. AGREGAR ELEMENTOS
         **************************************************************************/

        alumnos.add("Ana");
        alumnos.add("Luis");
        alumnos.add("Pedro");

        System.out.println("1) ArrayList después de insertar:");
        System.out.println(alumnos);
        System.out.println();


        /**************************************************************************
         * 2. TAMAÑO DE LA LISTA
         **************************************************************************/

        System.out.println("2) Número de elementos:");
        System.out.println(alumnos.size());
        System.out.println();


        /**************************************************************************
         * 3. OBTENER ELEMENTO POR POSICIÓN
         **************************************************************************/

        System.out.println("3) Elemento en posición 0:");
        System.out.println(alumnos.get(0));

        System.out.println();


        /**************************************************************************
         * 4. MODIFICAR ELEMENTO
         **************************************************************************/

        alumnos.set(0, "Marta");

        System.out.println("4) Después de modificar posición 0:");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 5. ELIMINAR POR POSICIÓN
         **************************************************************************/

        alumnos.remove(1);

        System.out.println("5) Después de eliminar posición 1:");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 6. ELIMINAR POR VALOR
         **************************************************************************/

        alumnos.remove("Pedro");

        System.out.println("6) Después de eliminar Pedro:");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 7. COMPROBAR SI EXISTE UN ELEMENTO
         **************************************************************************/

        if(alumnos.contains("Marta")) {
            System.out.println("7) Marta existe en la lista");
        }

        System.out.println();


        /**************************************************************************
         * 8. OBTENER POSICIÓN DE UN ELEMENTO
         **************************************************************************/

        int posicion = alumnos.indexOf("Marta");

        System.out.println("8) Posición de Marta:");
        System.out.println(posicion);

        System.out.println();


        /**************************************************************************
         * 9. RECORRER CON FOR CLÁSICO
         **************************************************************************/

        System.out.println("9) Recorrido con for:");

        for(int i = 0 ; i < alumnos.size() ; i++) {

            System.out.println(alumnos.get(i));

        }

        System.out.println();


        /**************************************************************************
         * 10. RECORRER CON FOR-EACH
         **************************************************************************/

        System.out.println("10) Recorrido con for-each:");

        for(String nombre : alumnos) {

            System.out.println(nombre);

        }

        System.out.println();


        /**************************************************************************
         * 11. RECORRER CON LISTITERATOR
         **************************************************************************/

        ListIterator<String> it = alumnos.listIterator();

        System.out.println("11) Hacia adelante:");

        while(it.hasNext()) {

            System.out.println(it.next());

        }

        System.out.println();

        System.out.println("11) Hacia atrás:");

        while(it.hasPrevious()) {

            System.out.println(it.previous());

        }

        System.out.println();


        /**************************************************************************
         * 12. CLONAR ARRAYLIST
         **************************************************************************/

        ArrayList<String> copia = new ArrayList<>(alumnos);

        System.out.println("12) Copia de la lista:");
        System.out.println(copia);

        System.out.println();


        /**************************************************************************
         * 13. COMPROBAR SI ESTÁ VACÍA
         **************************************************************************/

        System.out.println("13) ¿Está vacía?");
        System.out.println(alumnos.isEmpty());

        System.out.println();


        /**************************************************************************
         * 14. BORRAR TODO
         **************************************************************************/

        alumnos.clear();

        System.out.println("14) Después de clear():");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 15. COMPROBAR SI ESTÁ VACÍA DESPUÉS DE BORRAR
         **************************************************************************/

        System.out.println("15) ¿Está vacía ahora?");
        System.out.println(alumnos.isEmpty());

    }
}