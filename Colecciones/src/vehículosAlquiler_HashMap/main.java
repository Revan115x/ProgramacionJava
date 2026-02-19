package vehículosAlquiler_HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String matricula, marca, modelo;
		int año, categoria, dias;
		boolean correcto;
		int opc, pos;
		double importeAlquiler;

		HashMap<String, Vehiculo> Autos = new HashMap<String, Vehiculo>();
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("AUTO NUMERO: " +i);
			do {
				System.out.println("Introduce matrícula:");
				matricula = sc.nextLine();
				correcto = matricula.matches("[0-9]{4}[A-Z]{3}");
			} while (!correcto);
			System.out.println("Introduce marca:");
			marca = sc.nextLine();
			System.out.println("Introduce modelo:");
			modelo = sc.nextLine();
			System.out.println("Año de compra:");
			año = sc.nextInt();
			// Validar categoria
			System.out.println("Categoria:(1/2)");
			categoria = sc.nextInt();
			
			Autos.put(matricula, new Vehiculo(matricula, modelo, marca, año, categoria));
			sc.nextLine(); // limpiar buffer
		}
		do {
			System.out.println("1.Alquilar.\n2.Devolver.\n3.Inf.\n4.Información general\n5.Salir");
			opc = sc.nextInt();
			sc.nextLine(); // limpiar buffer
			switch (opc) {
			
			case 1:
				System.out.println("Introduce matrícula:");
				matricula = sc.nextLine();

				if (!Autos.containsKey(matricula))
					System.out.println("No existe ese vehículo");
				else {
					if (Autos.get(matricula).isAlquilado())
						System.out.println("Ya está alquilado");
					else {
						System.out.println("Por cuántos días quieres alquilarlo:");
						dias = sc.nextInt();
						importeAlquiler = Autos.get(matricula).alquilar(dias);
						if (importeAlquiler == 0)
							System.out.println("Error alquilando, avise a sistemas");
						System.out.println("El importe de su alquiler es:" + importeAlquiler);
					}
				}
				break;
			case 2:
				sc.nextLine(); // limpiar buffer
				System.out.println("Introduce matrícula:");
				matricula = sc.nextLine();
				if (Autos.get(matricula).isAlquilado())
					System.out.println("No existe ese vehículo");
				else {
					if (Autos.get(matricula).devolver())
						System.out.println("vehiculo devuelto con éxito");
					System.out.println(" Error devolviendo, avise a sistemas");
				}
				break;
			case 3:
				sc.nextLine(); // limpiar buffer
				System.out.println("Introduce matrícula:");
				matricula = sc.nextLine();
				if (Autos.get(matricula).isAlquilado())
					System.out.println("No existe ese vehículo");
				else
					System.out.println(Autos);
				break;
			case 4:
				for (String key : Autos.keySet()) {
					System.out.println(Autos.get(key));
				}
				break;
			case 5:
				System.out.println("Fin del programa");
				System.out.println("Total vehiculos alquolados:" + Vehiculo.getTotalGanancias());
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opc != 5);

	}

}
