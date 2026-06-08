package ejercicio_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraFinancieraTest {

	@Test
	void aplicarDescuentotest() {
		assertAll (
		()->assertEquals(9.5,CalculadoraFinanciera.aplicarDescuento(10, 5)),
		()->assertEquals(14.9265,CalculadoraFinanciera.aplicarDescuento(15.5, 3.7)), 
		()->assertEquals(-1,CalculadoraFinanciera.aplicarDescuento(-5,3)),
		()->assertEquals(-1,CalculadoraFinanciera.aplicarDescuento(7,-3)),
		()->assertEquals(-1,CalculadoraFinanciera.aplicarDescuento(0,8)),
		()->assertEquals(-1,CalculadoraFinanciera.aplicarDescuento(8,0))
);
	}
	//si el precio es negativo se calcula el descuento
	//no esta validando el precio
	//si el descuentoes negativo se calcula el nuevo precio
		//no esta validando el descuento
	@Test
	void convertirDolaresAEurostest() {
		assertAll (
				()->assertEquals(86.00, CalculadoraFinanciera.convertirDolaresAEuros(100, 0.86)),
				()->assertEquals(96.32, CalculadoraFinanciera.convertirDolaresAEuros(112, 0.86)),
				()->assertEquals(-1, CalculadoraFinanciera.convertirDolaresAEuros(-70, 0.86)), 
				()->assertEquals(-1, CalculadoraFinanciera.convertirDolaresAEuros(70, -0.86))

 );
		//el casting a int en la funcion hace que la conversion no sea precisa del todo
		//no se comprueba que el valor introducido sea positivo
	}
	@Test
	void categorizarInversiontest() {
		assertAll (
				
			()->assertEquals("Baja",  CalculadoraFinanciera.categorizarInversion(700)),
			()->assertEquals("Alta",  CalculadoraFinanciera.categorizarInversion(1200)),
			()->assertEquals("Alta",  CalculadoraFinanciera.categorizarInversion(1000))

);
	}
	//el valor 1000 no esta contemplado, por lo cual el programa devolvera null
}
