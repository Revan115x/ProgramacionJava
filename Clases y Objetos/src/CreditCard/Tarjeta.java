package CreditCard;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarjeta {
	
	private String NumeroTarjeta;
	private String Titular;
	private String pin;
	private Double credito;
	private int mes,año;
	
	public Tarjeta(String numeroTarjeta, String titular, String pin, Double credito, int mes, int año) {
		super();
		NumeroTarjeta = numeroTarjeta;
		Titular = titular;
		this.pin = pin;
		this.credito = credito;
		this.mes = mes;
		this.año = año;
	}

	public boolean Pagar(String contraseña,double pago,int M, int A) {
	
		if(!contraseña.matches(pin)) {
			System.out.println("no cumple ");
			return false;
		}
		if(!contraseña.equals(pin)) {
			System.out.println("Contraseña incorrecta");
			return false;
		}
		if(M==mes ) {
			System.out.println("mes caducada");
			return false;
		}
		if(A==año) {
			System.out.println("año caducada");
			return false;
		}
		if(pago>credito) {
			System.out.println("NO tienes suficiente dinero");
			return false;
		}
		return true;
	}
	
}
