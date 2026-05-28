package Mesa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class mesaTest {

	@Test
	//Datos Validos
	void realizar_pedido() {
		Mesa m1=new Mesa (2);
		Mesa m2=new Mesa (1);
		Mesa m3=new Mesa (4);
		
		
		//DEVOLVERIA FALSE
		assertAll(
				()-> assertFalse(m1.realizar_pedido(0, 0)),
				()-> assertFalse(m2.realizar_pedido(1, 0)),//Error devuelve true cuando no has pedido un min de racion
				()-> assertFalse(m3.realizar_pedido(0, -1)),
				()-> assertFalse(m3.realizar_pedido(-1, 0)),
				()-> assertFalse(m3.realizar_pedido(-1, -1)),
				
				
		//DEVOLVERIA TRUE
				()-> assertTrue(m1.realizar_pedido(1, 1)),
				()-> assertTrue(m2.realizar_pedido(4, 6)),
				()-> assertTrue(m3.realizar_pedido(10, 1)),
				
				()-> assertTrue(m1.realizar_pedido(1, 0)),
				()-> assertTrue(m2.realizar_pedido(0, 1)),/*devuelve false aun pidiendo racion*/
				()-> assertTrue(m3.realizar_pedido(0, 10))/*devuelve false aun pidiendo racion*/
				
				);
		
		Mesa m11=new Mesa (2);
		Mesa m21=new Mesa (1);
		Mesa m31=new Mesa (3);
		Mesa m33=new Mesa (0); //no comensales
		
		
		//positivos
		m11.realizar_pedido(0, 0);
		m21.realizar_pedido(1,2);
		m31.realizar_pedido(3,1);
		m33.realizar_pedido(1, 1);
		
		//COMPROBAR QUE DA BIEN
		assertAll(
				()->assertEquals(0, m11.pagar()),
				()->assertEquals(31, m21.pagar()),//Devuelve 30 cuando beberia ser 31
				()->assertEquals(45, m31.pagar())
				);
	
		
		//negativos
		m11.realizar_pedido(0, -3);
		m21.realizar_pedido(-1,2);
		m31.realizar_pedido(3,-3);
		
		//COMPROBAR QUE DA BIEN EN NEGATIVO
		assertAll(
				()->assertEquals(0, m11.pagar()),
				()->assertEquals(30, m21.pagar()),
				()->assertEquals(0, m31.pagar()),
				()->assertEquals(0, m33.pagar())
				
				);
		
	}

}
