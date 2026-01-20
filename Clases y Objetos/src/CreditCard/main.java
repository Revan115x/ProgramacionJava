package CreditCard;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Tarjeta cliente1=new Tarjeta("1","Jose","5436",150.0,10,26);
		
		if(cliente1.Pagar("5436",150.0,10,23)) {
			System.out.println("puedes pagar");
		}

	}

}

