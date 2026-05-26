package comerciales;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Comercial> comerciales = new ArrayList<Comercial>();
		Scanner sc = new Scanner(System.in);
		boolean otro = true;
		String nombre, tipo, marca;
		HashSet<String> marcas = new HashSet<String>();
		marcas.add("A");
		marcas.add("B");
		marcas.add("C");

		System.out.println("Anota sueldo fijo de los empleados que trabajan a sueldo fijo");

		do {

			System.out.println("Introduce nombre");
			nombre = sc.nextLine();
			System.out.println("Es un comercial fijo o con comision F/C");
			tipo = sc.nextLine();
			if (tipo.equalsIgnoreCase("F")) {
				comerciales.add(new Fijo(nombre));
			} else {
				do {
					System.out.println("Introduce marca");
					marca = sc.nextLine();
				} while (!marcas.contains(marca));
				comerciales.add(new Comision(nombre, marca));
			}

			if (comerciales.size() == 4) {
				System.out.println("No puedes introducir mas comerciales");
				otro = false;
			} else if (comerciales.size() >= 1 && comerciales.size() < 4) {
				System.out.println("Otro COmersial S/N");
				String respuesta = sc.nextLine();

				if (respuesta.equalsIgnoreCase("N")) {
					otro = false;
				}
			}
		} while (otro == true);

		System.out.println("Comerciales introducidos" + comerciales);

		System.out.println("Numero de empleado");
		int numero = sc.nextInt();

		while (numero != -1) {

			Comercial c = buscar(comerciales, numero);

			if (c != null) {
				System.out.println("Comercial encontrado" + c);
				System.out.println("Intrduce Marca");
				marca = sc.nextLine();

				if (marcas.contains(marca)) {

					System.out.println("Introduce numero de ventas ");
					int ventas = sc.nextInt();

					c.vender(marca, ventas);

				}

			}
			
			System.out.println("Numero de empleado");
			numero = sc.nextInt();
			
		}
	}

	public static Comercial buscar(ArrayList<Comercial> comerciales, int numero) {
		for (Comercial c : comerciales) {
			if (numero == c.getNumero()) {
				return c;
			}
		}
		return null;

	}

}

/*
 * //}while(comerciales.size()<1 || comerciales.size()>4);
 */