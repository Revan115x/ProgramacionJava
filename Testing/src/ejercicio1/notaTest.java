package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class notaTest {

	void esValidaNota() {
		assertAll(
				()-> assertTrue(main.esValidaNota(5))
				);
	}
	
}
