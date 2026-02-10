package corregido;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coches coches[];
		int cont, opc, pos, estado;
		String mat, cod;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduce número de coches (2-10");
			cont = sc.nextInt();
		} while (cont < 2 || cont > 10);

		coches = new Coches[cont];
		sc.nextLine();

		for (int i = 0; i < cont; i++) {
			System.out.println("Introduce matricula: ");
			mat = sc.nextLine();
			if (mat.matches("[0-9]{4}[A-Z]{3}"))
				coches[i] = new Coches(mat);
			else {
				System.out.println("Matrícula incorrecta");
				i--;
			}
		}

		do {
			System.out.println("Elige una opcion: ");
			System.out.println("1.Reservar un vehículo.");
			System.out.println("2.Alquilar un vehículo reservado.");
			System.out.println("3.Acabar el trayecto con el vehículo.");
			System.out.println("4.Poner a libres a todos los vehículos.");
			System.out.println("5.Salir");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				for (int i = 0; i < cont; i++)
					if (coches[i].getEstado() == 0)
						System.out.println(coches[i].toString() + " " + i);

				try {
					System.out.println("Anota la posición del coche a reservar: ");
					pos = sc.nextInt();
					if (coches[pos].reservar() == null)
						System.out.println("No se ha podido reservar, estado incorrecto");
				} catch (InputMismatchException e) {
					System.out.println("No has anotado un número");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Posicion incorrecta");
				}

				System.out.println("Reserva terminada correctamente");
				break;
			case 2:
				for (int i = 0; i < cont; i++) {
					if (coches[i].getEstado() == 0)
						System.out.println(coches[i].toString() + " " + i);
				}

				System.out.println("Introduce matricula");
				mat = sc.nextLine();
				pos = buscar(coches, mat);
				if (pos == -1) {
					System.out.println("No existe ningun coche con esa matricula");
				} else {
					System.out.println("Anota codigo del vehiculo");
					cod = sc.nextLine();
					if (coches[pos].alquilar(cod))
						System.out.println("Coche alquilado con exito");
					else
						System.out.println("No se ha podido alquilar");
				}

				break;
			case 3:
				System.out.println("Introduce matricula");
				mat = sc.nextLine();
				pos = buscar(coches, mat);
				if (pos == -1) {
					System.out.println("El coche no existe");
				} else {
					double imp = coches[pos].estacionar();
					if (imp == 0)
						System.out.println("No se ha podido estacionar");
					else
						System.out.println("Tienes que pagar:" + imp);
				}
				break;
			case 4:
				liberar(coches);
				break;
			}
		} while (opc != 5);

		System.out.println(Coches.getAlquilados() + Coches.getReservados());

	}

	public static void liberar(Coches coches[]) {
		for (int i = 0; i < coches.length; i++) {
			coches[i].liberar();
		}
	}

	public static int buscar(Coches coches[], String mat) {
		for (int i = 0; i < coches.length; i++) {
			if (coches[i].getMatricula().equalsIgnoreCase(mat))
				return i;
		}
		return -1;
	}

}
