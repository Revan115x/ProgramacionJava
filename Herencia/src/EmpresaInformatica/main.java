package EmpresaInformatica;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		empleados.add(new Propios("Juan", "111A", "Madrid", "600111111", 1200));
		empleados.add(new Externos("Ana", "222B", "Barcelona", "600222222", "Accenture"));
		empleados.add(new Propios("Luis", "333C", "Valencia", "600333333", 1500));
		
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println("1. Dar Alta Empleado");
			System.out.println("2. Fichar Empleado");
			System.out.println("3. Reparto de beneficios");
			System.out.println("4. Pagar a todos los empleados de la empresa,");
			System.out.println("5. Informacion Empleado");
			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {
			case 1:
				System.out.println("Nombre Empleado");
				String nombre = sc.nextLine();
				System.out.println("DNI");
				String dni = sc.nextLine();
				System.out.println("Direccio");
				String direccion = sc.nextLine();
				System.out.println("Numero Telefono");
				String telefono = sc.nextLine();

				System.out.println("Que tipo de empleado es 1.Externo / 2.Propio");
				int tipo = sc.nextInt();
				sc.nextLine();
				
				switch (tipo) {
				case 1:
					System.out.println("Empresa");
					String empresa = sc.nextLine();
					empleados.add(new Externos(nombre, dni, direccion, telefono, empresa));
					break;
				case 2:
					System.out.println("Salario");
					double salario = sc.nextDouble();
					empleados.add(new Propios(nombre, dni, direccion, telefono, salario));
					break;
				default:
					System.out.println("No existe esa opcion");
					break;
				}

				break;
			case 2:
				boolean existe=false;
				if (empleados.size() == 0)
					System.out.println("no hay empleados");
				else {
					System.out.println("Identificador del empleado");
					int ident = sc.nextInt();
					for (Empleado empl : empleados) {
						if (ident == empl.getNumeroId()) {
							System.out.println("Horas Trabajadas");
							int horas = sc.nextInt();
							empl.sumarHoras(horas);
							existe=true;
							break;
						}
					}if(existe==false)
						System.out.println("NO EXISTE ESE EMPLEADO");
				}
				break;
			case 3:
				if (empleados.size() == 0) {
					System.out.println("no hay empleados");
				} else {
					int propios = 0;

					for (Empleado empl : empleados) {

						if (empl instanceof Propios)
							propios++;
					}
					if (propios == 0) {
						System.out.println("NO HAY EMPLEADOS PROPIOS");

					} else {
						System.out.println("DIME UNA CANTIDAD DE DINERO");
						double dinero = sc.nextDouble();

						double reparto = dinero / propios;

						for (Empleado empl : empleados) {
							if (empl instanceof Propios)
								((Propios) empl).añadirBeneficio(reparto);

						}
					}
				}
				break;
			case 4:
				if (empleados.size() == 0) {
					System.out.println("no hay empleados");
				} else {
					for (Empleado empl : empleados) {
						System.out.println("EL EMPLEADO :"+empl.getNombre());
						System.out.println("SU COBRO ES DE :"+empl.pagarEmpl());
					}
				}
				break;
			case 5:
				if (empleados.size() == 0) {
					System.out.println("no hay empleados");
				} else {
					for (Empleado empl : empleados) {
						System.out.println("EL EMPLEADO"+empl);
					}
				}
				break;
				
			}
		} while (opc != 5);

	}

}
