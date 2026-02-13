package colecciones.ejHashMaps;

import java.util.HashMap;

public class ejloHashMap {
    public static void main(String[] args) {
        // Crear un HashMap para almacenar nombres y edades
        HashMap<String, Integer> edades = new HashMap<>();

        // Insertar pares clave-valor
        edades.put("Juan", 30);
        edades.put("Maria", 25);
        edades.put("Pedro", 40);

        // Acceder a un valor asociado a una clave
        System.out.println("La edad de Mar�a es: " + edades.get("Mar�a"));
        String nombreC="Maria";
        System.out.println("hashCode de "+nombreC+" es: "+nombreC.hashCode());
        nombreC="juan";
        System.out.println("hashCode de "+nombreC+" es: "+nombreC.hashCode());
        nombreC="Pedro";
        System.out.println("hashCode de "+nombreC+" es: "+nombreC.hashCode());
        
        System.out.println(edades.toString(	));

        // Comprobar si una clave existe
        if (edades.containsKey("Pedro")) {
            System.out.println("Pedro est� en el HashMap");
        }

        // Iterar sobre el conjunto de claves
        for (String nombre : edades.keySet()) {
            System.out.println(nombre + " tiene " + edades.get(nombre) + " a�os.");
        }

        // Eliminar un elemento
        edades.remove("Juan");

        // Imprimir el tama�o actual del HashMap
        System.out.println("N�mero de elementos: " + edades.size());
    }
}


	


