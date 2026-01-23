package Coches;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String matricula, marca, modelo;
		int año, categoria,dias;
		boolean correcto;
		int opc,pos;
		double importeAlquiler;

		Vehiculo vehiculos[] = new Vehiculo[5];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < vehiculos.length; i++) {
			do {
				System.out.println("Introduce matrícula:");
				matricula = sc.nextLine();
				correcto = matricula.matches("[0-9]{4}[A-Z]{3}");
			} while (!correcto);
			System.out.println("Introduce marca:");
			marca=sc.nextLine();
			System.out.println("Introduce modelo:");
			modelo=sc.nextLine();
			System.out.println("Año de compra:");
			año=sc.nextInt();
			//Validar categoria
			System.out.println("Categoria:(1/2)");
			categoria=sc.nextInt();
			vehiculos[i]=new Vehiculo(matricula,modelo,marca,año,categoria);
		}
		
		do {
			System.out.println("1.Alquilar.\n2.Devolver.\n3.Inf.\n4.Información general\n5.Salir");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
			sc.nextLine(); //limpiar buffer	
			System.out.println("Introduce matrícula:");
			matricula=sc.nextLine();
			pos=buscarMatricula(vehiculos,matricula);
			if (pos==-1)
				System.out.println("No existe ese vehículo");
			else {
				if (vehiculos[pos].isAlquilado())
					System.out.println("Ya está alquilado");
				else {
					System.out.println("Por cuántos días quieres alquilarlo:");
					dias=sc.nextInt();		
					importeAlquiler=vehiculos[pos].alquilar(dias);
					if (importeAlquiler==0)
						System.out.println("Error alquilando, avise a sistemas");
					System.out.println("El importe de su alquiler es:"+importeAlquiler);
				}
			}	
			break;
			case 2:
				sc.nextLine(); //limpiar buffer
				System.out.println("Introduce matrícula:");
				matricula=sc.nextLine();
				pos=buscarMatricula(vehiculos,matricula);
				if (pos==-1)
					System.out.println("No existe ese vehículo");
					else {
						if (!vehiculos[pos].devolver())
							System.out.println("vehiculo devuelto con éxito");
							System.out.println(" Error devolviendo, avise a sistemas");
							}
				break;
			case 3:
				sc.nextLine(); //limpiar buffer
				System.out.println("Introduce matrícula:");
				matricula=sc.nextLine();
				pos=buscarMatricula(vehiculos,matricula);
				if (pos==-1)
					System.out.println("No existe ese vehículo");
				else
					System.out.println(vehiculos[pos].toString());
				break;
			case 4:
				for(int i=0;i<vehiculos.length;i++)
					System.out.println(vehiculos[i].toString());
				break;
			case 5:
				System.out.println("Fin del programa");
				System.out.println("Total vehiculos alquolados:"+Vehiculo.geta());
			default:
				System.out.println("Opción incorrecta");
		}
		}while(opc!=5);
		

	}
	/**
	 * Busca la matrícula en el array de vehículos
	 * @param v
	 * @param mat
	 * @return Devuelve la posición dónde ha encontrado el vehículo con esa matrícula, -1 si no lo  encuentra
	 */
	public static int buscarMatricula(Vehiculo v[],String mat) {
		for(int i=0;i<v.length;i++)
			if (v[i].getMatricula().equalsIgnoreCase(mat))
				return i;
		
		return -1;
	}

}
