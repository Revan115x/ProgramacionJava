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
		
		LocalDateTime tiempo = LocalDateTime.now();
		Random rand = new Random();

        // Simular tirar un dado de 6 caras
        int dado = rand.nextInt(6) + 1;

		tiempo = tiempo.plusMinutes(1);

		if(dado==6) {
			int cont=0;
			cont++;
			System.out.println("se ha repetido el numero 6 "+cont);
		}

	}

}
