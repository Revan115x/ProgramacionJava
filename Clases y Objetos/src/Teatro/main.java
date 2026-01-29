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

		String fecha,tituloObra ;
		LocalDate fechaObra;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean fechaValida = false;

		Teatro proyectos[] = new Teatro[10];
		int opcion;

		do {
			System.out.println("1. Dar de alta una representación");
			System.out.println("2. Ordenar las representaciones");
			System.out.println("3. Mostrar la información de todas las representaciones que tengan entradas libres");
			System.out.println("4. Comprar entradas");
			System.out.println("5. Mostrar el importe total recaudado");
			System.out.println("6. Salir");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				sc.nextLine(); // Limpiar buffer
				do {
					try {
						System.out.println("Dar de alta afecha de la obra | dd/mm/yyyy |");
						fecha = sc.nextLine();
						fechaObra = LocalDate.parse(fecha, patron);
						fechaValida = true;

					} catch (DateTimeParseException e) {
						System.out.println("Fecha no válida");
					} 
					
				System.out.println("Dime el título de la obra:");
				tituloObra= sc.nextLine();
				proyectos[0]= new Teatro(tituloObra, fechaObra);
					
					
				} while (!fechaValida);
				
				
				
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

}
