package MontañaRusa;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ArrayList<Persona> cola = new ArrayList<Persona>();
		int opc;
		Random r = new Random();
		Persona[] atraccion = new Persona[4];

		// Genero el codigo para la entradaCodigo
		char letra = (char) ('A' + r.nextInt(26));
		int numero = r.nextInt(100);
		String codigo = letra + String.format("%02d", numero);

		do {
			System.out.println("1. Llegar a la cola");
			System.out.println("2. Order la cola");
			System.out.println("3. Montar Atraccion");
			System.out.println("4. Empezar Atraccion");
			System.out.println("5. Parar Atraccion");
			System.out.println("6. Mostrar informacion Atraccion");
			System.out.println("7. Salir");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				System.out.println("Fecha Nacimiento");
				String fecha = sc.nextLine();
				LocalDate fch = LocalDate.parse(fecha);
				int años = (int) ChronoUnit.YEARS.between(fch, LocalDate.now());
				double Altura = r.nextInt(70, 211);
				int tipo = r.nextInt(1, 4);
				switch (tipo) {
				case 1:
					cola.add(new entradaNormal(años, Altura));
					break;
				case 2:

					cola.add(new entradaBono(años, Altura));
					break;
				case 3:
					cola.add(new entradaCodigo(años, Altura, codigo));
					break;

				}
				break;
			case 2:
				// Ordenna la lista
				Collections.sort(cola);

				// mostrar cola ordenada
				System.out.println("\nCOLA ORDENADA:");
				for (Persona p : cola) {
					System.out.println(p);
				}
				break;
			case 3:
				if (cola.size() < 4) {
					System.out.println("NO HAY SUFICIENTES PERSONAS");
					break;
				}
				int ocupados = 0;
				while (ocupados < 4) {
					Persona p = cola.remove(0);
					try {
						p.comprobarAltura();
						double dinero = p.pagar();
						System.out.println("PAGA: " + dinero);
						atraccion[ocupados] = p;
						ocupados++;
					} catch (error e) {

						System.out.println("PERSONA RECHAZADA: " + e.getMessage());
					}
				}
				break;
			case 4:
				Persona[] atraccion1 = new Persona[4];
				boolean llena = true;

				for (int i = 0; i < atraccion1.length; i++) {
					if (atraccion1[i] == null) {
						llena = false;
					}
				}
				if (!llena) {
					System.out.println("NO SE PUEDE INICIAR, NO ESTÁ LLENA");
					break;
				}

				boolean enMarcha = true;
				System.out.println("ATRACCIÓN EN MARCHA");
				break;
			case 5:
				boolean enMarcha1 = false;

				if (!enMarcha1) {
					System.out.println("LA ATRACCIÓN NO ESTÁ EN MARCHA");
					break;
				}

				for (int i = 0; i < atraccion.length; i++) {

					if (atraccion[i] instanceof entradaBono) {

						entradaBono b = (entradaBono) atraccion[i];

						if (b.getViajes() > 0) {
							cola.add(b);
						}
					}

					atraccion[i] = null;
				}

				enMarcha1 = false;
				System.out.println("ATRACCIÓN PARADA");

				break;
			}

		} while (opc != 7);

		System.out.println("FIN");

	}

}
