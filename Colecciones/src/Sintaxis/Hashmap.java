package Sintaxis;

import java.util.HashMap;

public class Hashmap {

	public static void main(String[] args) {

		/***********************************
		 * HashMap
		 ***********************************/

		/*
		 * HashMap<K,V>
		 *
		 * K = Clave (Key) V = Valor (Value)
		 *
		 * Ejemplo:
		 *
		 * DNI -----> Nombre 111A ----> Juan 222B ----> Ana
		 *
		 * Las claves NO pueden repetirse. Los valores sí pueden repetirse.
		 */

		HashMap<String, String> alumnos = new HashMap<>();

		/**************************************************************************
		 * 1. AGREGAR ELEMENTOS
		 **************************************************************************/

		alumnos.put("111A", "Juan");
		alumnos.put("222B", "Ana");
		alumnos.put("333C", "Pedro");

		System.out.println("1) HashMap después de insertar:");
		System.out.println(alumnos);
		System.out.println();

		/**************************************************************************
		 * 2. TAMAÑO DEL HASHMAP
		 **************************************************************************/

		System.out.println("2) Número de elementos:");
		System.out.println(alumnos.size());
		System.out.println();

		/**************************************************************************
		 * 3. OBTENER UN VALOR
		 **************************************************************************/

		System.out.println("3) Nombre asociado al DNI 222B:");
		System.out.println(alumnos.get("222B"));
		System.out.println();

		/**************************************************************************
		 * 4. COMPROBAR SI EXISTE UNA CLAVE
		 **************************************************************************/

		if (alumnos.containsKey("111A")) {
			System.out.println("4) Existe el DNI 111A");
		}

		System.out.println();

		/**************************************************************************
		 * 5. COMPROBAR SI EXISTE UN VALOR
		 **************************************************************************/

		if (alumnos.containsValue("Ana")) {
			System.out.println("5) Existe Ana");
		}

		System.out.println();

		/**************************************************************************
		 * 6. MODIFICAR UN VALOR
		 **************************************************************************/

		alumnos.put("111A", "Juan Carlos");

		System.out.println("6) DNI 111A modificado:");
		System.out.println(alumnos);
		System.out.println();

		/**************************************************************************
		 * 7. ELIMINAR ELEMENTO
		 **************************************************************************/

		alumnos.remove("333C");

		System.out.println("7) Después de eliminar 333C:");
		System.out.println(alumnos);
		System.out.println();

		/**************************************************************************
		 * 8. RECORRER SOLO LAS CLAVES
		 **************************************************************************/

		System.out.println("8) Claves:");

		for (String clave : alumnos.keySet()) {
			System.out.println(clave);
		}

		System.out.println();

		/**************************************************************************
		 * 9. RECORRER SOLO LOS VALORES
		 **************************************************************************/

		System.out.println("9) Valores:");

		for (String valor : alumnos.values()) {
			System.out.println(valor);
		}

		System.out.println();

		/**************************************************************************
		 * 10. RECORRER CLAVE Y VALOR (LO MÁS USADO EN EXAMEN)
		 **************************************************************************/

		System.out.println("10) Clave y valor:");

		for (String clave : alumnos.keySet()) {

			System.out.println("DNI: " + clave + " Nombre: " + alumnos.get(clave));
		}

		System.out.println();

		/**************************************************************************
		 * 11. COMPROBAR SI ESTÁ VACÍO
		 **************************************************************************/

		System.out.println("11) ¿Está vacío?");
		System.out.println(alumnos.isEmpty());
		System.out.println();

		/**************************************************************************
		 * 12. BORRAR TODO  
		 **************************************************************************/

		alumnos.clear();

		System.out.println("12) Después de clear():");
		System.out.println(alumnos);
		System.out.println();

		/**************************************************************************
		 * 13. COMPROBAR SI ESTÁ VACÍO DESPUÉS DE BORRAR
		 **************************************************************************/

		System.out.println("13) ¿Está vacío ahora?");
		System.out.println(alumnos.isEmpty());

	}
}