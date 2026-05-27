package Exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GananciasTest {

	@Test//IComprobar las ganancias
	void alquilerTest3() {
		Alquiler s1=new Alquiler ("9873MVH", "SED", "TOYOTA",1 );
		Alquiler s2=new Alquiler ("43R2DRF", "HONDA", "HILUX",2);

		
		assertAll( 

				()-> assertEquals(45, s1.alquiler(1)), 
				()-> assertEquals(100, s2.alquiler(2))
				
				);

		s1.devolver();
		s2.devolver();
		assertAll( 
				()-> assertEquals(45, s1.alquiler(1)), 
				()-> assertEquals(100, s2.alquiler(2))
				);
		
		assertAll( 
				()-> assertEquals(90, s1.getGananciasVeh()), 
				()-> assertEquals(200, s2.getGananciasVeh())
				

				);
		
	}
	//Solo se guarda el precio del alquiler mas reciente como ganancias, 
	//no se acumula 
}
