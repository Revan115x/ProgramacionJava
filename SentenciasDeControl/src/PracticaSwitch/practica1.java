package PracticaSwitch;

import java.util.Scanner;

public class practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 2.Considera estás desarrollando un programa Java donde necesitas trabajar con
		 * objetos de tipo Motor (que representa el motor de una bomba para mover
		 * fluidos). Pide por teclado un número correspondiente a un motor y muestra un
		 * mensaje según las instrucciones siguientes:*/
		
		int motor;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce tu numero de motor");
		motor=sc.nextInt();
		
		switch(motor) {
			case 0:
				System.out.println("No hay establecido un valor definido para el tipo de bomba");
				break;
			case 2:
				System.out.println("La bomba es una bomba de gasolina");
				break;
			case 1:
				System.out.println("La bomba es una bomba de agua");
				break;
			case 3:
				System.out.println("La bomba es una bomba de hormigón");
				break;
			case 4:
				System.out.println("La bomba es una bomba de pasta alimenticia");
				break;
			default:
				System.out.println("No existe un valor válido para tipo de bomba");
		}
	}

}
