package gym;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import Banco.cuentaCuenton;
import Banco.cuentaNormal;
import EmpresaInformatica.Externos;
import EmpresaInformatica.Propios;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int opc;
		String nif;
		double dinero = 0;
		ArrayList<Socio> socios = new ArrayList<Socio>();
		socios.add(new socioN("Juan", "Garcia", "600111222", LocalDate.of(1998, 5, 10)));
		socios.add(new socioN("Maria", "Lopez", "611222333", LocalDate.of(1970, 8, 25)));
		socios.add(new Preferentes("Pedro", "Martinez", "622333444", LocalDate.of(1960, 2, 15)));
		socios.add(new Preferentes("Ana", "Sanchez", "633444555", LocalDate.of(1985, 11, 30)));

		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechanacimiento = null;

		do {
			System.out.println("1. ALTA NUEVA SOCIO");
			System.out.println("2. FICHAR ENTRADA");
			System.out.println("3. FICHAR SALIDA");
			System.out.println("4. INFORMACION SOCIOS");
			System.out.println("5. COBRAR SOCIOS");
			System.out.println("6. SALIR");

			opc = sc.nextInt();

			sc.nextLine();
			switch (opc) {
			case 1:
				System.out.println("NOMBRE");
				String nombre = sc.nextLine();
				System.out.println("APELLIDO");
				String apellido = sc.nextLine();
				System.out.println("NUMERO TELEFONO");
				String telefono = sc.nextLine();
				System.out.println("FECHA NACIMIENTO");
				String fecha = sc.nextLine();
				try {
					fechanacimiento = LocalDate.parse(fecha, patron);
				} catch (DateTimeParseException e) {
					System.out.println(e.getMessage());
				}

				System.out.println("DIME EL TIPO 1.SOCIO NORMAL / 2 SOCIO PREFERENTE");
				int tipo = sc.nextInt();
				sc.nextLine();

				switch (tipo) {
				case 1:
					socios.add(new socioN(nombre, apellido, telefono, fechanacimiento));
					break;
				case 2:
					socios.add(new Preferentes(nombre, apellido, telefono, fechanacimiento));
					break;
				default:
					System.out.println("No existe esa opcion");
					break;
				}
				break;
			case 2:
				if (socios.size() == 0)
					System.out.println("NO HAY SOCIOS");
				else {
					boolean encontrado = false;
					System.out.println("Identificacion");
					String id = sc.nextLine();

					for (Socio s : socios) {
						if (id.equalsIgnoreCase(s.cod)) {
							encontrado = true;
							s.entrarGimnasio();
						}
					}
					if (encontrado != true)
						System.out.println("NO ENCONTRADO");

				}
				break;
			case 3:
				if (socios.size() == 0)
					System.out.println("NO HAY SOCIOS");
				else {
					boolean encontrado = false;
					System.out.println("Identificacion");
					String id = sc.nextLine();

					for (Socio s : socios) {
						if (id.equalsIgnoreCase(s.cod)) {
							encontrado = true;
							s.salidaGimnasio();
						}
					}
					if (encontrado != true)
						System.out.println("NO ENCONTRADO");

				}
				break;
			case 4:
				if (socios.size() == 0)
					System.out.println("NO HAY SOCIOS");
				else {
					for (Socio s : socios) {
						System.out.println("El SOCIO : " + s.toString());
						System.out.println("VISITAS : " + s.visitas);
					}
				}
				break;
			case 5:
				if (socios.size() == 0)
					System.out.println("NO HAY SOCIOS");
				else {
					for (Socio s : socios) {
						if (s.getEstado() == 0) {
							System.out.println("EL CLIENTE : " + s.getCod());
							System.out.println("NUMERO DE VISITAS SON : " + s.getVisitas());
						}
						if (s.getVisitas() > 0)
							System.out.println("DEBE PAGAR : " + s.pagar());
					}
				}
				break;
			}
		} while (opc != 6);

	}

}
