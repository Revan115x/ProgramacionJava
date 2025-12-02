package EjemploCasting;

public class casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=7;
		long b=8;
		double c=23.5;
		char letra='f';
		int l=102;
		
		b=a;
		a=(int)b;
		
		//c=a;
		a=(int)c;
		
		System.out.println(a);
		System.out.println(letra);
		System.out.println((int)letra);
		System.out.println((char)l);
		
		/*
		 * • parseInt(String cad) : Convierte un String en número, si no es posible lanza una Excepción Ej.
			Integer.parseInt(“123”); →123
			• toBinaryString(int n): Devuelve una cadena con el número en binario.
			Ej.
			Integer.toBinaryString(5); →”101”;
			• toHexString(int n): Devuelve una cadena con el número en hexadecimal.
			Ej.
			Integer.toHexString(28); →”1C”
			Clase Double:
			• parseDouble(String cad) : Convierte un String en número, si no es posible lanza una
			Excepción
			Ej.
			Integer.parseInt(“123.56”); →123.56*/
	}

}
