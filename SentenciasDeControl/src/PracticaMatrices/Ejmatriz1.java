package PracticaMatrices;
import java.util.Random;
import java.util.Scanner;

public class Ejmatriz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int FILAS=3, COLUM=3;
		int max=Integer.MIN_VALUE;
		int matriz[][] = new int[FILAS][COLUM];
		Random r=new Random();

		Scanner sc = new Scanner(System.in);

		for (int f = 0; f < FILAS; f++)
			for (int c = 0; c < COLUM; c++) {
				System.out.println("Anota celda[" + f + "][" + c + "]=");
				//matriz[f][c] = sc.nextInt();
				matriz[f][c]=r.nextInt(10)+1;
				
			}

		for (int f = 0; f < FILAS; f++) {
			for (int c = 0; c < COLUM; c++) {
				System.out.print("\t" + matriz[f][c]);
			}
			System.out.println();
		}
		
		for (int f = 0; f < FILAS; f++)
			for (int c = 0; c < COLUM; c++) {
				if (max<matriz[f][c])
					max=matriz[f][c];
			}
		
		System.out.println("El valor mayor es:"+max);

	}

}
