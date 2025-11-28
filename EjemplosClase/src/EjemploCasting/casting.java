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
	}

}
