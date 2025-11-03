package ClaseString;

public class ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena="Hola";
		String cadena2="Vamonos";
		//String cadena=new String("Esta es una cadena");
		String resultado="";
		/*
		System.out.println("Valor de resultado:"+resultado);
		
		System.out.println("Mi cadena:"+cadena);
		resultado=cadena.toUpperCase();
		System.out.println(resultado);
		System.out.println("La cadena original es:"+cadena);
		System.out.println("La longitud de la cadena es:"+ cadena.length());
		resultado = cadena + " estoy concatenando cadenas";
		System.out.println(resultado);
		*/
		
		if (cadena.equalsIgnoreCase(cadena2))
			System.out.println("Son iguales");
		else
			System.out.println("Son distintas");
		
		if (cadena.equals("FIN")) // "FIN".equals(cadena)
			System.out.println("En la cadena pone fin");
		else
			System.out.println("En la cadena no pone fin");
		
		int num=cadena.compareToIgnoreCase(cadena2);
		System.out.println("Al comparar, compareTo me devuelve:"+num);
		if (num==0)
			System.out.println("son iguales");
		else
			if (num<0)
				System.out.println(cadena + " va antes que "+ cadena2);
			else
				System.out.println(cadena2 + " va antes que "+ cadena);
		
		resultado=cadena2.substring(3, 6);
		
		System.out.println("Resultado de substring:"+resultado);

	}

}
