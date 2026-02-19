package Nacionalidad_HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Haz un programa en el que se leen hasta anotar fin las distintas
		 * nacionalidades de los alumnos de una clase. Mostrad al final las
		 * nacionalidades que hay y cuántos alumnos hay de cada clase. Usad un HashMap.
		 */

		HashMap<String,Integer> Alum = new HashMap<>();
		
		Scanner sc=new Scanner (System.in);
	
		int alumno=0;
		String nacionalidad = null;
		
		/*Bucle para estar siempre dentro*/
		while(true) {
			
			System.out.println("Nacionalidad del alumno :"+alumno);
			nacionalidad=sc.nextLine();
			
			/*Si lee fin rompe bucle*/
			if(nacionalidad.equalsIgnoreCase("fin"))
				break;
			
			/*Si Alum contiene la misma nacionalidad, guarda la nacionalidad y le suma 1*/
			if(Alum.containsKey(nacionalidad))
				Alum.put(nacionalidad, Alum.get(nacionalidad) + 1);
			else
				/*si no esta y es otra nacionalidad se guarda normal*/
				Alum.put(nacionalidad, 1);
			
			alumno++;
				
		}
		
		/*For para leer los datos*/
		for(String lista : Alum.keySet() ) {
			/*Lista nos devuelve la key (nacionalidad) y alum.get(lista) nos devuelve el dato en este caso la cantidad*/
			System.out.println("Nacionalidad: "+lista + " tiene " +Alum.get(lista) +" Alumnos");
		}
		
		
	}

}
