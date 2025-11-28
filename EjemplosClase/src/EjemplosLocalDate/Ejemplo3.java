package EjemplosLocalDate;

import java.time.LocalDate;
import java.util.Scanner;

public class Ejemplo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dias;
		//LocalDate fechaFinal;
		Scanner sc=new Scanner(System.in);
		LocalDate mifecha=LocalDate.now();
		System.out.println("Anota dias:");
		dias=sc.nextInt();
		mifecha=mifecha.plusDays(dias);
		System.out.println("La fecha final es:"+mifecha);
		
	}

}
