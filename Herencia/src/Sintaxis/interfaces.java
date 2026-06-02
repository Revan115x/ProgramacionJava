/*
=================================================
TEMA X: INTERFACES
=================================================

"Desde el punto de vista de un programador,
el usuario no es más que un periférico que
teclea cuando se le envía una petición de lectura."

=================================================
1. ¿QUÉ ES UNA INTERFACE?
=================================================

Una interfaz es un contrato.

Define QUÉ métodos debe tener una clase,
pero NO cómo se implementan.

Sintaxis:

interface NombreInterfaz{

    tipo metodo1();
    void metodo2();

}

Una clase la implementa usando:

class MiClase implements NombreInterfaz{

}

=================================================
2. PROPIEDADES IMPORTANTES
=================================================

✓ Los métodos se declaran, no se implementan.

✓ Las variables son automáticamente:
    public static final

✓ No se puede hacer:

    new MiInterfaz();

✓ Una clase puede implementar
  varias interfaces.

✓ Una interfaz puede heredar de otra.

✓ Obliga a implementar todos
  los métodos declarados.
*/

/*
=================================================
3. EJEMPLO BÁSICO
=================================================
*/

interface Machine{

    String suena();

    void reset();
}

class Vehiculo implements Machine{

    private String matricula;
    private int kms;

    public Vehiculo(String matricula){

        this.matricula = matricula;
        kms = 0;
    }

    public void recorrer(int km){

        kms += km;
    }

    @Override
    public String suena(){

        return "Piiiiii";
    }

    @Override
    public void reset(){

        kms = 0;
    }

    @Override
    public String toString(){

        return matricula + " - " + kms;
    }
}

/*
=================================================
4. POLIMORFISMO CON INTERFACES
=================================================

Puedo declarar:

Machine m;

Y asignarle cualquier objeto que implemente
Machine.
*/

class Prueba{

    public static void main(String[] args){

        Machine m = new Vehiculo("1234ABC");

        System.out.println(m.suena());
    }
}

/*
=================================================
5. VARIAS INTERFACES
=================================================
*/

interface Volador{

    void volar();
}

interface Nadador{

    void nadar();
}

class Pato implements Volador,Nadador{

    @Override
    public void volar(){

        System.out.println("Volando");
    }

    @Override
    public void nadar(){

        System.out.println("Nadando");
    }
}

/*
=================================================
6. INTERFACE QUE HEREDA DE OTRA
=================================================
*/

interface Animal{

    void comer();
}

interface Ave extends Animal{

    void volar();
}

/*
Si una clase implementa Ave
debe implementar:

comer()
volar()
*/

/*
=================================================
7. COMPARABLE
=================================================

MUY IMPORTANTE EN EXÁMENES

Sirve para definir el ORDEN NATURAL
de los objetos.

Tiene UN SOLO método:

compareTo()

La clase Collections.sort()
lo utiliza automáticamente.

=================================================
REGLA compareTo()
=================================================

this < otro  -> negativo

this = otro  -> 0

this > otro  -> positivo
*/

/*
=================================================
EJEMPLO 1
ORDENAR POR EDAD
=================================================
*/

import java.util.*;

class Persona implements Comparable<Persona>{

    private String nombre;
    private int edad;

    public Persona(String nombre,int edad){

        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad(){

        return edad;
    }

    @Override
    public int compareTo(Persona otra){

        return this.edad - otra.edad;
    }

    @Override
    public String toString(){

        return nombre + " " + edad;
    }
}

/*
MAIN

ArrayList<Persona> lista = new ArrayList<>();

lista.add(new Persona("Juan",25));
lista.add(new Persona("Ana",18));
lista.add(new Persona("Pedro",30));

Collections.sort(lista);

Resultado:

Ana 18
Juan 25
Pedro 30
*/

/*
=================================================
EJEMPLO 2
ORDENAR POR NOMBRE
=================================================
*/

@Override
public int compareTo(Persona otra){

    return nombre.compareTo(otra.nombre);
}

/*
Orden alfabético.
*/

/*
=================================================
8. COMPARATOR
=================================================

Comparable = 1 criterio fijo

Comparator = muchos criterios

Tiene:

compare(o1,o2)

MUY PREGUNTADO EN EXAMEN
*/

/*
=================================================
ORDENAR POR EDAD
=================================================
*/

class ComparadorEdad implements Comparator<Persona>{

