package examen_bucles;

import java.util.Scanner;

public class examen_p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*lee un numero y muestra todos los numeros no lo dividen*/
	
		int num;
		
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		
		for(int i=1;i<num;i++) {
			if(num%i!=0)
				System.out.println(i);
		}
		
	}

}
