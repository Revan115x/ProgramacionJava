package Teatro;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String fecha, tituloObra = null;
		LocalDate fechaObra = null;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean fechaValida = false;
		int cont=0;

		Representacion proyectos[] = new Representacion[10];
		int opcion;

		do {
			System.out.println("1. Dar de alta una representación");
			System.out.println("2. Ordenar las representaciones");
			System.out.println("3. Mostrar la información de todas las representaciones que tengan entradas libres");
			System.out.println("4. Comprar entradas");
			System.out.println("5. Mostrar el importe total recaudado");
			System.out.println("6. Salir");
			opcion = sc.nextInt();
			sc.nextLine(); // Limpiar buffer

			switch (opcion) {
			case 1:
				
				if(cont==proyectos.length)
				do {

					System.out.println("Dime el título de la obra:");
					tituloObra = sc.nextLine();

					try {
						System.out.println("Dar de alta afecha de la obra | dd/mm/yyyy |");
						fecha = sc.nextLine();
						fechaObra = LocalDate.parse(fecha, patron);
						fechaValida = true;

					} catch (DateTimeParseException e) {
						System.out.println("Fecha no válida");
					}

				} while (!fechaValida);

				proyectos[cont] = new Representacion(tituloObra, fechaObra);

				break;
			case 2:
				// Ordenar las representaciones
				break;
			case 3:
				// Mostrar la información de todas las representaciones que tengan entradas
				// libres
				break;
			case 4:
				// Comprar entradas
				break;
			case 5:
				// Mostrar el importe total recaudado
				break;
			case 6:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (opcion != 6);

	}
	
	public static boolean buscarFecha(Representacion proyectos[],int cont,LocalDate f) {
		
		for(int i=0;i<cont;i++) {
			if(proyectos[i].getFecha().isEqual(f))
				return true;
		}
		
		return false;
		
	}

}


