package PracticasWhile;

import java.util.Scanner;

public class practica8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Pedir el salario de 10 empleados.
		 *  Mostrar cuantos ganan más de 1000€.
		 */

		int salario, cont = 0;

		Scanner sc = new Scanner(System.in);

		for (int empleado = 0; empleado <= 1; empleado++) {

			System.out.println("di numero");
			salario = sc.nextInt();

			if (salario >= 1000)
				cont += 1;
		}
		
		
		/*int empleado=0;
				
		while(empleado<=0) {
			
			System.out.println("di numero");
			salario = sc.nextInt();

			if (salario >= 1000)
				cont += 1;
				empleado++;
		}*/

		System.out.println(+cont);

	}

}
