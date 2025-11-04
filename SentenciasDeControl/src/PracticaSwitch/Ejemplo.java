package PracticaSwitch;


import java.util.Scanner;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int puesto;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce Tu puesto en la carrera");
		puesto=sc.nextInt();
		
		switch(puesto) {
		case 1:
			System.out.println("ORO");
			break;
		case 2:
			System.out.println("PLATA");
			break;
		case 3:
			System.out.println("BRONCE");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("DIPLOMA");
			break;
		default: 
			System.out.println("No tienes premio");
		}
		System.out.println("FIND DEL PROGRAMA");
	}

}
