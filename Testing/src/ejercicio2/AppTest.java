package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
 
	@Test
	void calcularDescuento() {
		assertAll(
				()->assertEquals(9.5,App.calcularDescuento(10, 18)),
				()->assertEquals(9.8, App.calcularDescuento(10, 20)),
				()->assertEquals(9.6, App.calcularDescuento(10, 70)) 
				);
	}
	
}
