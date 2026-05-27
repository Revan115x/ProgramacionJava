package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class nota {

	@Test 
	void esValidaNota() {
		assertAll(
				()-> assertTrue(main.esValidaNota(5)),
				()-> assertFalse(main.esValidaNota(-1))
				);
	}
	
	@Test 
	void calcularMedia() {
		assertAll(
				()-> assertEquals(-1,main.calcularMedia(5, 7, 11)),
				()->assertEquals(5,main.calcularMedia(5, 5, 5))
				);
	}

}
