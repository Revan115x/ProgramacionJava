package colegio;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

import bbdd.*;
import modelos.Alumno;
import modelos.Curso;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sLeer = new Scanner(System.in);
		int opc = 0;

		BD_Colegio bd = new BD_Colegio("mysql-properties.xml");

		do {
			System.out.println("\n\nGESTI�N COLEGIO");
			System.out.println("***************");
			System.out.println("1.Nuevo Alumno\n" + "2.Nuevo Curso\n3.Borrar Alumno\n4.Listado alumnos por curso\n"
					+ "5.Listado de cursos\n" + "6.Consultar alumno\n" + "7.Consultar tutor de un curso\n"
					+ "8.Listado alumnos por tutor\n" + "9.Listado alumnos por curso");
			System.out.print("\tTeclea opci�n: ");
			try {
				opc = sLeer.nextInt();
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir n�mero 1-5");
				opc = 0;
			}

			sLeer.nextLine();
			switch (opc) {
			case 1:
				System.out.println("\n\nALTA ALUMNO");
				
				System.out.print("Introduce nombre completo\t");
				String nombre = sLeer.nextLine();
				
				System.out.print("Introduce telefono\t");
				String telefono = sLeer.nextLine();
				
				System.out.print("Introduce DNI\t");
				String dni = sLeer.nextLine();
				
				System.out.print("Introduce n�mero de matr�cula\t");
				int matricula = sLeer.nextInt();
				
				Vector<String> cursos;
				
					try {
						cursos = bd.listadoCursos();
					} catch (ErrorBaseDatos e) {
						System.out.println("Contacte con sistemas:" + e.getMessage());
						break;
					}
					
				if (cursos == null) {
					System.out.println("No hay cursos disponibles");
					break;
				}
				
				System.out.println("Lista de cursos");
				
				for (int i = 0; i < cursos.size(); i++)
					System.out.println(cursos.get(i));
				
				System.out.print("Teclea el curso\t");
				String curso = sLeer.next();
				
				Alumno al = new Alumno(dni, nombre, curso, matricula, telefono);
				
				int filas;
				
				try {
					filas = bd.añadir_Alumno(al);
					switch (filas) {
					case 1:
						System.out.println("\nAlumno a�adido");
						break;
					case 0:
						System.out.println("\nNo a�adido, contacte con sistemas");
						break;

					}
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println("Contacte con sistemas:" + e.getMessage());
				}

				break;
				
			case 2:
				System.out.println("\n ALTA NUEVO CURSO");
				
				System.out.println("Indicame la descripcion del curso");
				String descripcion=sLeer.nextLine();
				
				System.out.println("Nombre del nuevo CURSO");
				String Curso=sLeer.nextLine();
				
				System.out.println("numero de Aula");
				String aula=sLeer.nextLine();
				
				Curso curs = new Curso (descripcion,Curso,aula);
				
				try {
					filas = bd.añadir_Curso(curs);
					switch (filas) {
					case 1:
						System.out.println("\n Curso añadido");
						break;
					case 0:
						System.out.println("\nNo a�adido, contacte con sistemas");
						break;

					}
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println("Contacte con sistemas:" + e.getMessage());
				}

				
				break;

			case 4:
				cursos = null;
				try {

					cursos = bd.listadoCursos();

				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:" + e.getMessage());
					break;
				}
				if (cursos == null) {
					System.out.println("No hay cursos disponibles");
					break;
				}
				System.out.println("Lista de cursos");
				for (int i = 0; i < cursos.size(); i++)
					System.out.println(cursos.get(i).toString());

				System.out.print("Teclea el curso del cual quieres ver los alumnos\t");
				curso = sLeer.next();
				ArrayList<Alumno> listado = null;
				try {
					listado = bd.listadoAlumnosCurso(curso);
				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:" + e.getMessage());
					break;
				}

				System.out.println("\n\nLISTADO ALUMNOS " + curso.toUpperCase() + "\n");
				for (int i = 0; i < listado.size(); i++)
					System.out.println(listado.get(i).toString());
				break;

			case 9:
				try {
					bd.listadoAlumnosPorCurso();
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} while (opc != 10);

	}

}
