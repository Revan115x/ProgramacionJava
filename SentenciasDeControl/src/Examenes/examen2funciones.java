package Examenes;

import java.util.Locale;
import java.util.Scanner;

public class examen2funciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Se quieren procesar las marcas de varios saltadores de longitud en una
		 * prueba. Por cada atleta se anotan los siguientes datos: - Su dorsal: validar
		 * que sea una cadena de longitud 6, con 3 letras en mayúsculas, que es el país,
		 * y 3 dígitos. Leedlo hasta que sea correcto. Usad una función para validar el
		 * código (1 pto)
		 * 
		 * - Su categoría: M (masculino) o F (femenino), leedla hasta que sea correcta
		 * (0,5 pto). -
		 * 
		 * A continuación el atleta realiza 3 saltos de longitud (usad bucle) (1 ptos).
		 * Codificar una función que me diga si un salto es nulo (1 pto) Tenemos en
		 * cuenta que se considera un salto nulo: Por debajo de 6.82 metros en categoría
		 * femenina. Por debajo de 8.22 metros en categoría masculina. Si los tres
		 * saltos son nulos, o se anota un -1 en la longitud de uno de los saltos, el
		 * atleta queda descalificado en ese momento y se pasa al siguiente. (1 pto) En
		 * otro caso nos quedamos con la longitud del salto mayor de este atleta y lo
		 * mostramos por pantalla.(1 pto) El proceso termina cuando se hayan anotado al
		 * menos 2 atletas de cada categoria.(1 pto) Mostrad al terminar: - El mejor
		 * salto femenino y el país de procedencia de la atleta. (1 pto) - La longitud
		 * media de los saltos los atletas masculinos (1 pto) - El total de saltos nulos
		 * realizados.(0,5 pto) Modificad el programa para que el usuario pueda
		 * introducir tantas pruebas de salto como quiera, mostrando al finalizar el
		 * número total de saltos realizados . (1 pto)
		 */

		boolean correcto = false;
		String genero = "";
		String pais="";
		int cont = 0;
		double metros,mejorsalto=0,media = 0;

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("numero");
			String dorsal = sc.nextLine();

			System.out.println("Pais que representas");
			pais = sc.nextLine();

			if (dorsal.length() >= 3 && pais.length() >= 3) {
				correcto = true;
				String codigo = validardorsal(dorsal, pais);
				System.out.println("tu codigo es " + codigo);
			} else {
				System.out.println("tienes un error");
				correcto = false;
			}
		} while (!correcto);

		correcto = false;

		do {
			System.out.println("tipo de categoria (M/F)");
			genero = sc.nextLine();

			genero = genero.toUpperCase();

			if (genero.contentEquals("M") || genero.contentEquals("F")) {
				correcto = true;
				String categoria = validargenero(genero);
				System.out.println("tu categoria es " + categoria);
			} else {
				System.out.println("error");
				correcto = false;
			}

		} while (!correcto);

		System.out.println("longitud de salto");
		sc.useLocale(Locale.ENGLISH);

		for (int i = 0; i < 3; i++) {
			
			System.out.println("saltos"+i+":");
			metros = sc.nextDouble();
			
			if(metros==-1) {
				System.out.println("descalificado");
				break;
			}
			
			if (genero.equalsIgnoreCase("M")) {
				if (metros > 8.22) {
					cont++;
					metros+=metros;
					media=metros/i;
					
				} else {
					System.out.println("no cuenta");
				}
			} else if (genero.equalsIgnoreCase("F")) {
				if (metros > 6.82) {
					cont++;
					if(metros>mejorsalto) {
						mejorsalto=metros;
					}
					
				} else {
					System.out.println("no cuenta");
				}
				

			}
			
			if(cont==0) {
				System.out.println("Estas descalificado");
				break;
			}
		}
		
		System.out.println("El mejor salto femenino es "+mejorsalto+ "y el pais "+pais);
		System.out.println("la media de saltos masculinos es "+media);
		System.out.println("saltos validos "+cont);

	}

	public static String validardorsal(String numero, String pais) {

		if (numero.length() >= 3 || pais.length() >= 3) {
			String codigoDorsal = numero.substring(0, 3) + pais.substring(0, 3);
			return codigoDorsal;
		} else
			System.out.println("error");

		return "";

	}

	public static String validargenero(String sexo) {

		if (sexo.equalsIgnoreCase("M"))
			return sexo = "masculino";
		else if (sexo.equalsIgnoreCase("F"))
			return sexo = "femenino";
		else
			System.out.println("error");
		return "";

	}

}
