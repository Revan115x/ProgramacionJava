package ejercicio4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void PotenciaTest1() {
		assertAll(
				()-> assertEquals(1,App.potencia(3, 0)),
				()-> assertEquals(-1,App.potencia(0, 0)),
				()-> assertEquals(0.5,App.potencia(2, -1)),
				()-> assertEquals(1,App.potencia(-1, 4)),
				()-> assertEquals(64,App.potencia( 4, 3))
		);
	}
//se debe revisar el metodo potencia, ya que no calcula correctamete 
	//el ultimo caso expècificado
}
