package ejemplosClase.ejemplos;

import java.util.Scanner;

public class EjDowhile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char operación;
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Anota operación:(+ - * /");
			operación=sc.nextLine().charAt(0);
		}while(operación!='+' && operación!='-' && operación!='*' && operación!='/');
		
		// Salgo del bucle porque
		// operación=='+' || operación=='-' || operación=='*' || operación=='/'
		System.out.println("Operación anotada correcta");

	}

}
