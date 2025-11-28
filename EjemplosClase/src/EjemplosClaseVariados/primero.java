package EjemplosClaseVariados;

import java.util.Scanner;

public class primero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nota;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una nota:");
		nota = entrada.nextInt();
		if (nota >= 5) {
			System.out.println("Enhorabuena has aprobado");
		} else {
			System.out.println("Tienes que estudiar más, has suspendido");
		}
		System.out.println("Fin del programa");

	}

}
