package modelos;

import java.time.LocalDate;

public class Tarjeta {
	private int numero;
	private int numeroCuenta;
	private String titular;
	private double limite;
	private String tipo;
	private LocalDate caducidad;
	private String clave;
	private int bloqueada;
	
	
	public Tarjeta(int numero, int numeroCuenta, String titular, double limite, String tipo, LocalDate caducidad,
			String clave, int bloqueada) {
		super();
		this.numero = numero;
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.limite = limite;
		this.tipo = tipo;
		this.caducidad = caducidad;
		this.clave = clave;
		this.bloqueada = bloqueada;
	}

	// Para Tarjetas de CREDITO
	public Tarjeta(int numero, int numeroCuenta, String titular,double limite, String clave) {
		super();
		this.numero = numero;
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.limite = limite;
		this.clave = clave;
		tipo="C";
		caducidad=LocalDate.now().plusYears(1);
		bloqueada=0;
	}
	
	
   //  Para tarjetas de DEBITO
	public Tarjeta(int numero,int numeroCuenta, String titular, String clave) {
		super();
		this.numero=numero;
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.clave = clave;
		limite=0;
		tipo="D";
		caducidad=LocalDate.now().plusMonths(6);
		bloqueada=0;
		
	}

	public int getNumero() {
		return numero;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public String getTitular() {
		return titular;
	}

	public double getLimite() {
		return limite;
	}

	public String getTipo() {
		return tipo;
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public String getClave() {
		return clave;
	}

	public int getBloqueada() {
		return bloqueada;
	}

	
	
	
	
	
	
}
