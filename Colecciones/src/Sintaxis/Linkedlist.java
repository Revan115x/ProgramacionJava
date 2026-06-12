package Sintaxis;

import java.util.LinkedList;
import java.util.ListIterator;

public class Linkedlist {

    public static void main(String[] args) {

        /*********************************** LinkedList ***********************************/

        /*
         * LinkedList<E>
         *
         * E = Tipo de objeto que almacena.
         *
         * Características:
         *
         * - Mantiene el orden de inserción.
         * - Permite elementos repetidos.
         * - Muy rápida para insertar o eliminar elementos.
         * - Más lenta que ArrayList para acceder a posiciones concretas.
         *
         * Ejemplo:
         *
         * Posición 0 -> Ana
         * Posición 1 -> Luis
         * Posición 2 -> Pedro
         */

        LinkedList<String> alumnos = new LinkedList<>();


        /**************************************************************************
         * 1. AGREGAR ELEMENTOS
         **************************************************************************/

        alumnos.add("Ana");
        alumnos.add("Luis");
        alumnos.add("Pedro");

        System.out.println("1) LinkedList después de insertar:");
        System.out.println(alumnos);
        System.out.println();


        /**************************************************************************
         * 2. AGREGAR AL PRINCIPIO Y AL FINAL
         **************************************************************************/

        alumnos.addFirst("Marta");
        alumnos.addLast("Carlos");

        System.out.println("2) Después de addFirst y addLast:");
        System.out.println(alumnos);
        System.out.println();


        /**************************************************************************
         * 3. TAMAÑO DE LA LISTA
         **************************************************************************/

        System.out.println("3) Número de elementos:");
        System.out.println(alumnos.size());
        System.out.println();


        /**************************************************************************
         * 4. OBTENER ELEMENTO POR POSICIÓN
         **************************************************************************/

        System.out.println("4) Elemento en posición 0:");
        System.out.println(alumnos.get(0));
        System.out.println();


        /**************************************************************************
         * 5. OBTENER PRIMERO Y ÚLTIMO
         **************************************************************************/

        System.out.println("5) Primer elemento:");
        System.out.println(alumnos.getFirst());

        System.out.println("Último elemento:");
        System.out.println(alumnos.getLast());

        System.out.println();


        /**************************************************************************
         * 6. MODIFICAR ELEMENTO
         **************************************************************************/

        alumnos.set(0, "Juan");

        System.out.println("6) Después de modificar posición 0:");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 7. ELIMINAR POR POSICIÓN
         **************************************************************************/

        alumnos.remove(0);

        System.out.println("7) Después de eliminar posición 0:");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 8. ELIMINAR POR VALOR
         **************************************************************************/

        alumnos.remove("Pedro");

        System.out.println("8) Después de eliminar Pedro:");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 9. ELIMINAR PRIMERO Y ÚLTIMO
         **************************************************************************/

        alumnos.removeFirst();
        alumnos.removeLast();

        System.out.println("9) Después de removeFirst y removeLast:");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 10. COMPROBAR SI EXISTE UN ELEMENTO
         **************************************************************************/

        if(alumnos.contains("Luis")) {
            System.out.println("10) Luis existe en la lista");
        }

        System.out.println();


        /**************************************************************************
         * 11. OBTENER POSICIÓN DE UN ELEMENTO
         **************************************************************************/

        int posicion = alumnos.indexOf("Luis");

        System.out.println("11) Posición de Luis:");
        System.out.println(posicion);

        System.out.println();


        /**************************************************************************
         * 12. RECORRER CON FOR CLÁSICO
         **************************************************************************/

        System.out.println("12) Recorrido con for:");

        for(int i = 0 ; i < alumnos.size() ; i++) {

            System.out.println(alumnos.get(i));

        }

        System.out.println();


        /**************************************************************************
         * 13. RECORRER CON FOR-EACH
         **************************************************************************/

        System.out.println("13) Recorrido con for-each:");

        for(String nombre : alumnos) {

            System.out.println(nombre);

        }

        System.out.println();


        /**************************************************************************
         * 14. RECORRER CON LISTITERATOR
         **************************************************************************/

        ListIterator<String> it = alumnos.listIterator();

        System.out.println("14) Hacia adelante:");

        while(it.hasNext()) {

            System.out.println(it.next());

        }

        System.out.println();

        System.out.println("14) Hacia atrás:");

        while(it.hasPrevious()) {

            System.out.println(it.previous());

        }

        System.out.println();


        /**************************************************************************
         * 15. CLONAR LINKEDLIST
         **************************************************************************/

        LinkedList<String> copia = new LinkedList<>(alumnos);

        System.out.println("15) Copia de la lista:");
        System.out.println(copia);

        System.out.println();


        /**************************************************************************
         * 16. COMPROBAR SI ESTÁ VACÍA
         **************************************************************************/

        System.out.println("16) ¿Está vacía?");
        System.out.println(alumnos.isEmpty());

        System.out.println();


        /**************************************************************************
         * 17. BORRAR TODO
         **************************************************************************/

        alumnos.clear();

        System.out.println("17) Después de clear():");
        System.out.println(alumnos);

        System.out.println();


        /**************************************************************************
         * 18. COMPROBAR SI ESTÁ VACÍA DESPUÉS DE BORRAR
         **************************************************************************/

        System.out.println("18) ¿Está vacía ahora?");
        System.out.println(alumnos.isEmpty());

    }
}