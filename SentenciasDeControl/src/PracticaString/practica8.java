package PracticaString;

import java.util.Scanner;

public class practica8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cadena;
		int opc;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota cadena a procesar");
		cadena=sc.nextLine();
		System.out.println("Introduce opcion: 1 Matricula,2 nif 3codigo postal, 4telefono");
		opc=sc.nextInt();
		
		switch(opc) {
		
		case 1:
			if(cadena.matches("^[0-9]{4}[a-zA-Z]{3}$"))
				System.out.println("codigo matricula correcto");
			else
				System.out.println("matricula incorrecta");
			break;
		case 3:
			if(cadena.matches("28[0-9]{3}$"))
				System.out.println("codigo postal correcto");
			else
				System.out.println("codigo postal incorrecto");
			break;
		case 4:
			if(cadena.matches("⁽6|7|9)[0-9]{8}$"))
				System.out.println("telefono correcto");
			else
				System.out.println("telefono incorrecto");
			break;
		default:
			System.out.println("error");
		}
		
	}

}
