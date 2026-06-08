package ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
/*Código java que invierte un número dado, teniendo en cuenta que para que pueda
invertirse tendrá como mínimo 2 cifras. Sólo tendremos en cuenta números positivos
de 4 cifras máximo. Si la entrada no es correcta, la salida debe ser un mensaje de
ERROR...(-1). El número invertido será también un número entero.*/
	@Test//numeros de dos digitos
	void invertirNumerotest1() {
		assertAll(
				()-> assertEquals(21, App.invertirNumero(12)),
				()-> assertEquals(54, App.invertirNumero(45)),
				()-> assertEquals(89, App.invertirNumero(98))
				);
	}
	@Test//numeros de tres digitos
	void invertirNumerotest2() {
		assertAll(
				()-> assertEquals(123, App.invertirNumero(321)),
				()-> assertEquals(678, App.invertirNumero(876)),
				()-> assertEquals(199, App.invertirNumero(991))
				);
	}
	@Test//numeros de cuatro digitos
	void invertirNumerotest3() {
		assertAll(
				()-> assertEquals(1123, App.invertirNumero(3211)),
				()-> assertEquals(1678, App.invertirNumero(8761)),
				()-> assertEquals(1199, App.invertirNumero(9911))
				);
	}

	@Test//numeros negativos
	void invertirNumerotest4() {
		assertAll(
				()-> assertEquals(-1, App.invertirNumero(-91)),
				()-> assertEquals(-1, App.invertirNumero(-876)),
				()-> assertEquals(-1, App.invertirNumero(-991))
				);
	}
	
	//el metodo numeroCifras tiene un error de logica
	
}
