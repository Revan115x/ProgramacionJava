package EjemplosClaseVariados;

import java.util.Scanner;

public class EjSwitch3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char arit;
		int num1, num2, resultado;
		
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Anota número: ");
		num1=entrada.nextInt();
		System.out.println("Anota otro número: ");
		num2=entrada.nextInt();
		//Esta lectura es para limpiar el buffer, se hace sólo cuando después
		// de leer un número, se lee un caracter
		//entrada.nextLine();
		System.out.println("Pon una letra para el cálculo (S o s -> suma; R o r -> resta; P, p, M o m -> producto; D o d -> división): ");
		arit=entrada.nextLine().charAt(0);
		
		switch(arit) {
			case 'S':
			case 's': resultado=num1+num2;
				System.out.println("La suma de ambos números da: "+resultado);
			break;
			
			
			case 'R':
			case 'r': resultado=num1-num2;
				System.out.println("La resta de ambos números da: "+resultado);
			break;
			
			
			case 'P':
			case 'p':
			case 'M':
			case 'm': resultado=num1*num2;
				System.out.println("El producto de ambos números da: "+resultado);
			break;
			
			
			case 'D':
			case 'd': resultado=num1/num2;
				System.out.println("La división de ambos números da: "+resultado);
			break;	
		}
		
	}

}
