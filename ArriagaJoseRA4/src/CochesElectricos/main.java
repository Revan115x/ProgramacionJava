package CochesElectricos;

import java.util.Scanner;

import TeatroJoan.Representacion;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int opc;
		String matricula;
		boolean alquilado = false, reservado = false;
		int cont = 0;
		CocheARR autos[] = new CocheARR[10];

		do {
			System.out.println("e--- MENU AUTOS ---");
			System.out.println("1. Registrar auto");
			System.out.println("2. Reservar auto Libre");
			System.out.println("3. Alquilar auto Reservado");
			System.out.println("4. Coches alquilado");
			System.out.println("5. Liberar autos");
			System.out.println("6. Salir");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {

			case 1:
				if (cont == autos.length) {
					System.out.println("no hay mas espacio");
				} else {
					System.out.println("Matricula");
					matricula = sc.nextLine();

					if (!matricula.matches("^[0-9]{4}[a-zA-Z]{3}$"))
						System.out.println("Matricula Incorrecta");

					System.out.println("alquilado");
					alquilado = sc.nextBoolean();

					if (alquilado == false) {
						System.out.println("Reservado");
						reservado = sc.nextBoolean();
					}
						autos[cont] = new CocheARR(matricula, alquilado, reservado);
						/*CocheARR autos[cont] = new CocheARR("0048AKC", false,false); */
						cont++;
				}
					break;
				
			case 2:
				int pos = 0;
				boolean correcto=false;
				if (cont == 0)
					System.out.println("no se ha dado de alta ninguna funcion por el momento");

				for (int i = 0; i < cont; i++) {
					System.out.println("AUTOS LIBRES");
					if (autos[i].alquilado() == 0) {
						pos = i;
						correcto=true;
						System.out.println(autos.toString()+" posicion :" + pos);
					}
				}
				if(correcto==false)
					System.out.println("no hay autos libres");
				
				correcto=false;
				
				do {
					try {
						System.out.println("DIME CUAL QUIERES RESERVAR");
						int num = sc.nextInt();
						correcto=true;
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} 
					
					/*NO HE PODIDO ACTUALIZAR LA POSICION DEL ARRAY A ALQUILADO*/
				} while (!correcto);
				break;
				
			case 4:
				/*NO ME DIO TIEMPO*/
				System.out.println("NUMERO MATRICULA");
				matricula=sc.nextLine();
				for (int i = 0; i < cont; i++) {
				int buscar=buscar(autos[i],matricula,cont);
					if (buscar.alquilado() == 2) {
						correcto=true;
						System.out.println(autos.toString());
					}
				}
				
				break;
			}
		} while (opc != 6);
	}

	public static int buscar(CocheARR autos[], String mat, int cont) {
		int pos = -1;

		for (int i = 0; i < cont; i++) {
			if (mat.equals(autos[i].getMatricula())) {
				pos = i;
				break;
			}
		}
		return pos;

	}
	
}
