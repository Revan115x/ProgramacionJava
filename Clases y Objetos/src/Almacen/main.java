package Almacen;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * En un almacén se guarda fruta para su posterior venta. Por cada cargamento se
		 * tiene la siguiente información: nombre de la fruta, procedencia, número de
		 * kilos, precio coste por kilo y precio venta por kilo. Codificar una clase
		 * para manejar esta información de forma que contenga las siguientes
		 * operaciones: - Constructor 
		 * 
		 * - Método que devuelva la información de cadacargamento de fruta. 
		 * - Método “rebajar” que rebaja el precio de venta en una cantidad pasada como parámetro, 
		 *   (el precio de venta nunca puede ser menor que
		 * el precio de coste). 
		 * - Método “vender”: se le pasa el número de kilos a vender y si hay suficiente cantidad, 
		 * se decrementa el número de kilos y se devuelve el importe de la venta, sino da error. 
		 * - Método que nos diga si dos cargamentos de fruta tienen la misma procedencia. 
		 * - Llevar en todo momento el beneficio obtenido por el almacén. 
		 * 
		 * Para probar dicha clase hacer un main que:
		 * - Dé de alta 3 cargamentos y muestre su información. 
		 * - Diga si los dos primeros tienen la misma procedencia. 
		 * - Rebaje el precio del tercero. 
		 * - Realice ventas de los tres cargamentos. 
		 * - Muestre el beneficio obtenido por el almacén.
		 */

		Almacen s1 = new Almacen("Manzanas", "España", 1000, 2.5, 1.5);
		Almacen s2 = new Almacen("Naranjas", "España", 500, 3.0, 2.0);
		
		
		/*/*información de cadacargamento de fruta*/
		System.out.println("Informacion Cargamento :"+ s1.Infocargemento());
		
		
		/*Rebajar precio a fruta*/
		s1.rebajar(0.3);
		
		System.out.println("Precio despues de rebajar "+ s1.getPrecioV());
		
		
		/*Vender fruta*/
		double venta1 = s1.vender(200); // vendemos 200 kg de s1
		double venta2 = s2.vender(100); // vendemos 100 kg de s2
		System.out.println("Venta 1: " + venta1 + " €");
		System.out.println("Venta 2: " + venta2 + " €");

		
		/*Comparar si tienen la misma procedencia*/
		if(s1.mismaProcedencia(s2))
			System.out.println("si tienen la misma procedencia");
		else
			System.out.println("no tienen la misma procedencia");
			
		System.out.println("Beneficio total del almacén: " + Almacen.getBeneficio() + " €");

		
	}

}
