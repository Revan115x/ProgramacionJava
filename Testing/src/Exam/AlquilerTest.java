package Exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class AlquilerTest {
	
	@Test//INtroducimos datos validos
	void alquilerTest1() {
		Alquiler s1=new Alquiler ("9873MVH", "SED", "TOYOTA",1 );
		Alquiler s2=new Alquiler ("43R2DRF", "HONDA", "HILUX",2);
		Alquiler s3=new Alquiler ("345IKJ", "SEDA", "FERRARI",1 );
		Alquiler s4=new Alquiler ("2345KJH", "HONDA", "MITSUBISHIT",2 );
		Alquiler s5=new Alquiler ("245IKJ", "SEDA", "FERRARI",1 );
		Alquiler s6=new Alquiler ("1345KJH", "HONDA", "MITSUBISHIT",2 );
		
		assertAll( 
				//categoria1
				()-> assertEquals(45, s1.alquiler(1)), 
				()-> assertEquals(90, s3.alquiler(2)), 
				()-> assertEquals(120, s5.alquiler(4)), 
				
				//categoria 2
				()-> assertEquals(50, s4.alquiler(1)),
				()-> assertEquals(100, s2.alquiler(2)), 
				()-> assertEquals(160, s4.alquiler(4))

				
				);
		
		
		//Volvemos a intentar alquilar el coche
		assertAll( 
				()-> assertEquals(0, s1.alquiler(2)), 
				()-> assertEquals(0, s4.alquiler(4))
				

				);
	}
	
	@Test//Introducimos dias negativos
	void alquilerTest2() {
		Alquiler s1=new Alquiler ("9873MVH", "SED", "TOYOTA",1 );
		Alquiler s2=new Alquiler ("43R2DRF", "HONDA", "HILUX",2);
	
		
		//comprobamos que se verifique que los dias sean positivos
		assertAll( 
				()-> assertEquals(-1, s1.alquiler(-3)), 
				()-> assertEquals(-1,  s2.alquiler(-4)),
				()-> assertEquals(-1,  s1.alquiler(0))
				);
		
		
	//EN LA CATEGORIA DOS HAY UN ERROR DE CALCULO CON DOS DIAS ´
	//

}
	
	
	
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

