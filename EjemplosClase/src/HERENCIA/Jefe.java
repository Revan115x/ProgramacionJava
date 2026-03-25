/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HERENCIA;



// Clase derivada de Empleado



public class Jefe extends Empleado
{
	private String ayudante; // S�lo los Jefes tienen ayudante


	public Jefe(String n,double s, int a,String sec){
		super(n,s,a);  // En la primera l�nea del constructor
		ayudante=sec;
		}

	// Este m�todo s�lo lo tienen los Jefes
	public String getAyudante(){
		return ayudante;
		}

	// Este m�todo redefine el m�todo de Empleado mismo prototipo pero diferente contenido.
	public void aumentoSalario(double porcentaje){
		double bonus = 0.5 * antiguedad;
		salario+=(salario * (bonus+porcentaje))/100;
		}

	// Este m�todo redefine el m�todo toString de empleado.
	public String toString()
	{
		// Llamamos al m�todo toString del empleado y le a�adimos la informaci�n del jefe
		// en este caso el ayudante.
		String s= super.toString() + ",ayudante:" + ayudante;
		return s;
	}
	
}
