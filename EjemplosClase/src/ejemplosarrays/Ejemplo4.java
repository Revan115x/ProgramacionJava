package ejemplosarrays;

import java.util.Locale;
import java.util.Scanner;

public class Ejemplo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double media = 0;
		boolean encontrado=false;
		String dia;
		String dias[] = { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" };
		double temperaturas[] = new double[7];

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);

		for (int i = 0; i < dias.length; i++) {
			System.out.println("Introduce temperatura del " + dias[i]);
			temperaturas[i] = sc.nextDouble();
			media += temperaturas[i];
		}

		System.out.println("La temperatura media es:" + media / 7);
		sc.nextLine(); //Limpio buffer
		System.out.println("Anota día de la semana para saber su temperatura:");
		dia = sc.nextLine();
		/*
		for (int i = 0; i < dias.length; i++) {
			if (dias[i].equalsIgnoreCase(dia)) {
				System.out.println("La temperatura del " + dia + " fue de " + temperaturas[i] + " grados");
				encontrado=true;
				break;
			}
		}
		if (!encontrado)
			System.out.println("Día no encontrado");
		*/
		/*
		int pos=buscarDia(dias,dia);
		if (pos==-1)
			System.out.println("Dia no encontrado");
		else
			System.out.println("La temperatura del " + dia + " fue de " + temperaturas[pos] + " grados");
			*/
		
		try {
			int pos=buscarDia2(dias,dia);
			System.out.println("La temperatura del " + dia + " fue de " + temperaturas[pos] + " grados");
		} catch (NoExisteDiaException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Busca un día en el array de días y devuelve la posición en la que lo encuentra
	 * @param dias Array de dias
	 * @param dia Dia que quiero buscar
	 * @return si lo encuentra retorna la posición y si no lo encuentra retorna -1
	 */
	public static int buscarDia(String dias[],String dia) {
		for (int i = 0; i < dias.length; i++) {
			if (dias[i].equalsIgnoreCase(dia)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Busca un día en el array de días y devuelve la posición en la que lo encuentra, 
	 * y una excepción si no lo encuentra
	 * @param dias Array dónde hay que hacer la búsqueda
	 * @param dia String que estoy buscando
	 * @return posición en la que ha encontrado el día
	 * @throws NoExisteDiaException Excepción que devuelve si no encuentra el dia
	 */
	public static int buscarDia2(String dias[],String dia) throws NoExisteDiaException {
		for (int i = 0; i < dias.length; i++) {
			if (dias[i].equalsIgnoreCase(dia)) {
				return i;
			}
		}
		throw new NoExisteDiaException("Dia no encontrado");
	}

}
