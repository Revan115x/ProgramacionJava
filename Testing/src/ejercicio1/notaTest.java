package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class notaTest {

	@Test//casos de numeros negativos
	void esValidaNotaTest1() {
		assertAll(
				()->  assertFalse(main.esValidaNota(-1)),
				() -> assertFalse(main.esValidaNota(-7))

				);
	}
		@Test//casos de numeros validos
		void esValidaNotaTest2() {
			assertAll(
					()->  assertTrue(main.esValidaNota(0)),
					() -> assertTrue(main.esValidaNota(5)),
					() -> assertTrue(main.esValidaNota(10))
					);	
	}
		@Test//casos de numeros positivos fuera de norma
		void esValidaNotaTest3() {
			assertAll(
					()->  assertFalse(main.esValidaNota(11)),
					() -> assertFalse(main.esValidaNota(15)),
					() -> assertFalse(main.esValidaNota(20))
					);
		
		
	}

}
