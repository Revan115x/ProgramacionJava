package Mesa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Mesaganancia {

	@Test
	void realizar_pedido() {
		Mesa m1=new Mesa (2);
		Mesa m2=new Mesa (1);
		Mesa m3=new Mesa (3);
		
		
		//positivos
		m1.realizar_pedido(0, 0);
		m2.realizar_pedido(1,2);
		m3.realizar_pedido(3,1);
		
		//COMPROBAR QUE DA BIEN
		assertAll(
				()->assertEquals(0, m1.pagar()),
				()->assertEquals(31, m2.pagar()),//Devuelve 30 cuando beberia ser 31
				()->assertEquals(45, m3.pagar())
				);
	
		
		//negativos
		m1.realizar_pedido(0, -3);
		m2.realizar_pedido(-1,2);
		m3.realizar_pedido(3,-3);
		
		//COMPROBAR QUE DA BIEN EN NEGATIVO
		assertAll(
				()->assertEquals(0, m1.pagar()),
				()->assertEquals(30, m2.pagar()),
				()->assertEquals(0, m3.pagar())
				
				);
		
		
	}
	
}
