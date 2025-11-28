package EjemplosClaseVariados;

public class ejCast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=7;
		float otro;
		double d=3.89;
		/*
		conversión implícita
		otro=num;
		System.out.println("Otro:"+otro);
		d=num;
		System.out.println("d:"+d);
		*/
		// conversión explícita
		num=(int)d;
		System.out.println("num:"+num);
		
		//d=(double)5/2;
		d=5.0/2;
		System.out.println("d:"+d);

	}

}
