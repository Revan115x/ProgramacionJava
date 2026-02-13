package Notas.hashMap;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class notas {

	/*Version hashMap de alumnos*/
	
	public static void main(String[] args) {
		HashMap<String, Double> notas = new HashMap<String, Double>();
		
		Scanner sc = new Scanner(System.in);
		int opc, pos;
		double nota;
		String nombre = null;
		sc.useLocale(Locale.ENGLISH);

		do {

			System.out.println("1. DAR ALTA ALUMNO");
			System.out.println("2. CAMBIAR NOTA ALUMNO");
			System.out.println("3. SUSTITUIR ALUM");
			System.out.println("4. BORRAR ALUMNO");
			System.out.println("5. DATOS ALUMNO");
			System.out.println("6. SALIR");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {

			case 1:
				System.out.println("Nombre alumno");
				nombre = sc.nextLine();
				/*Comprobamos si existe el alumno, si esta no podemos seguir*/
				if (notas.containsKey(nombre)) {
					System.out.println("Ya existe ese alumno");
					opc=6;
				}else {
					System.out.println("Introduce nota: ");
					nota = sc.nextDouble();
					/*Guardamos los datos que hemos recogido en notas*/
					notas.put(nombre,nota);
				}
				break;
			case 2:
				System.out.println("nombre alumno");
				nombre = sc.nextLine(); 
				if (!notas.containsKey(nombre)) {
					System.out.println("No existe ese alumno");
					opc=6;
				}else {
					System.out.println("Introduce la nueva nota: ");
					nota = sc.nextDouble();
					notas.put(nombre, nota);
				}
				break;
			case 3:
				System.out.println("Nombre alumno");
				nombre = sc.nextLine();
				if (!notas.containsKey(nombre))
					System.out.println("NO EXISTE EL ALUMNO");
				else {
					System.out.println("Nombre nuevo Alumno");
					nombre=sc.nextLine();
					System.out.println("Introduce la nota del nuevo Alumno");
					nota=sc.nextDouble();
					notas.put(nombre, nota);
				}
				break;
			case 4:
				System.out.println("Nombre alumno");
				nombre = sc.nextLine();
				if (!notas.containsKey(nombre))
					System.out.println("NO EXISTE EL ALUMNO NO LO PUEDES ELIMINAR");
				else {
					System.out.println("SE HA ELIMINADO CORRECTAMENTE HA "+notas.get(nombre));
					notas.remove(nombre);
				}
			case 5: 
				if(notas.isEmpty())
					System.out.println("NO HAY USUARIOS");
				for( String alumnos: notas.keySet()) {
					System.out.println("EL ALUMNO "+notas.keySet()+"con nota de"+notas.get(nombre));
				}
			}

		} while (opc != 6);

		System.out.println("HAS SALIDO DEL PROGRAMA");
		
	}
}
