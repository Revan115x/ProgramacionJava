package ejbasicos;

public class ejemplo {

	public static void main(String[] args) {
		
		int primero,division,resto,multiplicacion;
		final int segundo;
		final double PI=3.1416;
		
		primero=7;
		segundo=2;

		primero+=1;
		
		//primero=primero+1;
		
		division=primero/segundo;
		
		System.out.println("\tla division\n es "+ division);
		
		resto=primero%segundo;
		System.out.println("el resto es "+ resto);
		
		multiplicacion=primero*segundo;
		System.out.println("la multiplicacion es "+ multiplicacion);

	}

}
