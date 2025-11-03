package ejemplosClase.ejemplos;

public class EjCast2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//float f=5.4F;
		float f=(float)5.4;
		char letra='m';
		int nletra=letra;
		
		System.out.println("f:"+f);
		System.out.println("letra:"+letra);
		System.out.println("nletra:"+nletra);
		
		// Esto es lo mismo que preguntar if (letra=='a')
		if (letra==97)
			System.out.println("Es la letra a");
		if (letra>=97 && letra<=122)
		//if (letra>='a' && letra<='z')
			System.out.println("Es una letra en minúsculas");
		else
			System.out.println("No es una letra en minúsculas");

	}

}
