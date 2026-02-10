package Alumnos;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Scanner sc = new Scanner(System.in);
		int opc, pos;
		double nota;
		String nombre;
		sc.useLocale(Locale.ENGLISH);

		do {

			System.out.println("1. DAR ALTA ALUMNO");
			System.out.println("2. CAMBIAR NOTA ALUMNO");
			System.out.println("3. SUSTITUIR ALUM");
			System.out.println("4. BORRAR ALUMNO");
			System.out.println("5. DATOS ALUMNO");
			System.out.println("6. SALIR");
			opc = sc.nextInt();

			switch (opc) {

			case 1:
				System.out.println("Nombre alumno");
				nombre = sc.nextLine();
				//pos = buscar(alumnos, nombre);
				pos=alumnos.indexOf(new Alumno(nombre));
				if (pos != -1)
					System.out.println("Ya existe ese alumno");
				else {
					System.out.println("Introduce nota: ");
					nota = sc.nextDouble();
					// Alumno al=new alumno(nombre,nota);
					// Alumno.add(al);
					alumnos.add(new Alumno(nombre, nota));
				}
				break;
			case 2:
				System.out.println("nombre alumno");
				nombre = sc.nextLine();
				pos = buscar(alumnos, nombre);
				if (pos != -1)
					System.out.println("Ya existe ese alumno");
				else {
					System.out.println("Introduce la nueva nota: ");
					nota = sc.nextDouble();
					alumnos.get(pos).setNota(nota);
				}
				break;
			case 3:
				System.out.println("Nombre alumno");
				nombre = sc.nextLine();
				pos = buscar(alumnos, nombre);
				if (pos != -1)
					System.out.println("Ya existe ese alumno");
				else {
					System.out.println("Nombre nuevo Alumno");
					nombre=sc.nextLine();
					System.out.println("Introduce la nota del nuevo Alumno");
					nota=sc.nextDouble();
					Alumno a=new Alumno(nombre,nota);
					alumnos.set(pos, a);
					//alumnos.get(pos)=a;
				}
				break;
			case 4:
				System.out.println("Nombre alumno");
				nombre = sc.nextLine();
				pos = buscar(alumnos, nombre);
				if (pos != -1)
					System.out.println("Ya existe ese alumno");
				else {
					alumnos.remove(pos);
				}
			case 5: 
				System.out.println("Nombre alumno");
				nombre = sc.nextLine();
				pos = buscar(alumnos, nombre);
				if (pos != -1)
					System.out.println("Ya existe ese alumno");
				else {
					System.out.println("Estos son los datos del alumno" +alumnos.get(pos).toString());
				}
				break;
			}

		} while (opc != 6);

	}

	public static int buscar(ArrayList<Alumno> alumnos, String nombre) {
		for (int i = 0; i < alumnos.size(); i++) {
			return i;
		}
		return -1;
	}

}
