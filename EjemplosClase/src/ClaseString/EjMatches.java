package ClaseString;

public class EjMatches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "aba23wÑprHerw";
		String regex = "[a-zA-Z\\ñ\\Ñ0-9]+"; // Expresión regular para uno o más dígitos
		if (cadena.matches(regex)) {
			System.out.println("La cadena verifica la expresión regular.");
		} else {
			System.out.println("No la verifica");
		}
	}

}
