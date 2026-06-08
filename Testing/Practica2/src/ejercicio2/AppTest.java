package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
	/*
	 * SE PRUEBA DANDO POR SENTADO QUE PRECIO Y EDAD SERAN VALIDADOS
	 * ANTES DE LLAMAR A LA FUNCION
	 * 
	 * SE DETECTA FALTA DE REQUISITO FUNCIONAL CUANDO EDAD=65, NO SE PROGRAMA EL TEST
	 * 
	 * SE ASUME QUE LA FUNCION RETORNA EL PRECIO CON DESCUENTO
	 * */
	@Test//casos de edades de 0 al 18
	void tcalcularDescuentoTest1() {
		assertAll(
				()-> assertEquals(10, App.calcularDescuento(20, 0)), 
				()-> assertEquals(10, App.calcularDescuento(20, 10)), 
				()-> assertEquals(10, App.calcularDescuento(20, 18))
				);
		
	}
	@Test//casos de edades de 18 a 65
	void tcalcularDescuentoTest2() {
		assertAll(
				
				()-> assertEquals(4, App.calcularDescuento(20, 18)), 
				()-> assertEquals(4, App.calcularDescuento(20, 33)), 
				()-> assertEquals(4, App.calcularDescuento(20, 65))
				);
		
	}
	//Confuxion con la edad 18 por estar en dos if case al mismo tiempo 
	@Test//casos de edades de 65 pa alante
	void tcalcularDescuentoTest3() {
		assertAll(
				()-> assertEquals(8, App.calcularDescuento(20, 66)), 
				()-> assertEquals(8, App.calcularDescuento(20, 75)), 
				()-> assertEquals(8, App.calcularDescuento(20, 99))
				);
		
	}
}
