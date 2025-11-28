package PracticasBucles2;

import java.util.Scanner;

public class Practica7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * En una empresa se rellena una ficha por cada empleado con los siguientes
		 * datos: Número de empleado Sueldo Horas extras Precio hora extra Otros
		 * ingresos Algoritmo que escribe aquellos empleados(su número) que reciben más
		 * de 600 € al mes, así como lo que perciben. El proceso termina cuando el
		 * número de empleado es 0. Se utilizarán un método para calcular el salario
		 * final flota calcularSalario(float sueldo, int horas, float precioHora, float
		 * otros)
		 */
		
		int numEmp,horasExtr;
		float sueldo,precioExtra,otrosIngresos,sueldoTotal;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("introduce numero de empleado");
		numEmp=sc.nextInt();
		while(numEmp!=0) {
			
			System.out.println("Introduce sueldo: ");
			sueldo=sc.nextFloat();
			System.out.println("Introduce horas Extras");
			horasExtr=sc.nextInt();
			System.out.println("Introduce Precio horas Extras");
			precioExtra=sc.nextFloat();
			System.out.println("Introduce otros ingresos");
			otrosIngresos=sc.nextFloat();
			
			sueldoTotal=calcularSalario(sueldo,horasExtr,precioExtra,otrosIngresos);
			if(sueldoTotal>600)
					System.out.println("EL empleado"+numEmp+" Gana "+sueldoTotal);
				System.out.println("introduce numero del empleado");
				numEmp=sc.nextInt();
		}
		

	}

		public static float calcularSalario(float sueldo,int horas,float precioHora, float otros ) {
		float total;
		total=sueldo+horas*precioHora+otros;
		return total;
		}
}

