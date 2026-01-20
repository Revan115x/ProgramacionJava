package refactorizar_1;

import java.util.Scanner;

public class Principal {

	private static final int TAM = 20;
	private static final double PI = 3.14;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double x=3,y=5;
		double s=x+y+PI;
		int LnotasP[]=new int[TAM];
		int lnotasBD[]=new int[TAM];
		
		notas(sc, LnotasP);
		notas(sc, lnotasBD);
		
		for (int i=0;i<TAM;i++) {
			System.out.println("Notas Programacion:"+LnotasP[i]);
		}
		
		notasbd(lnotasBD);
		
		
		String k = "Resultado:";
		System.out.println(k+s);
		double r=x-y-PI;
		System.out.println(k+r);
		double p=x*y*PI;
		System.out.println(k+p);
		int w=6;
		boolean z=true;
		for (int i=2;i<w;i++) {
	    	   if (w%i==0)
	    		   z=false;
	       }
	       
	        if (z) {
	            System.out.println("Number is Prime");
	        } else {
	            System.out.println("Number is Not Prime");
	        }
	        

		
		
	}

	private static void notasbd(int[] lnotasBD) {
		for (int i=0;i<TAM;i++) {
			System.out.println("Notas BBDD:"+lnotasBD[i]);
		}
	}

	private static void notas(Scanner sc, int[] LnotasP) {
		for(int i=0;i<TAM;i++) {
			LnotasP[i]=sc.nextInt();
		}
	}
	
	

}
