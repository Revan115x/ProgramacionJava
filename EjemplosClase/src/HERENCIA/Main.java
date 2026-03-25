/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package HERENCIA;


public class Main {
	public static void main(String[] st){

		// En el mismo array puedo mezclar Jefes y Empleados
		Empleado plantilla[] = new Empleado[4];
		plantilla[0]=new Jefe("F�lix Mu�oz",200000,2,"Estefan�a Sanz");
		plantilla[1]=new Empleado("Amaya Uriarte",100000,1);
		plantilla[2]=new Empleado("Luis Ricote",120000,2);
		plantilla[3]=new Jefe("Luis Ricote",120000,2,"Carlos");

		int i;
		for(i=0; i<3; i++)
			// Ejecuta el m�todo toString del Jefe o del Empleado dependiendo
			// de la clase a la que pertenezca el objeto guardado en  plantilla[i]
			System.out.println(plantilla[i].toString());
		for(i=0; i<3; i++)
			// Ejecuta el m�todo del Jefe o el del Empleado dependiendo
			// de la clase a la que pertenezca el objeto guardado en plantilla[i]
			plantilla[i].aumentoSalario(5);

		for(i=0; i<3; i++)
			// Ejecuta el m�todo toString del Jefe o del Empleado dependiendo
			// de la clase a la que pertenezca el objeto guardado en  plantilla[i]
			System.out.println(plantilla[i].toString());
		
		for (i=0; i<plantilla.length; i++){
			if (plantilla[i] instanceof Jefe){
				System.out.println(((Jefe)plantilla[i]).getAyudante());
			}
		

		}
		
	
	}
}
