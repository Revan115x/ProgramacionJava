package PracticaLocalDate;

import java.time.LocalDateTime;
import java.util.Random;

public class practica8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Simular durante 1 minuto el lanzamiento de un dado, pasado ese tiempo mostrar
		 * la cantidad de seises que han salido
		 */

		LocalDateTime inicio = LocalDateTime.now();// genero una variable con mi tiempo actual
		LocalDateTime fin = inicio.plusSeconds(1);// le digo el fin es mi tiempo actual + 1segundo
		Random rand = new Random();// genero un random
		int cont = 0;// contador para contar cuantas veces se repite 6


		while (LocalDateTime.now().isBefore(fin)) {// bucle para que mi tiempo actual no se pase de fin

			int dado = rand.nextInt(6) + 1;//el dado tiene que estar dentro del bucle porque aqui va ir cambiando

			if (dado == 6) { //si el dado es 6 cuenta
				cont++;
			}
		}
		
		System.out.println("se ha repetido el numero 6 " + cont);

	}
}
