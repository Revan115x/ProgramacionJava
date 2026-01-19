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
		 * - Método “rebajar” que rebaja el precio de venta en una cantidad pasada como parámetro, (el precio de venta nunca puede ser menor que
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

		Almacen s1 = new Almacen("Manzanas", "Chile", 1000, 2.5, 1.5);
		Almacen s2 = new Almacen("Naranjas", "España", 500, 3.0, 2.0);
		System.out.println(s1.getNombre());
		System.out.println(s2.toString());
		
		
	}

}
