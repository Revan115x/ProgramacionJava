package EjemplosLocalDate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Ejemplo2bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia,mes,año;
		LocalDate fecha=null;
		
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("Anota dia:");
			dia=sc.nextInt();
			System.out.println("Anota mes:");
			mes=sc.nextInt();
			System.out.println("Anota año:");
			año=sc.nextInt();
			try {
			fecha=LocalDate.of(año,mes,dia);
			}catch(DateTimeException e) {
				System.out.println("Fecha incorrecta");
			}
			
		}while(fecha==null);
		
		

	}

}
