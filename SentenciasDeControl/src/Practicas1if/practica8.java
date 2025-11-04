package Practicas1if;

import java.util.Scanner;

public class practica8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int peso,altura,imc;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce tu peso");
		peso=sc.nextInt();
		
		System.out.println("introduce tu peso");
		altura=sc.nextInt();
		
		imc=peso/altura;
		
		if(imc<16)
			System.out.println("Criterio de ingreso en hospital");
		else
			if(imc<17)
				System.out.println("infrapeso");
		
			else
				if(imc<18)
					System.out.println("bajo peso");
		
				else 
					if(imc<25)
						System.out.println("peso normal (saludable)");
		
					else
						if(imc<30)
							System.out.println("(obesidad de grado I)");
		
						else
							if(imc<35)
								System.out.println("sobrepeso crónico");
		
							else
								if(imc<40)
									System.out.println("obesidad premórbida");
		
								else
									System.out.println("obesidad mórbida");
								
	}

}