    @Override
    public int compare(Persona p1,Persona p2){

        return p1.getEdad() - p2.getEdad();
    }
}

/*
Uso:

Collections.sort(lista,new ComparadorEdad());
*/

/*
=================================================
ORDENAR POR EDAD DESCENDENTE
=================================================
*/

class ComparadorEdadDesc
implements Comparator<Persona>{

    @Override
    public int compare(Persona p1,Persona p2){

        return p2.getEdad() - p1.getEdad();
    }
}

/*
Resultado:

30
25
18
*/

/*
=================================================
ORDENAR POR NOMBRE
=================================================
*/

class ComparadorNombre
implements Comparator<Persona>{

    @Override
    public int compare(Persona p1,Persona p2){

        return p1.getNombre()
                 .compareTo(p2.getNombre());
    }
}

/*
=================================================
9. ORDENACIÓN COMBINADA
=================================================

MUY TÍPICO DE EXAMEN

Ordenar:

1º Edad
2º Nombre

Si la edad es igual.
=================================================
*/

class ComparadorEdadNombre
implements Comparator<Persona>{

    @Override
    public int compare(Persona p1,Persona p2){

        int r = p1.getEdad() - p2.getEdad();

        if(r != 0)
            return r;

        return p1.getNombre()
                 .compareTo(p2.getNombre());
    }
}

/*
Datos:

Juan 20
Ana 20
Pedro 18

Resultado:

Pedro 18
Ana 20
Juan 20
*/

/*
=================================================
10. ORDENAR POR FECHA
=================================================
*/

import java.time.LocalDate;

class Alumno{

    private String nombre;
    private LocalDate fechaNacimiento;

    public LocalDate getFechaNacimiento(){

        return fechaNacimiento;
    }
}

class ComparadorFecha
implements Comparator<Alumno>{

    @Override
    public int compare(Alumno a1,Alumno a2){

        return a1.getFechaNacimiento()
                 .compareTo(
                     a2.getFechaNacimiento()
                 );
    }
}

/*
Más antiguo primero.
*/

/*
=================================================
11. ORDENAR POR HORA
=================================================
*/

import java.time.LocalTime;

class Evento{

    private LocalTime hora;

    public LocalTime getHora(){

        return hora;
    }
}

class ComparadorHora
implements Comparator<Evento>{

    @Override
    public int compare(Evento e1,Evento e2){

        return e1.getHora()
                 .compareTo(e2.getHora());
    }
}

/*
08:30
10:15
12:00
18:45
*/

/*
=================================================
12. ORDENAR POR FECHA Y HORA
=================================================

OTRO CLÁSICO DE EXAMEN
=================================================
*/

class ComparadorFechaHora
implements Comparator<Evento>{

    @Override
    public int compare(Evento e1,Evento e2){

        int r = e1.getFecha()
                  .compareTo(e2.getFecha());

        if(r != 0)
            return r;

        return e1.getHora()
                 .compareTo(e2.getHora());
    }
}

/*
1º Fecha
2º Hora
*/

/*
=================================================
13. COMPARATOR ANÓNIMO
=================================================
*/

Collections.sort(lista,
    new Comparator<Persona>(){

        @Override
        public int compare(Persona p1,
                           Persona p2){

            return p1.getEdad()
                 - p2.getEdad();
        }
});

/*
=================================================
14. RUNNABLE
=================================================

Permite crear hilos.

Obliga a implementar run().
*/

class Tarea implements Runnable{

    @Override
    public void run(){

        for(int i=1;i<=5;i++){

            System.out.println(i);
        }
    }
}

/*
Lanzar hilo
*/

Thread t = new Thread(new Tarea());

t.start();

/*
NO usar:

t.run();

Porque no crea un hilo.
*/

/*
=================================================
15. COLLECTIONS FRAMEWORK
=================================================

Collection
│
├── List
│   │
│   ├── ArrayList
│   ├── Vector
│   └── LinkedList
│
├── Set
│   │
│   ├── HashSet
│   └── TreeSet
│
└── Map
    │
    └── HashMap

=================================================
RESUMEN DE EXAMEN
=================================================

INTERFACE
---------
Contrato de métodos.

IMPLEMENTS
----------
class C implements I

VARIAS INTERFACES
-----------------
implements I1,I2,I3

COMPARABLE
----------
Orden natural.

compareTo()

Collections.sort(lista)

COMPARATOR
----------
Muchos criterios.

compare(o1,o2)

Collections.sort(lista,comparador)

ORDEN COMBINADO
---------------
if(resultado!=0)
    return resultado;

comparar segundo campo

RUNNABLE
--------
run()
Thread
start()

PREGUNTAS TÍPICAS EXAMEN
------------------------

✓ Ordenar por edad.

✓ Ordenar por nombre.

✓ Ordenar por fecha.

✓ Ordenar por fecha y hora.

✓ Ordenar por edad y nombre.

✓ Diferencia entre
  Comparable y Comparator.

✓ Implementar una interfaz.

✓ Runnable y Threads.
*/