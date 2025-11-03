package ClaseString;

public class ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cadena="hola estoy estudiando";
		
		System.out.println("Caracter de la posición 0:" + cadena.charAt(0));
		System.out.println("Caracter de la posición 2:" + cadena.charAt(2));
		//System.out.println("Caracter de la posición 2:" + cadena.charAt(8));
		for(int i=0; i<cadena.length(); i++) {
			System.out.println(cadena.charAt(i));
		}
		
		int pos=cadena.indexOf("es",10);
		System.out.println("Cadena encontrada en la posición:"+pos);
		
	}

}
